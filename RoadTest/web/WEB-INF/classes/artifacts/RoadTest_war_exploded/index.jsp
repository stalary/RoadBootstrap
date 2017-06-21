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
    Object username = session.getAttribute("name");
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
    <link rel="stylesheet" href="css/indexCSS.css" type="text/css"/>
    <link rel="stylesheet" href="css/mainCSS.css" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1 class="text-info" style="color: #ffffff">首页</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-1 col-md-offset-2 top">
    <form action="controller/UserServlet" method="post" style="display: inline">
        <input type="submit" value="预约" name="button" class="btn btn-info" />
    </form>
        </div>
        <div class="col-md-1 col-md-offset-3 top">
    <form action="controller/UserServlet" method="post" style="display: inline">
        <input type="submit" value="取消预约" name="button" class="btn btn-info" />
    </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-1 col-md-offset-2 top">
    <form action="controller/UserServlet" method="post" style="display: inline">
        <input type="submit"  value="查询预约情况" name="button" class="btn btn-info" />
    </form>
    </div>
        <div class="col-md-1 col-md-offset-3 top">
    <form action="controller/UserServlet" method="post" style="display: inline">
        <input type="submit" value="查询道路" name="button" class="btn btn-info" />
    </form>
        </div>
    </div>
    <div class="text-center top">
        <input type="button" class="btn btn-info" value="退出" onclick=window.location.href="login.jsp"; />
    </div>
    <footer class="text-center text-info top" style="color: #ffffff">
        <p>邮箱：stalary@163.com&nbspQQ：452024236&nbsp联系电话：17853149599</p>版权所有©Stalary
    </footer>
</div>
<script src="js/jQuery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
