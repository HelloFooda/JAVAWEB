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
				#div1{margin:0px auto;margin-top:600px}
				#div2{margin:0px auto;margin-top:100px}
				#div4{color:#fff7ff}
</style>		
</head>
<body background="images/beijing.jpg" text-align=center>
			<div id="top">
				<jsp:include page="head.jsp"></jsp:include>
			</div>
						<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column" >
			<table class="table table-striped" >
				<tbody>
				<tr>
				<td>
				<img src="${gphoto}" width="200" height="300" border="0">
				</td>
				<td>
				<p>商品名称：${gname}</p>
				</td>
				<td>
				<p>商品价格：${gzt}</p>
				</td>
				<td>
				<button>加入购物车</button>
				</td>
				</tr>
				</tbody>
			</table> 
			<div align="right">
			<a href="http://localhost:8080/sheji/tb?action=all"><button type="button" class="btn btn-default btn-info">返回</button></a>
			</div>
		</div>
	</div>
</div>
</body>
</html>