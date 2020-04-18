<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/5/27
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门字典</title>
    <link href="http://localhost:8080/setting/css/dept_insert.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080/tool/main.css" rel="stylesheet" type="text/css"/>
    <script src="../tool/jQuery.js"></script>
    <script src="../tool/main.js"></script>
</head>
<body onload="auto_number2($('#src').val())">
<div class="title">
    <span id="name">属性名称</span>
    <span id="value">属性值</span>
</div>
<div>
    <form action="/setting/dept_insert" method="post" >
        <table class="input">
            <tr><td><span>部门编码：</span><input type="text" readonly="readonly" id="insert_no" name="dept_code"/></td></tr>
            <tr><td><span>部门名称：</span><input type="text" name="dept_name"/></td></tr>
            <tr><td><span>拼音码：</span><input type="text" name="spell"/></td></tr>
            <tr><td><span>级别：</span><input type="text" name="dept_level"/></td></tr>
            <tr><td><span>上级部门：</span><input type="text" name="super_code"/></td></tr>
            <tr><td><input type="submit" name="add" value="保存"/><input style="display: none" id="src" name="src" value="dept_insert"/></td></tr>
        </table>
    </form>
</div>
<div class="tips" style="color: red">${state}</div>
</body>
</html>
