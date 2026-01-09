package com.scsxw.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import com.scsxw.entity.Author;
import com.scsxw.service.AuthorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/back/author/*")
public class AuthorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AuthorService service = new AuthorService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        
        String path = request.getPathInfo();
        
        switch (path) {
            case "/list":
                List<Author> objs = service.selectAll();
                request.setAttribute("objs", objs);
                request.getRequestDispatcher("/back/author-list.jsp").forward(request, response);
                break;
            case "/delete":
                String id = request.getParameter("id");
                service.delete(Long.parseLong(id));
                response.sendRedirect(request.getServletContext().getContextPath() + "/back/author/list");
                break;
            case "/add":
                request.setAttribute("obj", new Author());
                request.getRequestDispatcher("/back/author-add.jsp").forward(request, response);
                break;
            case "/update":
                id = request.getParameter("id");
                Author obj = service.selectById(Long.parseLong(id));
                request.setAttribute("obj", obj);
                request.getRequestDispatcher("/back/author-add.jsp").forward(request, response);
                break;
            case "/save":
                obj = new Author();
                obj.setName(request.getParameter("name"));
                obj.setDynasty(request.getParameter("dynasty"));
                obj.setPic(request.getParameter("pic")); // Need upload handling later? Assuming url text for now
                obj.setBirthYear(request.getParameter("birthYear"));
                obj.setDeathYear(request.getParameter("deathYear"));
                obj.setAlias(request.getParameter("alias"));
                obj.setBiography(request.getParameter("biography"));
                obj.setRepresentativeWorks(request.getParameter("representativeWorks"));
                obj.setUpdateTime(LocalDateTime.now());
                
                id = request.getParameter("id");
                if (id != null && !id.trim().equals("") && !"null".equals(id.trim()) && !"0".equals(id.trim())) {
                    obj.setId(Long.parseLong(id));
                    service.update(obj);
                } else {
                    obj.setCreateTime(LocalDateTime.now());
                    service.add(obj);
                }
                response.sendRedirect(request.getServletContext().getContextPath() + "/back/author/list");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
