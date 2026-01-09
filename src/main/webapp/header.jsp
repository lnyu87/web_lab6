<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>诗词赏析网首页</title>
		<!-- 引入外部样式表 -->
		<link rel="stylesheet" href="css/style-v5.css">
	</head>
	<body>
		<div class="header-bg">
			<header class="container">
				<div class="logo"><a href="index.jsp"><img src="img/logo.png" /></a></div>
				<nav>
					<ul>
						<li class="current"><a href="index.jsp">首页</a></li>
						<li><a href="list-poem.jsp">诗词大全</a></li>
						<li><a href="list-author.jsp">诗人大全</a></li>
						<li><a href="list-story.jsp">典故</a></li>
						<li><a href="list-classic.jsp">名句</a></li>
					</ul>
				</nav>
				<div class="search-box">
					<input type="search" placeholder="请输入关键词" /><button class="btn">搜索</button>
				</div>
				<div class="login-box"><a class="btn" href="login.jsp">登录</a><a class="btn" href="register.jsp">注册</a>
				</div>
			</header>
		</div>