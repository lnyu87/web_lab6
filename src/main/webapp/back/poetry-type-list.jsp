<%@page import="com.scsxw.entity.PoetryType"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="back_header.jsp"></jsp:include>
<%
List<PoetryType> objs = (List<PoetryType>) request.getAttribute("objs");
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
				<span>诗词类型列表</span>
				<div>
					<a
						href="<%=request.getServletContext().getContextPath()%>/back/poetry-type/add"
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
							if(objs != null) {
								for (int i = 0; i < objs.size(); i++) {
									PoetryType obj = objs.get(i);
							%>
							<tr>
								<td><%=obj.getId()%></td>
								<td><%=obj.getName()%></td>
								<td><%=obj.getDescription()%></td>
								<td><%=obj.getCreateTime()%></td>
								<td><%=obj.getUpdateTime()%></td>
								<td><a
									href="<%=request.getServletContext().getContextPath()%>/back/poetry-type/update?id=<%=obj.getId()%>"
									class="btn btn-sm btn-outline-primary">编辑</a> <a
									href="<%=request.getServletContext().getContextPath()%>/back/poetry-type/delete?id=<%=obj.getId()%>"
									class="btn btn-sm btn-outline-danger">删除</a></td>
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
