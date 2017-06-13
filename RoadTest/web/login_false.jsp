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
    String error = (String)request.getAttribute("error");
%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>登陆界面</title>
    <link rel="stylesheet" href="css/loginCSS.css" type="text/css"/>
    <link rel="stylesheet" href="css/mainCSS.css" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1 class="text-info">道路预约系统 </h1>
            <small class="text-primary">——Design by stalary's group</small>
        </div>
    </div>
    <div class="col-md-2 col-md-offset-2">
        <button class="navbar-toggle" data-toggle="collapse" data-target="#divNav">
            <span class="glyphicon glyphicon-align-justify"></span>
        </button>
    </div>
    <div class="row">
        <div id="divNav" class="collapse navbar-collapse">
            <div class="col-md-12">
                <ul class="nav navbar-nav">
                    <li class="dropdown"><a href="#">系统面向对象</a>
                        <ul class="dropdown-menu" style="background-color: rgba(236,240,238,0)">
                            <li class="text-primary">应急车辆</li>
                            <li class="text-primary">校车</li>
                            <li class="text-primary">私家车</li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#">系统管理员</a>
                        <ul class="dropdown-menu" style="background-color: rgba(236,240,238,0)">
                            <li class="text-primary">交通管理部门</li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#">系统已支持的城市</a>
                        <ul class="dropdown-menu" style="background-color: rgba(236,240,238,0)">
                            <li class="text-primary">泰安</li>
                            <li class="text-primary">临沂</li>
                            <li class="text-primary">聊城</li>
                            <li class="text-primary">烟台</li>
                            <li class="text-primary">菏泽</li>
                            <li class="text-primary">威海</li>
                        </ul>
                    </li>

                </ul>
            </div>
        </div>
    </div>
    <form action="controller/LoginServlet" method="post" class="text-info top change">
        <p style="color: #ff0c46">帐号/密码错误,请重试</p>
        <p>账号：<input type="text" name="account" class="lg_account" placeholder="手机号／邮箱"/></p>
        <p>密码：<input type="password" name="password" class="lg_password"/></p>
        <div class="row">
            <div class="col-md-1">
                管理员<input type="radio" name="radio" checked="checked" value="admin">
            </div>
            <div class="col-md-1">
                用户：<input type="radio" name="radio"  value="user">
            </div>
        </div>
        <div class="row">
            <div class="col-md-2 col-md-offset-1">
                <button type="submit">登录</button>
            </div>
        </div>
    </form>
    <div class="cow change1">
        <div class="col-md-2">
            <a href="alter.jsp"><p>忘记密码</p></a>
        </div>
        <div class="col-md-10">
            <a href="register.jsp"><p>立即注册</p></a>
        </div>
    </div>
    <footer class="text-center top">
        <p>邮箱：stalary@163.com&nbspQQ：452024236&nbsp联系电话：17853149599</p>版权所有©Stalary
    </footer>
</div>
<script src="js/jQuery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        dropdownOpen();//调用
    });
    function dropdownOpen() {

        var $dropdownLi = $('li.dropdown');

        $dropdownLi.mouseover(function () {
            $(this).addClass('open');
        }).mouseout(function () {
            $(this).removeClass('open');
        });
    }
</script>
</body>
</html>
