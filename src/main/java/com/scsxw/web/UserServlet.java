package com.scsxw.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import com.scsxw.entity.User;
import com.scsxw.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/back/user/*")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService service = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        
        String path = request.getPathInfo();
        
        switch (path) {
            case "/list":
                List<User> objs = service.selectAll();
                request.setAttribute("objs", objs);
                request.getRequestDispatcher("/back/user-list.jsp").forward(request, response);
                break;
            case "/delete":
                String id = request.getParameter("id");
                service.delete(Integer.parseInt(id));
                response.sendRedirect(request.getServletContext().getContextPath() + "/back/user/list");
                break;
            case "/add":
                request.setAttribute("obj", new User());
                request.getRequestDispatcher("/back/user-add.jsp").forward(request, response);
                break;
            case "/update":
                id = request.getParameter("id");
                User obj = service.selectById(Integer.parseInt(id));
                request.setAttribute("obj", obj);
                request.getRequestDispatcher("/back/user-add.jsp").forward(request, response);
                break;
            case "/save":
                obj = new User();
                obj.setUsername(request.getParameter("username"));
                obj.setPassword(request.getParameter("password"));
                obj.setNickname(request.getParameter("nickname"));
                obj.setEmail(request.getParameter("email"));
                obj.setRole(request.getParameter("role"));
                obj.setAvatar(request.getParameter("avatar"));
                String statusStr = request.getParameter("status");
                obj.setStatus(statusStr != null ? Integer.parseInt(statusStr) : 1);
                
                id = request.getParameter("id");
                if (id != null && !id.trim().equals("") && !"null".equals(id.trim()) && !"0".equals(id.trim())) {
                    obj.setId(Long.parseLong(id));
                    User old = service.selectById(Integer.parseInt(id));
                    if(old != null) {
                        obj.setRegisterTime(old.getRegisterTime());
                        obj.setLastLoginTime(old.getLastLoginTime());
                    }
                    obj.setUpdateTime(LocalDateTime.now());
                    service.update(obj);
                } else {
                    obj.setRegisterTime(LocalDateTime.now());
                    obj.setUpdateTime(LocalDateTime.now());
                    service.add(obj);
                }
                response.sendRedirect(request.getServletContext().getContextPath() + "/back/user/list");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
