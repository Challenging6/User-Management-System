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
<%@ page import="com.challenging.service.CustomerService"%>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="com.challenging.domain.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.annotation.Resource" %>
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
                <li>
                    <a href="/customer/customerInfo">首页</a>
                </li>
                <li  class="active">
                    <a href="/customer/allBooks">所有图书</a>
                </li>
                <li>
                    <a href="/customer/books">借阅的图书</a>
                </li>
                <li>
                    <a href="/customer/updateInfo">修改个人信息</a>
                </li>
                <li>
                    <a href="/customer/updatePassword">修改账号</a>
                </li>

            </ul>

            <table  class="table table-striped">
                <tr>
                    <th>书名</th>
                    <th>详细信息</th>
                    <th>总数量</th>
                    <th>借阅数量</th>
                </tr>

                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.title}</td>
                        <td><a href="/customer/books/${book.bookId}">详细信息</a></td>
                        <td>${book.storeAmount}</td>
                        <td>${book.lendingAmount}</td>
                        <td><a href="/customer/borrowBook/${book.bookId}">借阅图书</a></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>

</body>


</html>
