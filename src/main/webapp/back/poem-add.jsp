<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:include page="back_header.jsp"></jsp:include>
    
    <!-- 主内容区 -->
				<main class="col-sm-9 col-md-10 p-0">
					<!-- 顶部导航栏 -->
					<nav class="navbar sticky-top bg-white shadow-sm mb-3 justify-content-sm-end px-3">
						<!-- 仅在小屏幕显示汉堡按钮和导航 -->
						<div class="d-sm-none">
							<button class="btn btn-outline-primary" data-bs-toggle="collapse"
								data-bs-target="#navbarNav">
								<i class="fa fa-bars"></i>
							</button>
							<div class="collapse navbar-collapse" id="navbarNav">
								<div class="navbar-nav">
									<a class="nav-link active" href="index.jsp">仪表盘</a>
									<a class="nav-link" href="poem-list.jsp">诗词管理</a>
									<a class="nav-link" href="poem-list.jsp">诗词管理</a>
								</div>
							</div>
						</div>
						<!-- 品牌标识 -->
						<!-- <a class="navbar-brand p-1" href="#">诗词赏析网后台</a> -->
						<!-- 折叠按钮（小屏幕） -->

						<!-- 导航链接 -->
						<div class="d-flex align-items-center p-1">
							<span class="me-3"><i class="fa fa-user"></i>管理员</span>
							<a href="#" class="btn btn-sm btn-outline-secondary">退出</a>
						</div>
					</nav>
					<!-- 内容区域 -->
					<div class="main-content px-3">
						<div class="card">
							<div class="card-header">添加新诗词</div>
							<div class="card-body">
								<form>
									<div class="row mb-3">
										<label for="title" class="col-sm-3 col-md-2 col-form-label">诗词标题</label>
										<div class="col-sm-9 col-md-10">
											<input type="text" class="form-control" id="title" required>
										</div>
									</div>

									<div class="row mb-3">
										<label for="author" class="col-sm-3 col-md-2 col-form-label">作者</label>
										<div class="col-sm-9 col-md-10">
											<input type="text" class="form-control" id="author" required>
										</div>
									</div>

									<div class="row mb-3">
										<label for="dynasty" class="col-sm-3 col-md-2 col-form-label">朝代</label>
										<div class="col-sm-9 col-md-10">
											<select class="form-select" id="dynasty" required>
												<option value="">请选择朝代</option>
												<option value="唐">唐</option>
												<option value="宋">宋</option>
												<option value="元">元</option>
												<option value="明">明</option>
												<option value="清">清</option>
											</select>
										</div>
									</div>

									<div class="row mb-3">
										<label for="category" class="col-sm-3 col-md-2 col-form-label">分类</label>
										<div class="col-sm-9 col-md-10">
											<select class="form-select" id="category" required>
												<option value="">请选择分类</option>
												<option value="五言绝句">五言绝句</option>
												<option value="七言绝句">七言绝句</option>
												<option value="五言律诗">五言律诗</option>
												<option value="七言律诗">七言律诗</option>
												<option value="词">词</option>
												<option value="曲">曲</option>
											</select>
										</div>
									</div>

									<div class="row mb-3">
										<label for="content" class="col-sm-3 col-md-2 col-form-label">诗词内容</label>
										<div class="col-sm-9 col-md-10">
											<textarea class="form-control" id="content" rows="3" required></textarea>
										</div>
									</div>

									<div class="row mb-3">
										<label for="translation" class="col-sm-3 col-md-2 col-form-label">译文</label>
										<div class="col-sm-9 col-md-10">
											<textarea class="form-control" id="translation" rows="2"></textarea>
										</div>
									</div>

									<div class="row mb-3">
										<label for="appreciation" class="col-sm-3 col-md-2 col-form-label">赏析</label>
										<div class="col-sm-9 col-md-10">
											<textarea class="form-control" id="appreciation" rows="2"></textarea>
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
