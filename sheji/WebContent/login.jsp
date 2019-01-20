<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Page-Enter" content="revealTrans(duration=50, transition=1)" charset="UTF-8">
    <link href="css/loginstyle.css" rel='stylesheet' type='text/css' />
</head>
<body>
<div >
    <ul class=daohang>
        <li><a href="Egg.jsp">关于我们</a></li>
        <li><a href="register.jsp">注册</a></li>
        <li><a href="frist.jsp">首页</a></li>

    </ul>
</div>


<h1>Login To Sbeam</h1>
<div class="login-form">
    <div class="close"> </div>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"> </div>
    <div class="avtar">
        <img src="images/ig.png" />
    </div>
    <form action="login?action=login" method="post" id="login">
        <input type="text" class="text" value="username" name="uname" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >
        <div class="key">
            <input type="password" value="password"  name="passwd" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
        </div>
        <div class="signin"><input type="submit" value="登陆" ></div>
    </form>
</div>
<div class="copy-rights">
    <p>Copyright &copy; 2018.Company name All rights reserved.More Templates <a href="https://www.ubisoft.com.cn/" target="_blank" title="关于我们">关于我们</a> - Collect from <a href="https://www.ubisoft.com.cn/home/support#" title="联系我们" target="_blank">联系我们</a></p>
</div>

</body>
</html>
