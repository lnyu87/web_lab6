package com.scsxw.web;

import java.io.IOException;
import java.util.List;
import com.scsxw.entity.Poetry;
import com.scsxw.service.PoetryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list-poem")
public class PoetryListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PoetryService poetryService = new PoetryService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Simple list fetch - in real app, add pagination and filtering
        List<Poetry> list = poetryService.selectAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/list-poem.jsp").forward(request, response);
    }
}
