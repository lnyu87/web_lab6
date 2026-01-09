<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<title>诗词赏析网后台</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 引入本地 Bootstrap CSS -->
		<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/back/bootstrap-5.3.6/css/bootstrap.min.css">
		<!-- 引入本地 Bootstrap JavaScript -->
		<script src="<%=request.getServletContext().getContextPath() %>/bootstrap-5.3.6/back/js/bootstrap.bundle.min.js"></script>
		<!--引入字体文件-->
		<link href="<%=request.getServletContext().getContextPath() %>/fontawesome-6.7.2/back/css/all.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container-fluid bg-light">
			<div class="row">
				<!-- 左侧边栏 -->
				<aside class="col-sm-4 col-md-3 col-xl-2 d-none d-sm-block p-0 bg-white shadow-sm">
					<div class="sticky-top overflow-y-auto vh-100">
						<div class="p-3 pb-1 border-bottom">
							<img src="<%=request.getContextPath()%>/back/img/logo.png" class="img-fluid" style="max-height: 35px;" />
						</div>
						<nav class="nav flex-column mt-2 px-2 ">
							<a class="nav-link active" href="<%=request.getContextPath()%>/back/index.jsp"><i class="fa fa-dashboard"></i>
								<span>仪表盘</span></a>
							<a class="nav-link" href="<%=request.getContextPath()%>/back/poetry/list"><i class="fa fa-list"></i>
								<span>诗词管理</span></a>
							<a class="nav-link" href="<%=request.getContextPath()%>/back/author/list"><i class="fa fa-user-pen"></i>
								<span>诗人管理</span></a>
							<a class="nav-link" href="<%=request.getContextPath()%>/back/poetry-type/list"><i class="fa fa-tags"></i>
								<span>诗词类型管理</span></a>
							<a class="nav-link" href="<%=request.getContextPath()%>/back/poetry-theme/list"><i class="fa fa-layer-group"></i>
								<span>诗词主题管理</span></a>
							<a class="nav-link" href="<%=request.getContextPath()%>/back/user/list"><i class="fa fa-users"></i>
								<span>用户管理</span></a>
						</nav>
					</div>
				</aside>