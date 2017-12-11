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
    <%--<link href="<%=basePath%>css/login.css" rel="stylesheet" type="text/css"/>--%>
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


<h2 style="margin-left: 43%;margin-top: 15%;">注册成功!</h2>
<button type="button" class="btn btn-primary btn-default" style="margin-left: 46%;"><a href="/customer">点击这里去登录</a></button>
</body>
</html>
