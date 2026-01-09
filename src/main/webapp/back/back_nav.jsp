<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.scsxw.entity.User"%>
<%
    User loginUser = (User) session.getAttribute("loginUser");
    String nickname = "管理员"; 
    if (loginUser != null) {
        nickname = (loginUser.getNickname() != null && !loginUser.getNickname().isEmpty()) 
                   ? loginUser.getNickname() 
                   : loginUser.getUsername();
    }
%>
    					<nav class="navbar sticky-top bg-white shadow-sm mb-3 justify-content-sm-end px-3">
						<!-- 仅在小屏幕显示汉堡按钮和导航 -->
						<div class="d-sm-none">
							<button class="btn btn-outline-primary" data-bs-toggle="collapse"
								data-bs-target="#navbarNav">
								<i class="fa fa-bars"></i>
							</button>
							<div class="collapse navbar-collapse" id="navbarNav">
								<div class="navbar-nav">
									<a class="nav-link active" href="<%=request.getContextPath()%>/back/index.jsp">仪表盘</a>
									<a class="nav-link" href="<%=request.getContextPath()%>/back/poetry/list">诗词管理</a>
									<a class="nav-link" href="<%=request.getContextPath()%>/back/author/list">诗人管理</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/back/poetry-type/list">类型管理</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/back/poetry-theme/list">主题管理</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/back/user/list">用户管理</a>
								</div>
							</div>
						</div>
						<!-- 品牌标识 -->
						<!-- <a class="navbar-brand p-1" href="#">诗词赏析网后台</a> -->
						<!-- 折叠按钮（小屏幕） -->

						<!-- 导航链接 -->
						<div class="d-flex align-items-center p-1">
							<span class="me-3"><i class="fa fa-user"></i><%=nickname%></span>
							<a href="#" class="btn btn-sm btn-outline-secondary">退出</a>
						</div>
					</nav>