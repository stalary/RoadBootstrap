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
%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>首页</title>
    <link rel="stylesheet" href="css/managerCSS.css" type="text/css"/>
    <link rel="stylesheet" href="css/mainCSS.css" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1 style="color: #ffffff">管理页面</h1>
        </div>
    </div>
<div class="row">
    <div class="col-md-4 col-md-offset-2 top">
        <input type="button" class="btn btn-info"  value="预约管理"  onclick=window.location.href="managerReserve.jsp"; />
    </div>
    <div class="col-md-4 col-md-offset-1 top">
        <input type="button" class="btn btn-info" value="道路管理"  onclick=window.location.href="managerRoad.jsp"; />
    </div>
</div>
<div class="top text-primary text-center">
    <input type="button" class="btn btn-info" value="退出" onclick=window.location.href="login.jsp"; />
</div>
    <footer class="text-center top" style="color: #ffffff">
        <p>邮箱：stalary@163.com&nbspQQ：452024236&nbsp联系电话：17853149599</p>版权所有©Stalary
    </footer>
</div>
<script src="js/jQuery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
