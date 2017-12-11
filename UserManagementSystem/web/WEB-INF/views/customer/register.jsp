<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Challenging
  Date: 2017/11/9
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>Register</title>
    <base href="<%=basePath%>"/>
    <link href="<%=basePath%>bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>css/register.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<header>
    <div class="page-header">
        <h1 class="text-center text-primary">
            注册新的用户<small>register</small>
        </h1>
    </div>
</header>
    <div id="global">
        <form:form commandName="customer" action="/customer/new_account" method="post">
            <fieldset>
                <legend>Create A New Account</legend>
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
                    <label for="password" class="control-label">PassWord:</label>
                    <form:password path="password" id="password" class="form-control"/>
                    <form:errors path="password" class="text-danger"/>
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
            </fieldset>
        </form:form>
    </div>

</body>
</html>
