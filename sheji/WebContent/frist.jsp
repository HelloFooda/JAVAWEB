<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
<style type="text/css">
				#div1{margin:0px auto;margin-top:200px;color:#fff7ff}
				#div2{margin:0px auto;margin-top:100px}
				#div3{width:640px;height:360px}
</style>		
</head>
<body background="images/beijing.jpg">
			<div id="top">
				<jsp:include page="head.jsp"></jsp:include>
			</div>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
		<!-- PPT滚动栏 -->
		<div id="myCarousel" class="carousel slide" >
		
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>   

	<!-- 轮播（Carousel）项目 -->
	<div id="div2">
	<div class="carousel-inner" align="center">
		<div class="item active" >

		<img src="images/csgo.jpg" alt="First slide" >
		</div>
		<div class="item" >
		<img src="images/r6.jpg" alt="Second slide">
		</div>
		<div class="item" >
		<img src="images/sc2.jpg" alt="Third slide">

		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	</a>
</div>

<!-- 控制按钮 -->

<div style="text-align:center;">
	<input type="button" class="btn slide-one" value="">
	<input type="button" class="btn slide-two" value="">
	<input type="button" class="btn slide-three" value="">
</div>
<script>
	$(function(){
		// 循环轮播到某个特定的帧 
		$(".slide-one").click(function(){
			$("#myCarousel").carousel(0);
		});
		$(".slide-two").click(function(){
			$("#myCarousel").carousel(1);
		});
		$(".slide-three").click(function(){
			$("#myCarousel").carousel(2);
		});
	});
</script>
</div>
<!-- 小标题页 -->
		<div id="div1">
			<div class="row clearfix">
				<div class="col-md-4 column">
					<h2>
						没有账号？
					</h2>
					<p>
						点我进行注册！！
					</p>
					<p>
						 <a class="btn" href="register.jsp">View details »</a>
					</p>
				</div>
				<div class="col-md-4 column">
					<h2>
						还没登陆？
					</h2>
					<p>
						点我进行登陆！！
					</p>
					<p>
						 <a class="btn" href="login.jsp">View details »</a>
					</p>
				</div>
				<div class="col-md-4 column">
					<h2>
						忘记密码？
					</h2>
					<p>
						点我进行找回！！
					</p>
					<p>
						 <a class="btn" href="#">View details »</a>
					</p>
				</div>
			</div>
		</div>	
		</div>
	</div>
</div>

</body>
</html>