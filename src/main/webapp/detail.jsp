<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.scsxw.entity.Poetry"%>
<jsp:include page="header.jsp"></jsp:include>

<%
Poetry obj = (Poetry) request.getAttribute("obj");
%>

<main class="container my-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <% if(obj != null) { %>
                    <h1 class="card-title mb-4"><%=obj.getTitle()%></h1>
                    <p class="text-muted">
                        <span class="me-3"><%=obj.getDynasty()%></span>
                        <span><%=obj.getAuthorName()%></span>
                    </p>
                    <div class="card-text fs-5 lh-lg mb-5">
                        <%=obj.getContent().replace("\n", "<br>")%>
                    </div>
                    <% if(obj.getNotes() != null && !obj.getNotes().isEmpty()) { %>
                    <div class="text-start bg-light p-3 rounded">
                        <h5>【注释】</h5>
                        <p><%=obj.getNotes().replace("\n", "<br>")%></p>
                    </div>
                    <% } %>
                    <% } else { %>
                    <p>未找到相关诗词</p>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="footer.jsp"></jsp:include>
