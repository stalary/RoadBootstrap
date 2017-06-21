<%--
Created by IntelliJ IDEA.
User: Stalary
Date: 17/5/9
Time: 下午10:45
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    Object username = session.getAttribute("temp");
%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>注册</title>
    <link rel="stylesheet" href="css/registerCSS.css" type="text/css"/>
    <link rel="stylesheet" href="css/mainCSS.css" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>注册</h1>
        </div>
    </div>
    <div class="re_content text-center">
        <form action="controller/RegisterServlet" method="post" id="register">
            <p style="color: #ff0c46;display: inline" >注册失败，此帐号已存在</p>
            <p>帐号：<input type="text" name="account" class="rg_account"/></p>
            <p>密码：<input type="password" name="password" class="rg_password"/></p>
            <p>确认密码：<input type="password" name="confirm_password" class="rg_confirm_password"/></p>
            <p>姓名：<input type="text" name="name" class="rg_name"/>
            <p>手机号：<input type="text" name="phone" class="rg_phone"/></p>
            <input type="submit" class="btn btn-info" value="注册">
            <input type="button" value="返回首页" class="btn btn-info col-md-offset-1"
                   onclick=window.location.href="login.jsp"; />
        </form>
    </div>
    <footer class="text-center top">
        <p>邮箱：stalary@163.com&nbspQQ：452024236&nbsp联系电话：17853149599</p>版权所有©Stalary
    </footer>
</div>
<script src="js/jQuery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/jquery.metadata.js"></script>
<script>
    $(document).ready(function () {
        $("#register").validate({
            rules: {
                account: {
                    required: true,
                    minlength: 6
                },
                password: {
                    required: true,
                    minlength: 6
                },
                phone: {
                    required: true,
                    minlength: 11
                },
                confirm_password: {
                    required: true,
                    minlength: 6
                },
                name:{
                    required:true,
                    minlength:2
                }
            }
        });
    });
</script>
</body>
</html>
