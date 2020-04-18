<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/6/1
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加领用单</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/depot/draw/css/insert.css">
    <link href="http://localhost:8080/tool/main.css" rel="stylesheet" type="text/css"/>
    <script src="../../tool/jQuery.js"></script>
    <script src="../../tool/jquery-ui.js"></script>
    <script src="../../tool/main.js"></script>
</head>
<body onload="auto_number1($('#src').val())">
<div class="title">
    <span id="name">属性名称</span>
    <span id="value">属性值</span>
</div>
<div>
    <form action="/depotDraw/insert" method="post" >
        <table class="input">
            <tr><td><span>单号：</span><input type="text" id="insert_no" name="draw_insert_no" readonly="readonly"/></td></tr>
            <tr><td><span>领用日期：</span><input type="date" name="draw_date"/></td></tr>
            <tr><td><span>库房：</span><input type="text" id="store" name="store" onkeyup="get_option2(this)"/></td></tr>
            <tr><td><span>领用部门：</span><input type="text" id="dept" name="dept" onkeyup="get_option2(this)"/></td></tr>
            <%--                制单人--%>
            <tr style="height: 0px;"><td><input style="display: none;" type="text" name="create_emp" value="${param.user}"></td></tr>
            <%--                状态--%>
            <tr style="height: 0px;"><td><input style="display: none;" type="text" name="state" value="0"></td></tr>
            <tr><td><span>备注：</span><input type="text" name="maker"></td></tr>
            <tr><td><input type="submit" name="Add" value="保存"/><input style="display: none" id="src" name="src" value="depotDraw_insert"/></td></tr>
        </table>
    </form>
</div>
<div class="tips" style="color: red">${state}</div>
</body>
</html>
