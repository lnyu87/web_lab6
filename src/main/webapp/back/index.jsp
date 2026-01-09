<%@page import="com.scsxw.entity.Poetry"%>
<%@page import="com.scsxw.entity.Author"%>
<%@page import="com.scsxw.entity.User"%>
<%@page import="com.scsxw.service.PoetryService"%>
<%@page import="com.scsxw.service.AuthorService"%>
<%@page import="com.scsxw.service.UserService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="back_header.jsp"></jsp:include>

<%
    PoetryService poetryService = new PoetryService();
    AuthorService authorService = new AuthorService();
    UserService userService = new UserService();

    List<Poetry> poems = poetryService.selectAll();
    List<Author> authors = authorService.selectAll();
    List<User> users = userService.selectAll();
    
    // Get recent 5 poems
    List<Poetry> recentPoems = new java.util.ArrayList<>(poems);
    Collections.reverse(recentPoems);
    if(recentPoems.size() > 5) {
        recentPoems = recentPoems.subList(0, 5);
    }
%>
    
<!-- 主内容区 -->
<main class="col-sm-8 col-md-9 col-xl-10 p-0">
    <!-- 顶部导航栏 -->
    <jsp:include page="back_nav.jsp"></jsp:include>
    
    <!-- 内容区域 -->
    <div class="main-content px-3">
        <div class="mb-4 h4">仪表盘</div>
        <div class="row">
            <div class="col-md-4 mb-4">
                <div class="card text-white bg-primary">
                    <div class="card-body">
                        <h5 class="card-title">诗词总数</h5>
                        <p class="card-text fs-3"><%=poems.size()%></p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card text-white bg-success">
                    <div class="card-body">
                        <h5 class="card-title">作者数量</h5>
                        <p class="card-text fs-3"><%=authors.size()%></p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card text-dark bg-warning">
                    <div class="card-body">
                        <h5 class="card-title">用户总数</h5>
                        <p class="card-text fs-3"><%=users.size()%></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header">最近更新</div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>诗词标题</th>
                                <th>作者</th>
                                <th>朝代</th>
                                <th>更新时间</th>

                            </tr>
                        </thead>
                        <tbody>
                            <% for(Poetry p : recentPoems) { %>
                            <tr>
                                <td><%=p.getId()%></td>
                                <td><%=p.getTitle()%></td>
                                <td><%=p.getAuthorName()%></td>
                                <td><%=p.getDynasty()%></td>
                                <td><%=p.getUpdateTime() != null ? p.getUpdateTime().toLocalDate() : ""%></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>
				
<jsp:include page="back_footer.jsp"></jsp:include>
