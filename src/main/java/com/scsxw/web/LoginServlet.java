package com.scsxw.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import com.scsxw.entity.User;
import com.scsxw.service.UserService;

/**
 * 登陆处理业务方法
 */
@WebServlet("/login-process")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//定义并创建业务逻辑对象
	private UserService userService = new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("请使用post请求: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Removed doGet call to avoid double response writing
	
	     String username= request.getParameter("username");
	     String pswd= request.getParameter("pswd");
	     String rememberMe= request.getParameter("rememberMe");
	     //out.print(rememberMe);
	     if(rememberMe!=null){
	    	 Cookie userCookie= new Cookie("username",username);
	    	 userCookie.setMaxAge(60*60*24);
	    	 Cookie pswdCookie= new Cookie("pswd",pswd);
			 pswdCookie.setMaxAge(60*60*24);
			 
			 response.addCookie(userCookie);
			 response.addCookie(pswdCookie);
	     }
	     //改成数据库查询用户名密码
	     String ret = ""; 
	     HttpSession session = request.getSession();
	     //调用业务逻辑类登陆查询
	     User obj = this.userService.login(username, pswd);
	     if(obj != null){
	    	 ret="登录成功";
	    	 
	    	//保存用户信息
	    	 session.setAttribute("loginUser", obj);
	    	 //跳转后台
	    	 //request.getRequestDispatcher("back/index.jsp").forward(request,response);//服务端跳转
	    	 
	    	 response.sendRedirect(request.getServletContext().getContextPath()+"/back/index.jsp");//客户端浏览器跳转
	     }else{
	    	 ret="登录失败";
	    	 response.sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
	     }
	   
	}

}
