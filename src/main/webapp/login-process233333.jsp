<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%
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
     
     String ret = ""; 
     if(username.equals("lmb") && pswd.equals("123456")){
    	 ret="登录成功";
    	 
    	 //request.setAttribute("username", username);
    	 //request.setAttribute("truename", "坤坤");
    	 session.setAttribute("username", username);
    	 session.setAttribute("truename", "坤坤");
    	 //跳转后台
    	 //request.getRequestDispatcher("back/index.jsp").forward(request,response);//服务端跳转
    	 
    	 response.sendRedirect("back/index.jsp");//客户端浏览器跳转
     }else{
    	 ret="登录失败";
    	 response.sendRedirect("login.jsp");
     }
     
     %>
</body>
</html> --%>