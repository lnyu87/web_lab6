package com.scsxw.web;

import java.io.IOException;
import java.time.LocalDateTime;
import com.scsxw.entity.User;
import com.scsxw.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String pswd = request.getParameter("password");
        String pswdConfirm = request.getParameter("password_confirm");

        if (username == null || pswd == null || !pswd.equals(pswdConfirm)) {
            // Simple validation error handling
            request.setAttribute("msg", "注册失败：信息不完整或密码不一致");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(pswd);
        user.setRole("user");
        user.setStatus(1);
        user.setRegisterTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        if (userService.add(user)) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("msg", "注册失败：用户名可能已存在");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
