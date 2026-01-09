<%@page import="com.scsxw.entity.Poetry"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="back_header.jsp"></jsp:include>
<%
List<Poetry> objs = (List<Poetry>) request.getAttribute("objs");
%>
<main class="col-sm-9 col-md-10 col-xl-10 p-0">
	<jsp:include page="back_nav.jsp"></jsp:include>
	<div class="main-content px-3">
		<div class="card">
			<div class="card-header d-flex justify-content-between align-items-center">
				<span>诗词列表</span>
				<div>
					<a href="<%=request.getServletContext().getContextPath()%>/back/poetry/add" class="btn btn-sm btn-primary"><i class="fa fa-plus"></i>新增</a>
				</div>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>标题</th>
								<th>作者</th>
								<th>类型</th>
								<th>主题</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<%
							if(objs != null) {
								for (Poetry obj : objs) {
							%>
							<tr>
								<td><%=obj.getId()%></td>
								<td><%=obj.getTitle()%></td>
								<td><%=obj.getAuthorName()%></td>
								<td><%=obj.getTypeName()%></td>
								<td><%=obj.getThemeName()%></td>
								<td>
									<a href="<%=request.getServletContext().getContextPath()%>/back/poetry/update?id=<%=obj.getId()%>" class="btn btn-sm btn-outline-primary">编辑</a> 
									<a href="<%=request.getServletContext().getContextPath()%>/back/poetry/delete?id=<%=obj.getId()%>" class="btn btn-sm btn-outline-danger">删除</a>
								</td>
							</tr>
							<%
								}
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</main>
<jsp:include page="back_footer.jsp"></jsp:include>
