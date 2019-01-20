

<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
<style type="text/css">
				#div1{margin:0px auto;margin-top:600px}
				#div2{margin:0px auto;margin-top:100px}
				#div3{width:100px;height:0px;margin-left:150px}
				#div4{color:#ff44ff}
</style>		
</head>
<body background="images/beijing.jpg">
<div id="div3" >
<br>
<br>
<br>
<br>
<br>

</div>
      <script src="https://code.jquery.com/jquery.js"></script>
      <script src="js/bootstrap.min.js"></script>
      		<div>
				<jsp:include page="head.jsp"></jsp:include>
			</div>
      
      <div class="container">
	<div  class="row clearfix">
		<div class="col-md-12 column">
		<center>
					<table class="table table-striped" id="div4">
				<thead >
					<tr>
						<th>
							商品图片
						</th>
						<th>
							商品名称
						</th>
						<th>
							上架时间
						</th>
						<th>
							价格
						</th>
					</tr>
				</thead>
				<tbody>
				
						<c:forEach items="${pageObject.data}" var="Goods" varStatus="index">
					<tr>
						<td><img src="${Goods.gphoto}" width="100" height="100"/></td>
						<td><a href="good?gid=${Goods.gid}&action=sc-select">${Goods.gname}</a></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${Goods.pdate}" /></td>
						<td>${Goods.gzt}</td>
					</tr>
						</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">
					<li><a>共${pageObject.curPage}/${pageObject.pageCount}页</a></li>
					<c:if test="${pageObject.first}">
			        <li class="disabled"><a>上一页</a></li></c:if>
			        <c:if test="${!pageObject.first}">
			        <li><a href="goods?action=all&curPage=${pageObject.prePage}&pageSize=${pageObject.pageSize}">上一页</a></li>
			        </c:if>
			        <c:if test="${pageObject.end}">
			        <li class="disabled"><a>下一页</a></li></c:if>
			        <c:if test="${!pageObject.end}">
			        <li><a href="goods?action=all&curPage=${pageObject.nextPage}&pageSize=${pageObject.pageSize}">下一页</a></li>
			        </c:if>
			    </ul>
		</center>
		</div>
	</div>
</div>

</body>
</html>