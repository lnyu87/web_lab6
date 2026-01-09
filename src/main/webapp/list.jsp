<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

    //java代码
    //注册MySQL驱动
    try{
	Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(Exception ex){
    	ex.printStackTrace();
    	throw new RuntimeException("注册MySQL驱动异常",ex);
    }
	
	//获取数据库连接
	String ur1="jdbc:mysql://localhost:3306/scsxw";
	String user="root";
	String password="123456";
	//根据用户名密码获取连接对象
	Connection conn= DriverManager.getConnection(ur1,user,password);
	//构建查询sql语句 查询所有
	
	String sql = "SELECT * FROM test";
	//发送sql语句到数据库
	PreparedStatement ps =  conn.prepareStatement(sql);
	
    //执行SQL 查询语句
    ResultSet rs = ps.executeQuery();
    //循环表格
    while(rs.next()){
    	
%>
<p> <%= rs.getString("title") %> <%= rs.getString("content") %></p>

<%} %>

</body>	
</html>