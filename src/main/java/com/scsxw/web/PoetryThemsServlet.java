package com.scsxw.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import com.scsxw.entity.PoetryTheme;
import com.scsxw.service.PoetryThemeService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 类型（控制器）
 */
@WebServlet("/back/poetry-theme/*")
public class PoetryThemsServlet extends HttpServlet {
    private static final long serialVersionUID = 11;
    // 定义服务对象
    private PoetryThemeService poetryThemsService = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PoetryThemsServlet() {
        super();
        // 创建服务对象
        poetryThemsService = new PoetryThemeService();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        // TODO Auto-generated method stub
        // 设置编码
        // 1. 先设置请求和响应编码（必须在getWriter()之前）
        request.setCharacterEncoding("GBK");
        // 2. 设置响应编码
        response.setContentType("text/html;charset=GBK"); // 文本类型:网页
        
        // 获取路径信息
        String path = request.getPathInfo();
        // response.getWriter().write(path);
        
        switch (path) {
            case "/list": // 获取所有诗词主题列表
                // 从数据库获取所有诗词主题
                List<PoetryTheme> objs = poetryThemsService.selectAll();
                RequestDispatcher dispatcher = request.getRequestDispatcher("/back/poetry-theme-list.jsp");
                // 将数据传递到JSP页面
                request.setAttribute("objs", objs);
                dispatcher.forward(request, response);// 转发到JSP页面
                break;
            case "/delete": // 执行删除操作
                // 获取要删除的ID
                String id = request.getParameter("id");
                // 删除数据
                poetryThemsService.delete(Integer.parseInt(id));
                // 重定向到列表页面
                response.sendRedirect(request.getServletContext().getContextPath() + "/back/poetry-theme/list");
                break;
            case "/add": // 进入添加页面
                dispatcher = request.getRequestDispatcher("/back/poetry-theme-add.jsp");
                // 传递一个空对象到页面
                request.setAttribute("obj", new PoetryTheme());
                dispatcher.forward(request, response);// 转发到JSP页面
                break;
            case "/update": // 进入修改页面
                dispatcher = request.getRequestDispatcher("/back/poetry-theme-add.jsp");
                // 获取要修改的ID
                id = request.getParameter("id");
                // 根据ID查询数据
                PoetryTheme obj = poetryThemsService.selectById(Integer.parseInt(id));
                request.setAttribute("obj", obj); // 传递对象到页面
                dispatcher.forward(request, response);// 转发到JSP页面
                break;
            case "/save": // 执行保存操作
                // 获取表单数据
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                // 验证数据
                if (name == null || name.trim().equals("")) {// 如果名称为空
                    response.sendRedirect(request.getServletContext().getContextPath() + "/back/poetry-theme/add");
                    return;
                }
                // 创建对象
                obj = new PoetryTheme();
                obj.setName(name);
                obj.setDescription(description);
                obj.setCreateTime(LocalDateTime.now());
                obj.setUpdateTime(LocalDateTime.now());
                
                // 判断是添加还是修改
                id = request.getParameter("id");
                if (id != null && !id.trim().equals("") && !"null".equals(id.trim())) {// 修改
                    obj.setId(Long.parseLong(id));// 设置ID
                    // 执行修改操作
                    poetryThemsService.update(obj);
                } else {// 添加
                    // 执行添加操作
                    poetryThemsService.add(obj);
                }
                // 重定向到列表页面
                response.sendRedirect(request.getServletContext().getContextPath() + "/back/poetry-theme/list");
                break;
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}