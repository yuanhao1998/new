<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/5/20
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资产详情页添加</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/depot/in/css/detail_insert.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/tool/main.css">
    <script src="../../tool/jQuery.js"></script>
    <script src="../../tool/jquery-ui.js"></script>
    <script src="../../tool/main.js"></script>
</head>
<body>
<div class="title">
    <span id="name">属性名称</span>
    <span id="value">属性值</span>
</div>
<div>
    <form action="/depotIn/detail_insert" method="post">
        <table class="input">
<%--            单号--%>
            <tr style="height: 20px"><td><input id="in_no" name="in_no" style="display: none;" value="${param.in_no}" type="text"/></td></tr>
            <tr><td><span>名称：</span><input id="equi_code" name="equi_code" onkeyup="get_option1(this)" type="text"/></td></tr>
            <tr><td><span>资金来源：</span><input name="money_source" value="1-其他来源" type="text"/></td></tr>
            <tr><td><span>单价：</span><input name="price" type="text"/></td></tr>
            <tr><td><span>数量：</span><input name="amount" type="text"/></td></tr>
            <tr><td><span>备注：</span><input name="maker" type="text"/></td></tr>
            <tr style="height: 10px"><td><input style="display: none" name="src" value="depotIn_detail_insert"/></td></tr>
            <tr><td><input type="submit" value="确定"></td></tr>
        </table>
    </form>
    <div class="tips" style="color: red">${state}</div>
</div>
</body>
</html>
