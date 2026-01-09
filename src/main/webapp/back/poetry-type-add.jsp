<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.scsxw.entity.PoetryType"%>
<jsp:include page="back_header.jsp"></jsp:include>

<%
PoetryType obj = (PoetryType) request.getAttribute("obj");
%>

<!-- 主内容区 -->
<main class="col-sm-9 col-md-10 p-0">
    <!-- 顶部导航栏 -->
    <jsp:include page="back_nav.jsp"></jsp:include>
    
    <!-- 内容区域 -->
    <div class="main-content px-3">
        <div class="card">
            <div class="card-header">
                <%=obj.getId() != null ? "修改" : "增加"%>诗词类型
            </div>
            <div class="card-body">
                <form method="post"
                    action="<%=request.getServletContext().getContextPath()%>/back/poetry-type/save">
                    
                    <input type="hidden" name="id" value="<%=obj.getId() != null ? obj.getId() : ""%>">
                    
                    <div class="row mb-3">
                        <label for="name" class="col-sm-3 col-md-2 col-form-label">类型名称</label>
                        <div class="col-sm-9 col-md-10">
                            <input type="text" class="form-control" id="name" name="name"
                                value="<%=obj.getName() != null ? obj.getName() : ""%>" required>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="description" class="col-sm-3 col-md-2 col-form-label">类型描述</label>
                        <div class="col-sm-9 col-md-10">
                            <textarea class="form-control" id="description" rows="3"
                                name="description" required><%=obj.getDescription() != null ? obj.getDescription() : ""%></textarea>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-10 offset-sm-2">
                            <button type="submit" class="btn btn-primary me-2">提交</button>
                            <button type="reset" class="btn btn-secondary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>

<jsp:include page="back_footer.jsp"></jsp:include>
