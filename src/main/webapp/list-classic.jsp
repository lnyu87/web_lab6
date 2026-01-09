<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="header2.jsp"></jsp:include>
    
    <!--面包屑部分-->
		<ul class="container breadcrumbs">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="#">|</a></li>
			<li><a href="#">名句</a></li>
		</ul>
		<!--分类筛选部分-->
		<div class="container  box category">
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
			<section class="main-content classic-list">
				<article class="box">
					<h2 class="title">"三人行，必有我师焉。择其善者而从之，其不善者而改之。"</h2>
					<div class="content">
						<p class="allusion ellipsis3">赏析：这句话体现了孔子谦虚好学的态度，强调我们应该保持开放心态，善于向他人学习。</p>
						<p class="annotation ellipsis"></p>
					</div>
					<p class="author">出自<span>《论语·述而》</span></p>
				</article>
				<article class="box">
					<h2 class="title">"故天将降大任于是人也，必先苦其心志，劳其筋骨，饿其体肤，空乏其身..."</h2>
					<div class="content">
						<p class="allusion ellipsis3">赏析：孟子通过这段话阐述了逆境成才的道理，强调艰难困苦对人格培养的重要作用。</p>
						<p class="annotation ellipsis"></p>
					</div>
					<p class="author">出自<span>《孟子·告子下》</span></p>
				</article>
				<article class="box">
					<h2 class="title">"路漫漫其修远兮，吾将上下而求索。"</h2>
					<div class="content">
						<p class="allusion ellipsis3">赏析：这句诗表现了屈原对真理的不懈追求，成为激励后人勇于探索的千古名句。</p>
						<p class="annotation ellipsis"></p>
					</div>
					<p class="author">出自<span>屈原《离骚》</span></p>
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