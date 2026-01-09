<%@page import="com.scsxw.entity.PoetryTheme"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="back_header.jsp"></jsp:include>
<%
Object username = session.getAttribute("username");
List<PoetryTheme> objs = (List<PoetryTheme>) request.getAttribute("objs");//获取控制器的数据
%>
<!-- 主要内容区域 -->
<main class="col-sm-9 col-md-10 col-xl-10 p-0">
	<!-- 导航栏 -->
	<jsp:include page="back_nav.jsp"></jsp:include>
	<!-- 主体内容 -->
	<div class="main-content px-3">
		<div class="card">
			<div
				class="card-header d-flex justify-content-between align-items-center">
				<span>诗词主题列表</span>
				<div>
					<input type="text"
						class="form-control form-control-sm d-inline-block w-auto me-2"
						placeholder="搜索..."> <a href="#"
						class="btn btn-sm btn-success"><i class="fa fa-search"></i>搜索</a>
					<a
						href="<%=request.getServletContext().getContextPath()%>/back/poetry-theme/add"
						class="btn btn-sm btn-primary"><i class="fa fa-plus"></i>新增</a>
				</div>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>名称</th>
								<th>描述</th>
								<th>创建时间</th>
								<th>更新时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (int i = 0; i < objs.size(); i++) {
								PoetryTheme obj = objs.get(i);
							%>
							<tr>
								<td><%=obj.getId()%></td>
								<td><%=obj.getName()%></td>
								<td><%=obj.getDescription()%></td>
								<td><%=obj.getCreateTime()%></td>
								<td><%=obj.getUpdateTime()%></td>
								<td><a
									href="<%=request.getServletContext().getContextPath()%>/back/poetry-theme/update?id=<%=obj.getId()%>"
									class="btn btn-sm btn-outline-primary">编辑</a> <a
									href="<%=request.getServletContext().getContextPath()%>/back/poetry-theme/delete?id=<%=obj.getId()%>"
									class="btn btn-sm btn-outline-danger">删除</a></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				<nav>
					<ul class="pagination justify-content-center">
						<li class="page-item disabled"><a class="page-link" href="#">上一页</a>
						</li>
						<li class="page-item active"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">下一页</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</main>
<jsp:include page="back_footer.jsp"></jsp:include>