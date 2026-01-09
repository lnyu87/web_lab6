package com.scsxw.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import com.scsxw.entity.PoetryType;
import com.scsxw.service.PoetryTypeService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/back/poetry-type/*")
public class PoetryTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PoetryTypeService service = new PoetryTypeService();

    public PoetryTypeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        
        String path = request.getPathInfo();
        
        switch (path) {
            case "/list":
                List<PoetryType> objs = service.selectAll();
                request.setAttribute("objs", objs);
                request.getRequestDispatcher("/back/poetry-type-list.jsp").forward(request, response);
                break;
            case "/delete":
                String id = request.getParameter("id");
                service.delete(Long.parseLong(id));
                response.sendRedirect(request.getServletContext().getContextPath() + "/back/poetry-type/list");
                break;
            case "/add":
                request.setAttribute("obj", new PoetryType());
                request.getRequestDispatcher("/back/poetry-type-add.jsp").forward(request, response);
                break;
            case "/update":
                id = request.getParameter("id");
                PoetryType obj = service.selectById(Long.parseLong(id));
                request.setAttribute("obj", obj);
                request.getRequestDispatcher("/back/poetry-type-add.jsp").forward(request, response);
                break;
            case "/save":
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                if (name == null || name.trim().equals("")) {
                    response.sendRedirect(request.getServletContext().getContextPath() + "/back/poetry-type/add");
                    return;
                }
                obj = new PoetryType();
                obj.setName(name);
                obj.setDescription(description);
                obj.setUpdateTime(LocalDateTime.now());
                
                id = request.getParameter("id");
                if (id != null && !id.trim().equals("") && !"null".equals(id.trim()) && !"0".equals(id.trim())) {
                    obj.setId(Long.parseLong(id));
                    service.update(obj);
                } else {
                    obj.setCreateTime(LocalDateTime.now());
                    service.add(obj);
                }
                response.sendRedirect(request.getServletContext().getContextPath() + "/back/poetry-type/list");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
