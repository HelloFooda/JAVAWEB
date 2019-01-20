<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>讨论</title>
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
<body background="images/beijing.jpg">
      <script src="https://code.jquery.com/jquery.js"></script>
      <script src="js/bootstrap.min.js"></script>
			<div id="top">
				<jsp:include page="head.jsp"></jsp:include>
			</div>
			
			<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column" >
			<table class="table table-striped" id="div4">
				<tbody>
						
						<!--  	<input id="tid" type="hidden" name="tid" value="${tb.tid}">-->
				<div class="form-group">
					 <label >标题</label><br>
					<!-- <input type="text"  class="form-control" id="tbt" readonly="readonly"/> -->
					 <textarea class="form-control"  style="height:35px" readonly="readonly">${tbt1}</textarea>
				</div>
				<div class="form-group">
				 	 <label >正文</label><br>
					<textarea class="form-control"  style="height:140px" readonly="readonly">${tzw1}</textarea>
				</div>

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