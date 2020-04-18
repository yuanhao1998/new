<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/5/23
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加退库单</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/depot/out/css/insert.css">
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
    <form action="/depotOut/insert" method="post" >
        <table class="input">
            <tr><td><span>单号：</span><input type="text" id="insert_no" name="out_insert_no" readonly="readonly"/></td></tr>
            <tr><td><span>添加日期：</span><input type="date" name="insert_date"/></td></tr>
            <tr><td><span>库房：</span><input type="text" id="store" name="store" onkeyup="get_option2(this)"/></td></tr>
            <tr><td><span>供应商：</span><input type="text" id="vendor" name="vendor" onkeyup="get_option1(this)"/></td></tr>
            <%--                制单人--%>
            <tr style="height: 0px;"><td><input style="display: none;" type="text" name="create_emp" value="${param.user}"></td></tr>
            <%--                状态--%>
            <tr style="height: 0px;"><td><input style="display: none;" type="text" name="state" value="0"></td></tr>
            <tr><td><span>备注：</span><input type="text" name="maker"></td></tr>
            <tr><td><input type="submit" name="add" value="保存"/><input style="display: none" id="src" name="src" value="depotOut_insert"/></td></tr>
        </table>
    </form>
</div>
<div class="tips" style="color: red">${state}</div>
</body>
</html>
