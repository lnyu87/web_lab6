<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:include page="header2.jsp"></jsp:include>
    
    <!-- 主体部分 -->
		<main class="container">
			<!-- 左边内容区域 -->
			<section class="main-content poem-list">
				<dl class="box">
					<dt class="title">
						<a href="detail.jsp">静夜思</a>
						<div><a href="#" title="拼音">拼</a><a href="#" title="翻译">译</a><a href="#" title="繁体">繁</a><a
								href="#" title="原文">原</a></div>
					</dt>
					<dd class="author">
						<a href="#"><img src="img/libai.jpg" />李白</a><a href="#">【唐代】</a>
					</dd>
					<dd class="content">床前明月光，疑是地上霜。<br>举头望明月，低头思故乡。</dd>
					<dd class="tools">
						<span class="iconfont icon-shoucang" title="收藏"></span>
						<span class="iconfont icon-fuzhi" title="复制"></span>
						<span class="iconfont icon-langdu" title="朗读"></span>
						<span class="iconfont icon-good" title="点赞"><small>赞(33)</small></span>
					</dd>
					<dd class="tags"><a href="#">思乡</a><a href="#">抒情</a></dd>
				</dl>
				<dl class="box">
					<dt class="title"><a href="detail.jsp">春夜喜雨</a>
						<div><a href="#" title="拼音">拼</a><a href="#" title="翻译">译</a><a href="#" title="繁体">繁</a><a
								href="#" title="原文">原</a></div>
					</dt>
					<dd class="author"><a href="#"><img src="img/dufu.jpg" />杜甫</a><a href="#">【唐代】</a></dd>
					<dd class="content">好雨知时节，当春乃发生。<br>随风潜入夜，润物细无声。</dd>
					<dd class="tools">
						<span class="iconfont icon-shoucang" title="收藏"></span>
						<span class="iconfont icon-fuzhi" title="复制"></span>
						<span class="iconfont icon-langdu" title="朗读"></span>
						<span class="iconfont icon-good" title="点赞"><small>赞(33)</small></span>
					</dd>
					<dd class="tags"><a href="#">唐诗</a><a href="#">写景</a><a href="#">五言律诗</a><a href="#">抒情</a><a
							href="#">自然</a></dd>
				</dl>
				<dl class="box">
					<dt class="title"><a href="detail.jsp">水调歌头・明月几时有</a>
						<div><a href="#" title="拼音">拼</a><a href="#" title="翻译">译</a><a href="#" title="繁体">繁</a><a
								href="#" title="原文">原</a></div>
					</dt>
					<dd class="author"><a href="#"><img src="img/sushi.jpg" />苏轼</a><a href="#">【宋代】</a></dd>
					<dd class="content">明月几时有？把酒问青天。<br>不知天上宫阙，今夕是何年。</dd>
					<dd class="tools">
						<span class="iconfont icon-shoucang" title="收藏"></span>
						<span class="iconfont icon-fuzhi" title="复制"></span>
						<span class="iconfont icon-langdu" title="朗读"></span>
						<span class="iconfont icon-good" title="点赞"><small>赞(33)</small></span>
					</dd>
					<dd class="tags"><a href="#">宋词</a><a href="#">中秋</a><a href="#">豪放</a><a href="#">抒情</a><a
							href="#">哲理</a></dd>
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