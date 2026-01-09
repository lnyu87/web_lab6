package com.scsxw.web;

import java.io.IOException;
import com.scsxw.entity.Poetry;
import com.scsxw.service.PoetryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class PoetryDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PoetryService poetryService = new PoetryService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            Poetry obj = poetryService.selectById(Long.parseLong(id));
            request.setAttribute("obj", obj);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        } else {
            response.sendRedirect("index");
        }
    }
}
