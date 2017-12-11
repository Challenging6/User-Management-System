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
    <title>更新图书信息</title>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column" style="margin-left: 200px;width: 70%;">
            <div class="page-header">
                <h1>
                    管理员信息管理系统
                </h1>
            </div>
            <ul class="nav nav-tabs">
                <li>
                    <a href="/admin/adminInfo">首页</a>
                </li>

                <li  class="active">
                    <a href="/admin/allBooks">管理图书</a>
                </li>

                <li>
                    <a href="/admin/viewAllCustomer">查看所有用户</a>
                </li>
                <li>
                    <a href="/admin/updateInfo">修改个人信息</a>
                </li>
                <li>
                    <a href="/admin/updatePassword">修改密码</a>
                </li>
            </ul>
            <form:form commandName="book" action="/admin/submitUpdateBook" method="post">
                <div class="form-group">
                    <label for="title" class="control-label">书名:</label>

                    <form:input path="title" class="form-control"/>
                    <form:errors path="title" class="text-danger"/>
                </div>
                <div class="form-group">

                    <label for="category" class="control-label">分类:</label>
                    <form:input path="category" id="category" class="form-control"/>
                    <form:errors path="category" class="text-danger"/>
                </div>

                <div class="form-group">
                    <label for="isbn" class="control-label">isbn:</label>

                    <form:input path="isbn" id="isbn" class="form-control"/>
                    <form:errors path="isbn" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="author" class="control-label">作者:</label>
                    <form:input path="author" id="author" class="form-control"/>
                    <form:errors path="author" class="text-danger"/>
                </div>

                <div class="form-group">
                    <label for="storeAmount" class="control-label">馆藏数量:</label>
                    <form:input path="storeAmount" id="storeAmount" class="form-control"/>
                    <form:errors path="storeAmount" class="text-danger"/>
                </div>

                <form:hidden path="bookId"/>
                <form:hidden path="lendingAmount"/>

                <button type="submit" class="btn btn-primary">submit</button>


            </form:form>

        </div>
    </div>
</div>

</body>


</html>
