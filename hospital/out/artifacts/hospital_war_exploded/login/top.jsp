<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/4/16
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>医院固定资产管理系统</title>
    <link href="http://localhost:8080/login/css/top.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript">
           function get_user(){
                return  ${user};
            }
    </script>
</head>
<body>
<div class="top">
    <div class="logo">
        <span id="title">医院固定资产管理系统</span>
        <div class="user">
            <span>欢迎您：</span>
            <a href="#">${user}</a>
        </div>
    </div>
</div>
<div class="bottom">
    <div class="left">
        <iframe src="login/left.jsp" id="left" frameborder="0" scrolling="no"></iframe>
    </div>
    <div class="main">
        <iframe src="" id="main1" frameborder="0" scrolling="no"></iframe>
    </div>
</div>
</body>
</html>
