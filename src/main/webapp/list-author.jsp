<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <jsp:include page="header2.jsp"></jsp:include>
 
<!--面包屑部分-->
		<ul class="container breadcrumbs">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="#">|</a></li>
			<li><a href="#">诗人大全</a></li>
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
			<section class="main-content author-list">
				<dl class="box">
					<dt class="title"><a href="detail.jsp"><img src="img/libai.jpg" /></a></dt>
					<dd class="author"><a href="#">李白</a><a href="#">【唐代】</a></dd>
					<dd class="content ellipsis3">简&nbsp;&nbsp;&nbsp;&nbsp;介：701年－762年，字太白，号青莲居士，唐代著名浪漫主义诗人，被誉为“诗仙”。
					</dd>
					<dd class="ellipsis">代表作：《静夜思》《将进酒》《望庐山瀑布》</dd>
				</dl>
				<dl class="box">
					<dt class="title"><a href="detail.jsp"><img src="img/sushi.jpg" /></a></dt>
					<dd class="author"><a href="#">苏轼</a><a href="#">【宋代】</a></dd>
					<dd class="content ellipsis3">
						简&nbsp;&nbsp;&nbsp;&nbsp;介：1037—1101年，字子瞻，号东坡居士，眉州眉山（今四川眉山）人，北宋文学家、书法家、画家，唐宋八大家之一。他一生仕途坎坷，多次被贬。在诗、词、文、书、画等方面均取得很高成就，对后世影响深远。
					</dd>
					<dd class="ellipsis">代表作：《水调歌头・明月几时有》《念奴娇・赤壁怀古》《题西林壁》</dd>
				</dl>
				<dl class="box">
					<dt class="title"><a href="detail.jsp"><img src="img/liqingzhao.jpg" /></a></dt>
					<dd class="author"><a href="#">李清照</a><a href="#">【宋代】</a></dd>
					<dd class="content ellipsis3">
						简&nbsp;&nbsp;&nbsp;&nbsp;介：1084年－约1155年，宋代著名女词人，号易安居士，婉约派代表人物。其词作语言清丽，情感细腻，尤擅写闺情与离愁，被誉为“千古第一才女”。
					</dd>
					<dd class="ellipsis">代表作：《声声慢·寻寻觅觅》《如梦令·昨夜雨疏风骤》《夏日绝句》</dd>
				</dl>
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