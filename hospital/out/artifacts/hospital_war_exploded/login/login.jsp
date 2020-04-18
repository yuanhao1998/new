<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/4/5
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>
    <meta charset="utf-8"/>
    <title>欢迎登录系统！</title>
    <link href="http://localhost:8080/login/css/login.css" rel="stylesheet" type="text/css" />
</head>


<body>

<div class="login_main">

    <div class="login_logo"></div>

    <div class="login_login">
        <h1></h1>
        <form action="/login" method="post">
            <table>
                <tr><td id="title">用户登录</td></tr>
                <tr>
                    <td>
                        <div class="input">
                            <div class="title1">用户名</div>
                            <div style="width: 192px;"><input type="text" id="name" name="name" /></div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input">
                            <div class="title1">密码</div>
                            <div style="width: 192px;"><input type="password" id="password" name="password"/></div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" id="login" value="登录">
                    </td>
                </tr>
            </table>
            <div class="tips" style="color: red">${error}</div>
        </form>
    </div>
</div>
</body>
</html>
