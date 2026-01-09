package com.scsxw.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import com.scsxw.entity.Poetry;
import com.scsxw.entity.Author;
import com.scsxw.entity.PoetryType;
import com.scsxw.entity.PoetryTheme;
import com.scsxw.service.PoetryService;
import com.scsxw.service.AuthorService;
import com.scsxw.service.PoetryTypeService;
import com.scsxw.service.PoetryThemeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/back/poetry/*")
public class PoetryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PoetryService service = new PoetryService();
    private AuthorService authorService = new AuthorService();
    private PoetryTypeService typeService = new PoetryTypeService();
    private PoetryThemeService themeService = new PoetryThemeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        
        String path = request.getPathInfo();
        
        switch (path) {
            case "/list":
                List<Poetry> objs = service.selectAll();
                request.setAttribute("objs", objs);
                request.getRequestDispatcher("/back/poetry-list.jsp").forward(request, response);
                break;
            case "/delete":
                String id = request.getParameter("id");
                service.delete(Long.parseLong(id));
                response.sendRedirect(request.getServletContext().getContextPath() + "/back/poetry/list");
                break;
            case "/add":
                request.setAttribute("obj", new Poetry());
                loadDropdowns(request);
                request.getRequestDispatcher("/back/poetry-add.jsp").forward(request, response);
                break;
            case "/update":
                id = request.getParameter("id");
                Poetry obj = service.selectById(Long.parseLong(id));
                request.setAttribute("obj", obj);
                loadDropdowns(request);
                request.getRequestDispatcher("/back/poetry-add.jsp").forward(request, response);
                break;
            case "/save":
                save(request, response);
                break;
        }
    }

    private void loadDropdowns(HttpServletRequest request) {
        request.setAttribute("authors", authorService.selectAll());
        request.setAttribute("types", typeService.selectAll());
        request.setAttribute("themes", themeService.selectAll());
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Poetry obj = new Poetry();
        obj.setTitle(request.getParameter("title"));
        obj.setContent(request.getParameter("content"));
        obj.setDynasty(request.getParameter("dynasty"));
        obj.setPic(request.getParameter("pic"));
        obj.setNotes(request.getParameter("notes"));
        
        String authorId = request.getParameter("authorId");
        if(authorId != null && !authorId.isEmpty()) {
            obj.setAuthorId(Long.parseLong(authorId));
            Author a = authorService.selectById(obj.getAuthorId());
            if(a != null) obj.setAuthorName(a.getName());
        }
        
        String typeId = request.getParameter("typeId");
        if(typeId != null && !typeId.isEmpty()) obj.setTypeId(Long.parseLong(typeId));
        
        String themeId = request.getParameter("themeId");
        if(themeId != null && !themeId.isEmpty()) obj.setThemeId(Long.parseLong(themeId));
        
        obj.setUpdateTime(LocalDateTime.now());
        
        String id = request.getParameter("id");
        if (id != null && !id.trim().equals("") && !"null".equals(id.trim()) && !"0".equals(id.trim())) {
            obj.setId(Long.parseLong(id));
            // Should preserve counts if they are not in form? Or let them be 0/null?
            // Since we are creating new object, counts will be null/0. 
            // In a real app we might want to fetch old object and update only changed fields.
            // For now, let's assume update doesn't reset counts or we don't care about counts in back office.
            // Wait, if I update, I should probably preserve counts.
            // Let's fetch old object first if updating.
            Poetry old = service.selectById(obj.getId());
            if(old != null) {
                obj.setLikeCount(old.getLikeCount());
                obj.setViewCount(old.getViewCount());
                obj.setCollectCount(old.getCollectCount());
                obj.setCommentCount(old.getCommentCount());
                obj.setCreateTime(old.getCreateTime());
            }
            service.update(obj);
        } else {
            obj.setCreateTime(LocalDateTime.now());
            service.add(obj);
        }
        response.sendRedirect(request.getServletContext().getContextPath() + "/back/poetry/list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
