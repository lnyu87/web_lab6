<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.scsxw.entity.PoetryTheme"%>
<jsp:include page="back_header.jsp"></jsp:include>

<%
Object username = session.getAttribute("username");
Object truename = session.getAttribute("truename");
PoetryTheme obj = (PoetryTheme) request.getAttribute("obj"); // 在request作用域获取控制器传递过来的要修改的数据
%>

<!-- 主内容区 -->
<main class="col-sm-9 col-md-10 p-0">
    <!-- 顶部导航栏 -->
    <jsp:include page="back_nav.jsp"></jsp:include>
    
    <!-- 内容区域 -->
    <div class="main-content px-3">
        <div class="card">
            <div class="card-header">
                <%=obj.getId() != null ? "修改" : "增加"%>诗词主题
            </div>
            <div class="card-body">
                <form method="post"
                    action="<%=request.getServletContext().getContextPath()%>/back/poetry-theme/save">
                    <!-- 表单数据提交的地址 -->
                    <input type="hidden" name="id" value="<%=obj.getId() != null ? obj.getId() : ""%>">
                    <!-- 隐藏字段实现区分增加还是修改 -->
                    
                    <div class="row mb-3">
                        <label for="title" class="col-sm-3 col-md-2 col-form-label">主题名称</label>
                        <div class="col-sm-9 col-md-10">
                            <input type="text" class="form-control" id="title" name="name"
                                value="<%=obj.getName()%>" required>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="content" class="col-sm-3 col-md-2 col-form-label">主题描述</label>
                        <div class="col-sm-9 col-md-10">
                            <textarea class="form-control" id="content" rows="3"
                                name="description" required>
                                <%=obj.getDescription()%>
                            </textarea>
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