<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/6/4
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加供应商</title>
    <link href="http://localhost:8080/setting/css/vendor_insert.css" rel="stylesheet" type="text/css"/>
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
    <form action="/setting/equi_insert" method="post" >
        <table class="input">
            <tr><td><span>资产编码：</span><input type="text" readonly="readonly" id="insert_no" name="equi_code"/></td></tr>
            <tr><td><span>资产名称：</span><input type="text" name="equi_name"/></td></tr>
            <tr><td><span>拼音码：</span><input type="text" name="spell"/></td></tr>
            <tr><td><span>资产类别：</span><input type="text" id="equi_type" name="equi_type" onkeyup="get_option1(this)"/></td></tr>
            <tr><td><span>计量单位：</span><input type="text" id="unit" name="unit" onkeyup="get_option2(this)"/></td></tr>
            <tr><td><span>型号：</span><input type="text" name="equi_model"/></td></tr>
            <tr><td><input type="submit" name="add" value="保存"/><input style="display: none" id="src" name="src" value="equi_insert"/></td></tr>
        </table>
    </form>
    <div class="tips" style="color: red">${state}</div>
</div>
</body>
</html>
