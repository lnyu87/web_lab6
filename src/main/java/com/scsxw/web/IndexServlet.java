package com.scsxw.web;

import java.io.IOException;
import java.util.List;
import java.util.Collections;
import com.scsxw.entity.Poetry;
import com.scsxw.entity.Author;
import com.scsxw.entity.PoetryTheme;
import com.scsxw.service.PoetryService;
import com.scsxw.service.AuthorService;
import com.scsxw.service.PoetryThemeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PoetryService poetryService = new PoetryService();
    private AuthorService authorService = new AuthorService();
    private PoetryThemeService themeService = new PoetryThemeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Fetch data
        List<Poetry> allPoems = poetryService.selectAll();
        List<Author> allAuthors = authorService.selectAll();
        List<PoetryTheme> allThemes = themeService.selectAll();

        // Today's Recommendation (Random 4)
        Collections.shuffle(allPoems);
        List<Poetry> todayRecommends = allPoems.subList(0, Math.min(allPoems.size(), 4));
        
        // Ranking (Top 8 - assuming sort by view count later, for now just sublist)
        // ideally: poetryService.selectTopViewed(8);
        List<Poetry> rankPoems = allPoems.subList(0, Math.min(allPoems.size(), 8));

        // Author Recommendation (Top 10)
        List<Author> recommendAuthors = allAuthors.subList(0, Math.min(allAuthors.size(), 14));
        
        request.setAttribute("todayRecommends", todayRecommends);
        request.setAttribute("rankPoems", rankPoems);
        request.setAttribute("recommendAuthors", recommendAuthors);
        request.setAttribute("allThemes", allThemes);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
