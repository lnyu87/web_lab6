<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>诗词赏析网注册页</title>
		<!-- 引入外部样式表 -->
		<link rel="stylesheet" href="css/style-v5.css">
	</head>
	<body>
		<!-- 头部区域 -->
		<div class="header-bg">
			<header class="container">
				<div class="logo"><a href="index.jsp"><img src="img/logo.png" /></a></div>
				<nav>
					<ul>
						<li class="current"><a href="index.jsp">首页</a></li>
						<li><a href="list-poem.jsp">诗词大全</a></li>
						<li><a href="list-author.jsp">诗人大全</a></li>
						<li><a href="list-story.jsp">典故</a></li>
						<li><a href="list-classic.jsp">名句</a></li>
					</ul>
				</nav>
				<div class="search-box">
					<input type="search" placeholder="请输入关键词" /><button class="btn">搜索</button>
				</div>
				<div class="login-box"><a class="btn" href="login.jsp">登录</a><a class="btn" href="register.jsp">注册</a>
				</div>
			</header>
		</div>
		
		<!-- 主体部分 -->
		<main class="container">
			<section class="box logreg-box register">
				<form autocomplete="off">
					<div class="tab"><span>注册账号</span></div>
					<fieldset>
						<div class="form-group">
							<label for="username">账号</label>
							<input type="text" id="username" name="username" required pattern="[a-zA-Z]{6,}"
								oninvalid="setCustomValidity('用户名由至少6位字母组合')" oninput="setCustomValidity('')">
							<span class="required">*</span>
						</div>
						<div class="form-group">
							<label for="pswd">密码</label>
							<input type="password" id="pswd" name="pswd" required pattern="[A-Z]+[a-z]+\d{1,}"
								oninvalid="setCustomValidity('密码由大写字母+小写字母+数字组成')" oninput="setCustomValidity('')">
							<span class="required">*</span>
						</div>
						<div class="form-group">
							<label for="pswd_conform">确认密码</label>
							<input type="password" id="pswd_conform" name="pswd_conform" required
								pattern="[A-Z]+[a-z]+\d{1,}" oninvalid="setCustomValidity('密码由大写字母+小写字母+数字组成')"
								oninput="setCustomValidity('')">
							<span class="required">*</span>
						</div>
						<div class="form-group">
							<label for="sex">性别</label>
							<label>
								<input type="radio" name="sex" value="man" checked>男
							</label>
							<label>
								<input type="radio" name="sex" value="woman"> 女
							</label>
						</div>
						<div class="form-group">
							<label for="birthdate">生日</label>
							<input type="date" id="birthdate" name="birthdate">
						</div>
						<div class="form-group">
							<label for="homepage">个人主页</label>
							<input type="url" id="homepage" name="homepage">
						</div>
						<div class="form-group">
							<label for="email">邮箱</label>
							<input type="email" id="email" name="email">
						</div>
						<div class="form-group">
							<label for="tel_code">验证码</label>
							<input type="tel" id="tel_code" name="tel_code" required pattern="^1[3-9]\d{9}$"
								oninvalid="setCustomValidity('大陆手机号码由1开头的11位数字组成')" oninput="setCustomValidity('')">
							<button type="button" class="btn">获取验证码</button>
							<span class="required">*</span>
						</div>
						<div class="submit-group">
							<input type="submit" value="注册" class="btn">
						</div>
					</fieldset>
				</form>
			</section>
		</main>
		<!-- 底部区域 -->
		<div class="footer-bg">
			<footer class="container">
				<div>©&nbsp;2025&nbsp;诗词赏析网&nbsp;保留所有权利</div>
			</footer>
		</div>
	</body>
</html>