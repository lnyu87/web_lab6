<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.scsxw.entity.User"%>
<jsp:include page="back_header.jsp"></jsp:include>

<%
User obj = (User) request.getAttribute("obj");
if(obj == null) obj = new User();
%>

<main class="col-sm-9 col-md-10 p-0">
    <jsp:include page="back_nav.jsp"></jsp:include>
    <div class="main-content px-3">
        <div class="card">
            <div class="card-header"><%=obj.getId() != null ? "修改" : "增加"%>用户</div>
            <div class="card-body">
                <form method="post" action="<%=request.getServletContext().getContextPath()%>/back/user/save">
                    <input type="hidden" name="id" value="<%=obj.getId() != null ? obj.getId() : ""%>">
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="username" value="<%=obj.getUsername() != null ? obj.getUsername() : ""%>" required>
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password" value="<%=obj.getPassword() != null ? obj.getPassword() : ""%>" required>
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">昵称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="nickname" value="<%=obj.getNickname() != null ? obj.getNickname() : ""%>">
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">邮箱</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" value="<%=obj.getEmail() != null ? obj.getEmail() : ""%>">
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">头像URL</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="avatar" value="<%=obj.getAvatar() != null ? obj.getAvatar() : ""%>">
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">角色</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="role">
                                <option value="user" <%="user".equals(obj.getRole()) ? "selected" : ""%>>User</option>
                                <option value="admin" <%="admin".equals(obj.getRole()) ? "selected" : ""%>>Admin</option>
                            </select>
                        </div>
                        <label class="col-sm-2 col-form-label">状态</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="status">
                                <option value="1" <%=obj.getStatus() != null && obj.getStatus() == 1 ? "selected" : ""%>>正常</option>
                                <option value="0" <%=obj.getStatus() != null && obj.getStatus() == 0 ? "selected" : ""%>>禁用</option>
                            </select>
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
