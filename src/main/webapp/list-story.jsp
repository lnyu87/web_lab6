<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <jsp:include page="header2.jsp"></jsp:include>
    
    <!--面包屑部分-->
		<ul class="container breadcrumbs">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="#">|</a></li>
			<li><a href="#">典故</a></li>
		</ul>
		<!--分类筛选部分-->
		<div class="container box category">
			<div class="box-title">
				<h2>分类筛选</h2>
			</div>
			<div class="box-content">
				<div>
					<span>朝代：</span>
					<a href="#">先秦</a>
					<a href="#">秦</a>
					<a href="#">两汉</a>
					<a href="#">魏晋</a>
					<a href="#">南北朝</a>
					<a href="#">隋代</a>
					<a href="#">唐代</a>
					<a href="#">五代</a>
					<a href="#">宋代</a>
					<a href="#">金朝</a>
					<a href="#">元代</a>
					<a href="#">明代</a>
					<a href="#">清代</a>
					<a href="#">近代</a>
					<a href="#">现代</a>
					<a href="#">当代</a>
				</div>
			</div>
		</div>
		<!-- 主体部分 -->
		<main class="container">
			<!-- 左边内容区域 -->
			<section class="main-content story-list">
				<article class="box">
					<h2 class="title">刻舟求剑</h2>
					<p class="author">出自<span>《吕氏春秋·察今》</span></p>
					<div class="content">
						<p class="allusion ellipsis3">战国时期，楚国有个人过江时剑掉入水中，他立即在船边刻上记号，说："这是我的剑掉下去的地方。"等船靠岸后，他就从刻记号的地方下水找剑。
						</p>
						<p class="annotation ellipsis">比喻拘泥成例，不知变通的行为</p>
					</div>
				</article>
				<article class="box">
					<h2 class="title">破釜沉舟</h2>
					<p class="author">出自<span>《史记·项羽本纪》</span></p>
					<div class="content">
						<p class="allusion ellipsis3">秦朝末年，项羽率军渡河攻秦，过河后下令打破饭锅，凿沉船只，只带三日粮，以示决一死战之决心。</p>
						<p class="annotation ellipsis">形容下定决心，义无反顾的决绝态度</p>
					</div>
				</article>
				
				<p class="pager">
					<a href="#">上一页</a><a href="#" class="active">1</a><a href="#">2</a><a href="#">3</a><a
						href="#">4</a><a href="#">5</a><a href="#">...</a><a href="#">下一页</a>
				</p>
			</section>
			<!-- 右边侧边栏 -->
			<aside class="right-aside">
				<div class="box recommend-author">
					<div class="box-title">
						<h2>推荐诗人</h2>
						<a href="list-author.jsp" class="more">更多</a>
					</div>
					<div class="box-content">
						<a href="list-author.jsp" title="韩愈"><img src="img/hanyu.jpg" /></a>
						<a href="list-author.jsp" title="陆游"><img src="img/luyou.jpg" /></a>
						<a href="list-author.jsp" title="苏轼"><img src="img/sushi.jpg" /></a>
						<a href="list-author.jsp" title="刘禹锡"><img src="img/liuyuxi.jpg" /></a>
						<a href="list-author.jsp" title="欧阳修"><img src="img/ouyangxiu.jpg" /></a>
						<a href="list-author.jsp" title="李清照"><img src="img/liqingzhao.jpg" /></a>
					</div>
				</div>
				<div class="box recommend-poem">
					<div class="box-title">
						<h2>推荐诗词</h2>
						<a href="list-poem.jsp" class="more">更多</a>
					</div>
					<div class="box-content">
						<ul>
							<li><a href="detail.jsp">将进酒</a><a>李白</a></li>
							<li><a href="detail.jsp">念奴娇·赤壁怀古</a><a>苏轼</a></li>
							<li><a href="detail.jsp">满江红</a><a>岳飞</a></li>
							<li><a href="detail.jsp">水调歌头・明月几时有</a><a>苏轼</a></li>
							<li><a href="detail.jsp">游子吟</a><a>陆游</a></li>
						</ul>
					</div>
				</div>
			</aside>
		</main>
		
		<jsp:include page="footer.jsp"></jsp:include>
