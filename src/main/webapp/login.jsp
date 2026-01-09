<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="header.jsp"></jsp:include>

				
		<!-- 主体部分 -->
		
	<%
	String username = "";//从浏览器获取到用户名
	String pswd = "";//从浏览器获取到密码
	//从浏览器cookies中获取用户名和密码
	Cookie[] cookies = request.getCookies();
	//if (cookies != null) {}  ////判断浏览器是否存在cookies
	 //循环所有cookies
		for (int i = 0; i < cookies.length; i++) {
			Cookie c = cookies[i];
			if (c.getName().equals("username")) {
					username = c.getValue();
			}

			if (c.getName().equals("pswd")) {
					pswd = c.getValue();
			}
		}
	%>
	
		<main class="container">
			<section class="logreg-box box">
				<form method="post" action="<%=request.getServletContext().getContextPath() %>/login-process">
					<div class="main-login">
						<div class="tab">
							<span class="current">账号登录</span>
							<span>验证码登录</span>
						</div>
						<fieldset>
							<div class="form-group">
								<label for="username">账号</label>
								<input type="text" id="username" name="username" required value="<%=username%>">
								<span class="required">*</span>
							</div>
							<div class="form-group">
								<label for="pswd">密码</label>
								<input type="password" id="pswd" name="pswd" required value="<%=pswd%>">
								<span class="required">*</span>
							</div>
							<div class="form-group">
								<label for="valid_code">验证码</label>
								<input type="text" id="valid_code" name="valid_code" required>
								<img src="img/rand_code.gif" alt="验证码">
							</div>
							<div class="form-group">
								<input type="checkbox" name="rememberMe">
								<span>30天自动登录</span>
								<span><a href="#">忘记密码</a></span>
							</div>
							<div class="form-group">
								<input type="submit" value="登录" class="btn">
							</div>
						</fieldset>
					</div>
				</form>
				<div class="other-login">
					<fieldset>
					 <legend>其他方式登录</legend>										
					 <div>
						<figure>
							<img src="img/wx.png" height="20" alt="微信">
							<figcaption>微信</figcaption>
						</figure>
						<figure>
							<img src="img/qq.png" height="20" alt="QQ">
							<figcaption>QQ</figcaption>
						</figure>
						<figure>
							<img src="img/douyin.png" height="20" alt="抖音">
							<figcaption>抖音</figcaption>
						</figure>
					</div>
				 </fieldset>
				</div>
			</section>
		</main>
	    <jsp:include page="footer.jsp"></jsp:include>
