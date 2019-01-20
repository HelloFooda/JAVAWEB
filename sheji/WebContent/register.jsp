<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" 
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>register</title>
    <meta http-equiv="Page-Enter" content="revealTrans(duration=50, transition=1)" charset="UTF-8">
    <link href="css/registestytle.css" rel='stylesheet' type='text/css' />
</head>
<body>
<div >
    <ul class=daohang>
        <li><a href="">关于我们</a></li>
        <li><a href="login.jsp">登陆</a></li>
        <li><a href="">首页</a></li>

    </ul>
</div>
<h1>Welcome To Sbeam</h1>
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
    <form action="register?action=register" method="get" id="register">
        <input type="text" class="text" value="username" name="uname" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >
        <div class="key">
            <input type="password" value="password" name="passwd" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
        </div>
        <input type="email" class="email" value="email" name="email" onfocus="this.value1 ='';" onblur="if (this.value1 == ''){this.value1='邮箱';}">
        <div class="submit">
        <input type="submit" value="注册" >
    </div>
    </form>
    
</div>
<div class="copy-rights">
    <p>Copyright &copy; 2018.Company name All rights reserved.More Templates <a href="https://www.ubisoft.com.cn/" target="_blank" title="关于我们">关于我们</a> - Collect from <a href="https://www.ubisoft.com.cn/" title="联系我们" target="_blank">联系我们</a></p>
</div>

</body>
</html>
