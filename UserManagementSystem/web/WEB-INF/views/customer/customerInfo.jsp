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
    <link href="<%=basePath%>css/login.css" rel="stylesheet" type="text/css"/>
    <title>个人信息</title>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column"  style="margin-left: 200px;width: 70%;">
            <div class="page-header">
                <h1>
                    个人信息与图书管理系统
                </h1>
            </div>
            <ul class="nav nav-tabs">
                <li class="active">
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
                <li>
                    <a href="/customer/updatePassword">修改密码</a>
                </li>

            </ul>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>
                        名称
                    </th>
                    <th>
                        内容
                    </th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        UserName
                    </td>
                    <td>
                        ${sessionScope.customer.username}
                    </td>

                </tr>

                <tr>
                    <td>
                        NickName
                    </td>
                    <td>
                        ${sessionScope.customer.nickname}
                    </td>

                </tr>
                <tr>
                    <td>
                        Email
                    </td>
                    <td>
                        ${sessionScope.customer.email}
                    </td>

                </tr>
                <tr>
                    <td>
                        Phone
                    </td>
                    <td>
                        ${sessionScope.customer.phone}
                    </td>

                </tr>
                <tr>
                    <td>
                        Gender
                    </td>
                    <td>
                        ${sessionScope.customer.gender}
                    </td>

                </tr>
                <tr>
                    <td>
                        age
                    </td>
                    <td>
                        ${sessionScope.customer.age}
                    </td>

                </tr>
                <tr>
                    <td>
                        LastLoginTime
                    </td>
                    <td>
                        ${sessionScope.customer.lastLoginTime}
                    </td>

                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>

</body>


</html>
