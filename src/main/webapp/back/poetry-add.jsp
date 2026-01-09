<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="com.scsxw.entity.Poetry"
import="com.scsxw.entity.Author"
import="com.scsxw.entity.PoetryType"
import="com.scsxw.entity.PoetryTheme"
import="java.util.List"
%>
<jsp:include page="back_header.jsp"></jsp:include>

<%
Poetry obj = (Poetry) request.getAttribute("obj");
if(obj == null) obj = new Poetry();
List<Author> authors = (List<Author>) request.getAttribute("authors");
List<PoetryType> types = (List<PoetryType>) request.getAttribute("types");
List<PoetryTheme> themes = (List<PoetryTheme>) request.getAttribute("themes");
%>

<main class="col-sm-9 col-md-10 p-0">
    <jsp:include page="back_nav.jsp"></jsp:include>
    <div class="main-content px-3">
        <div class="card">
            <div class="card-header"><%=obj.getId() != null ? "修改" : "增加"%>诗词</div>
            <div class="card-body">
                <form method="post" action="<%=request.getServletContext().getContextPath()%>/back/poetry/save">
                    <input type="hidden" name="id" value="<%=obj.getId() != null ? obj.getId() : ""%>">
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="title" value="<%=obj.getTitle() != null ? obj.getTitle() : ""%>" required>
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">作者</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="authorId">
                                <option value="">请选择作者</option>
                                <% if(authors != null) { for(Author a : authors) { %>
                                <option value="<%=a.getId()%>" <%=obj.getAuthorId() != null && obj.getAuthorId().equals(a.getId()) ? "selected" : ""%>><%=a.getName()%></option>
                                <% }} %>
                            </select>
                        </div>
                        <label class="col-sm-2 col-form-label">朝代</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="dynasty" value="<%=obj.getDynasty() != null ? obj.getDynasty() : ""%>">
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">类型</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="typeId">
                                <option value="">请选择类型</option>
                                <% if(types != null) { for(PoetryType t : types) { %>
                                <option value="<%=t.getId()%>" <%=obj.getTypeId() != null && obj.getTypeId().equals(t.getId()) ? "selected" : ""%>><%=t.getName()%></option>
                                <% }} %>
                            </select>
                        </div>
                        <label class="col-sm-2 col-form-label">主题</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="themeId">
                                <option value="">请选择主题</option>
                                <% if(themes != null) { for(PoetryTheme th : themes) { %>
                                <option value="<%=th.getId()%>" <%=obj.getThemeId() != null && obj.getThemeId().equals(th.getId()) ? "selected" : ""%>><%=th.getName()%></option>
                                <% }} %>
                            </select>
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">图片URL</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="pic" value="<%=obj.getPic() != null ? obj.getPic() : ""%>">
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">内容</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" rows="5" name="content" required><%=obj.getContent() != null ? obj.getContent() : ""%></textarea>
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">注释</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" rows="3" name="notes"><%=obj.getNotes() != null ? obj.getNotes() : ""%></textarea>
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
