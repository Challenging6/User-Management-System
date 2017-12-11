<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>欢迎来到用户管理系统</title>
    <base href="<%=basePath%>"/>
    <link href="<%=basePath%>bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>css/login.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath%>bootstrap-validator/validator.js"></script>
    <style>
        a{
            text-decoration: none;
            color:white;
        }
    </style>
</head>
<body>
<header>

</header>
<h2 class="text-center text-primary page-header" style="margin-top: 8%; ">UserManagementSystem</h2>
<div class="container ">
    <div class="row clearfix">

        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active">
                    <button type="button" onclick="switchUserLogin()" class="btn btn-default" style="margin-left: 470px;">用户登录</button>
                </li>
                <li>
                    <button type="button" onclick="switchAdminLogin()" class="btn btn-default">管理员登录</button>
                </li>

            </ul>

        </div>


        <div class="col-md-12 column" >

            <form class="form-horizontal" role="form" id="login-form" action="/admin/admin-login" method="post" data-toggle="validator">
                <br/>
                <h4 id="login-type" style="margin-left: 520px">管理员登录</h4>
                <br/>

                <div class="alert alert-dismissable alert-danger" id="info">

                    <h4>
                        注意!
                    </h4> <strong>Warning!</strong> 账号或密码不正确,请重新尝试
                </div>

                <div class="form-group " style="margin-left: 160px">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="email" name="email" style="width: 450px" data-error="please input valid email" required/>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 160px">
                    <label for="password" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password" style="width: 450px" required/>
                    </div>
                </div>
                <div class="form-group-md form-group">
                    <div class="col-sm-offset-2 col-sm-10" >
                        <div class="checkbox" style="margin-left: 150px">
                            <label><input type="checkbox" />Remember me</label>

                        </div>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 160px">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary btn-default" >Sign in</button>
                        <button type="button" class="btn btn-primary btn-default" style="margin-left: 280px"><a href="/register">Register</a></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<br/>
<br/>
<script>
    function switchUserLogin() {
        document.getElementById("login-type").innerHTML="用户登录";
        document.getElementById("login-form").setAttribute("action", "/customer/customer-login");
    }
    function switchAdminLogin() {
        document.getElementById("login-type").innerHTML="管理员登录";
        document.getElementById("login-form").setAttribute("action", "/admin/admin-login");
    }
</script>
<footer>
    <p>Challenging &copy;</p>
</footer>
</body>
</html>
