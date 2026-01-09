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
	//构建增加sql语句到数据库
	//获取表单数据
	String title=request.getParameter("title");//获取标题
	String content=request.getParameter("content");//获取内容
	if(title !=null){
	
	String sql = "INSERT INTO test(title,content) VALUES(?,?)";//?是占位符第1个？下标0
	//发送sql语句到数据库
	PreparedStatement ps =  conn.prepareStatement(sql);
	ps.setString(1, title);
	ps.setString(2, content);
    //执行SQL语句
    int ret = ps.executeUpdate();//执行更新
    	if(ret>0){
    		out.print("增加成功");
    	}else{
    		out.print("增加失败");
    	}
	}
%>

<form action="#">
	标题:<input type="text" name="title"> <br/>
	内容:<textarea rows="4" cols="20" name="content"></textarea> <br/>
	<input type="submit" value="提交">
</form>
</body>	
</html>