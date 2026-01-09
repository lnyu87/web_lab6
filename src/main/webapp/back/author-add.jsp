<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.scsxw.entity.Author"%>
<jsp:include page="back_header.jsp"></jsp:include>

<%
Author obj = (Author) request.getAttribute("obj");
if(obj == null) obj = new Author();
%>

<main class="col-sm-9 col-md-10 p-0">
    <jsp:include page="back_nav.jsp"></jsp:include>
    <div class="main-content px-3">
        <div class="card">
            <div class="card-header"><%=obj.getId() != null ? "修改" : "增加"%>诗人</div>
            <div class="card-body">
                <form method="post" action="<%=request.getServletContext().getContextPath()%>/back/author/save">
                    <input type="hidden" name="id" value="<%=obj.getId() != null ? obj.getId() : ""%>">
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="name" value="<%=obj.getName() != null ? obj.getName() : ""%>" required>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">朝代</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="dynasty" value="<%=obj.getDynasty() != null ? obj.getDynasty() : ""%>">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">别名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="alias" value="<%=obj.getAlias() != null ? obj.getAlias() : ""%>">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">出生年份</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="birthYear" value="<%=obj.getBirthYear() != null ? obj.getBirthYear() : ""%>">
                        </div>
                        <label class="col-sm-2 col-form-label">逝世年份</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="deathYear" value="<%=obj.getDeathYear() != null ? obj.getDeathYear() : ""%>">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">图片URL</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="pic" value="<%=obj.getPic() != null ? obj.getPic() : ""%>">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">生平简介</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" rows="3" name="biography"><%=obj.getBiography() != null ? obj.getBiography() : ""%></textarea>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">代表作品</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" rows="2" name="representativeWorks"><%=obj.getRepresentativeWorks() != null ? obj.getRepresentativeWorks() : ""%></textarea>
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
