<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/5/27
  Time: 11:21
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
<body onload="auto_number2($('#src').val())">
<div class="title">
    <span id="name">属性名称</span>
    <span id="value">属性值</span>
</div>
<div>
    <form action="/setting/vendor_insert" method="post" >
        <table class="input">
            <tr><td><span>供应商编码：</span><input type="text" readonly="readonly" id="insert_no" name="ven_code"/></td></tr>
            <tr><td><span>供应商名称：</span><input type="text" name="ven_name"/></td></tr>
            <tr><td><span>供应商类型：</span><input type="text" id="ven_type" name="ven_type" onkeyup="get_option2(this)"/></td></tr>
            <tr><td><span>地址：</span><input type="text" name="ven_address"/></td></tr>
            <tr><td><span>邮编：</span><input type="text" name="ven_postcode"/></td></tr>
            <tr><td><span>法人：</span><input type="text" name="legal_person"/></td></tr>
            <tr><td><span>营业执照：</span><input type="text" name="business_charter"/></td></tr>
            <tr><td><span>开户行：</span><input type="text" name="ven_bank"/></td></tr>
            <tr><td><span>银行账户：</span><input type="text" name="ven_bank_account"/></td></tr>
            <tr><td><span>联系方式：</span><input type="text" name="ven_phone"/></td></tr>
            <tr><td><input type="submit" name="Add" value="保存"/><input style="display: none" id="src" name="src" value="vendor_insert"/></td></tr>
        </table>
    </form>
</div>
<div class="tips" style="color: red">${state}</div>
</body>
</html>
