<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
				#div1{width:500px;height:400px;margin:0px auto;margin-top:300px}
</style>		

</head>
<body>
      <script src="https://code.jquery.com/jquery.js"></script>
      <script src="js/bootstrap.min.js"></script>

<div class="container" id="LG">
	<div class="row">
			<div class="row">
				<div class="span4">
				</div>
				<div id="div1">
				<div class="span4">
					<form role="form">
						<div class="form-group">
					 <label for="email">邮箱地址：</label><input type="email" class="form-control" id="email" />
				</div>
				<div class="form-group">
					 <label for="password">请输入验证码：</label><input type="password" class="form-control" id="password" />
				</div>			
					 &nbsp;&nbsp;<a href="login.jsp">登陆</a>&nbsp;&nbsp;<a href="register.jsp">注册</a><br>
				<button type="submit" class="btn btn-default">发送验证码</button>
					</form>	
				</div>
				</div>
				<div class="span4">
				
				</div>
			</div>
	</div>
</div>

</body>
</html>