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
    <title>个人信息</title>
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

                <li>
                    <a href="/admin/allBooks">管理图书</a>
                </li>

                <li>
                    <a href="/admin/viewAllCustomer">查看所有用户</a>
                </li>
                <li class="active">
                    <a href="/admin/updateInfo">修改个人信息</a>
                </li>
                <li>
                    <a href="/admin/updatePassword">修改密码</a>
                </li>
            </ul>
            <div class="alert alert-dismissable alert-danger" id="info">

                <h4>
                    注意!
                </h4> <strong>Warning!</strong> 该邮箱已经被注册了</div>
            <form:form commandName="admin" action="/admin/submitInfo" method="post">
                <div class="form-group">
                    <label for="username" class="control-label">UserName:</label>

                    <form:input path="username" class="form-control"/>
                    <form:errors path="username" class="text-danger"/>
                </div>
                <div class="form-group" >

                    <label for="nickname" class="control-label">NickName:</label>
                    <form:input path="nickname" id="nickname" class="form-control"/>
                    <form:errors path="nickname" class="text-danger"/>
                </div>

                <div class="form-group">
                    <label for="email" class="control-label">Email:</label>

                    <form:input path="email" id="email" class="form-control"/>
                    <form:errors path="email" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="age" class="control-label">Age:</label>
                    <form:input path="age" id="age" class="form-control"/>
                    <form:errors path="age" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="gender" class="control-label">Gender:</label>
                    <form:select path="gender" id="gender" class="form-control">
                        <form:option value="女" class="form-control"/>
                        <form:option value="男" class="form-control"/>
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="phone" class="control-label">Phone:</label>
                    <form:input path="phone" id="phone" class="form-control"/>
                    <form:errors path="phone" class="text-danger"/>
                </div>

                <button type="submit" class="btn btn-primary">submit</button>
                <button type="reset" class="btn btn-primary">reset</button>

            </form:form>

        </div>
    </div>
</div>

</body>


</html>
