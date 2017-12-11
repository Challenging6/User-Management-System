<%--
  Created by IntelliJ IDEA.
  User: Challenging
  Date: 2017/11/9
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
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
    <base href="<%=basePath%>"/>
    <link href="<%=basePath%>bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>css/register.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath%>bootstrap-validator/validator.js"></script>
    <title>个人信息</title>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column" style="margin-left: 200px;width:70%;">
            <div class="page-header">
                <h1>
                    个人信息与图书管理系统
                </h1>
            </div>
            <ul class="nav nav-tabs">
                <li>
                    <a href="/customer/customerInfo">首页</a>
                </li>
                <li>
                    <a href="/customer/allBooks">所有图书</a>
                </li>
                <li>
                    <a href="/customer/books">借阅的图书</a>
                </li>
                <li>
                    <a href="/customer/updateInfo">修改个人信息</a>
                </li>
                <li class="active">
                    <a href="/customer/updatePassword">修改密码</a>
                </li>
            </ul>

            <form class="form-horizontal" role="form" onsubmit="return validateForm()" id="login-form" action="/customer/submitPassword" method="post" data-toggle="validator" name="pform">


                <div class="form-group" style="margin-left: -60px; margin-top: 30px">
                    <label for="password" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" data-minlength="6" class="form-control" name="password" id="password"style="width: 450px" required/>
                        <div class="help-block">Minimum of 6 characters</div>
                    </div>
                </div>

                <div class="form-group" style="margin-top: 30px; width: 73%;">
                    <label for="password" class="col-sm-2 control-label">Confirm</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name= "passwordConfirm" id="passwordConfirm" data-match="#password">
                        <div class="help-block with-errors"></div>
                    </div>
                </div>

                <div class="form-group" style="margin-left: 160px">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary btn-default" >修改密码</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
<script>
    function validateForm()
    {
    var x=document.forms["pform"]["passwordConfirm"].value;
    var y=document.forms["pform"]["password"].value;
    if (y != x)
    {
    alert("密码不一致");
    return false;
    }
    }
</script>
</body>


</html>
