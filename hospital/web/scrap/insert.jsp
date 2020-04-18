<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/6/11
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加处置单</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/scrap/css/insert.css">
    <link href="http://localhost:8080/tool/main.css" rel="stylesheet" type="text/css"/>
    <script src="../tool/jQuery.js"></script>
    <script src="../tool/jquery-ui.js"></script>
    <script src="../tool/main.js"></script>
</head>
<body onload="auto_number1($('#src').val())">
<div class="title">
    <span id="name">属性名称</span>
    <span id="value">属性值</span>
</div>
<div>
    <form action="/Scrap/insert" method="post" >
        <table class="input">
            <tr><td><span>单号：</span><input type="text" id="insert_no" name="scrap_insert_no" readonly="readonly"/></td></tr>
            <tr><td><span>添加日期：</span><input type="date" name="create_date"/></td></tr>
            <%--                制单人--%>
            <tr style="height: 0px;"><td><input style="display: none;" type="text" name="create_emp" value="${param.user}"></td></tr>
            <%--                状态--%>
            <tr style="height: 0px;"><td><input style="display: none;" type="text" name="state" value="0"></td></tr>
            <tr><td><span>备注：</span><input type="text" name="maker"></td></tr>
            <tr><td><input type="submit" name="add" value="保存"/><input style="display: none" id="src" name="src" value="scrap_insert"/></td></tr>
        </table>
    </form>
</div>
<div class="tips" style="color: red">${state}</div>
</body>
