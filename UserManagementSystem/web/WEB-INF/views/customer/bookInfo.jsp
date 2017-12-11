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
    <title>${book.title}</title>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column"  style="margin-left: 200px;width: 70%;">
            <div class="page-header">
                <h1>
                    书籍详细信息
                </h1>
            </div>
            <ul class="nav nav-tabs">
                <li>
                    <a href="/customer/books">返回个人借阅的图书</a>
                </li>

                <li>
                    <a href="/customer/allBooks">返回所有图书</a>
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
                        Title
                    </td>
                    <td>
                        ${book.title}
                    </td>

                </tr>

                <tr>
                    <td>
                        Author
                    </td>
                    <td>
                        ${book.author}
                    </td>

                </tr>
                <tr>
                    <td>
                        ISBN
                    </td>
                    <td>
                        ${book.isbn}
                    </td>

                </tr>
                <tr>
                    <td>
                        分类
                    </td>
                    <td>
                        ${book.category}
                    </td>

                </tr>


                </tbody>
            </table>
        </div>
    </div>
</div>

</body>


</html>
