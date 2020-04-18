<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/5/27
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>供应商详情</title>
    <link href="http://localhost:8080/setting/css/vendor_detail.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080/tool/main.css" rel="stylesheet" type="text/css"/>
    <script src="../tool/jquery-ui.js"></script>
    <script src="../tool/jQuery.js"></script>
    <script src="../tool/main.js"></script>
    <script language="JavaScript">
        function init() {
            $.ajax({
                url:"/setting/load_ven_detail",
                type:"post",
                data:{
                    id:"${param.ven_code}",
                    src:"vendor_detail_select"
                },
                success:function (data) {
                    //alert(data[0]["ven_code"]);
                    $('#ven_type').attr('value',data[0]['ven_type_name']);
                    $('#ven_code').attr('value',data[0]['ven_code']);
                    $('#ven_name').attr('value',data[0]['ven_name']);
                    $('#address').attr('value',data[0]['ven_address']);
                    $('#postcode').attr('value',data[0]['ven_postcode']);
                    $('#legal_person').attr('value',data[0]['legal_person']);
                    $('#business_charter').attr('value',data[0]['business_charter']);
                    $('#ven_bank').attr('value',data[0]['ven_bank']);
                    $('#ven_bank_account').attr('value',data[0]['ven_bank_account']);
                    $('#ven_phone').attr('value',data[0]['ven_phone']);
                    if (data[0]['is_stop'] == true ) {
                        $('#is_stop').attr('checked','checked')
                    }
                }
            })
        }
    </script>
</head>
<body onload="init()">
<div class="title">
    <span id="name">属性名称</span>
    <span id="value">属性值</span>
</div>
<div>
    <br/>
    <form action="/setting/vendor_detail_update">
        <table class="title">
            <tr><td><span>类型：</span></td><td><input readonly="readonly" type="text" id="ven_type" name="ven_type"></td></tr>
            <tr><td><span>编码：</span></td><td><input readonly="readonly" type="text" id="ven_code" name="ven_code"></td></tr>
            <tr><td><span>名称：</span></td><td><input type="text" id="ven_name" name="ven_name"></td></tr>
            <tr><td><span>地址：</span></td><td><input type="text" id="address" name="address"></td></tr>
            <tr><td><span>邮编：</span></td><td><input type="text" id="postcode" name="postcode"></td></tr>
            <tr><td><span>法人：</span></td><td><input type="text" id="legal_person" name="legal_person"></td></tr>
            <tr><td><span>营业执照：</span></td><td><input type="text" id="business_charter" name="business_charter"></td></tr>
            <tr><td><span>开户行：</span></td><td><input type="text" id="ven_bank" name="ven_bank"></td></tr>
            <tr><td><span>银行账户：</span></td><td><input type="text" id="ven_bank_account" name="ven_bank_account"></td></tr>
            <tr><td><span>联系方式：</span></td><td><input type="text" id="ven_phone" name="ven_phone"></td></tr>
            <tr><td><span>是否停用：</span></td><td><input type="checkbox" id="is_stop" name="is_stop"></td></tr>
            <tr><td>
                <input type="submit" value="保存">
                <input type="text" style="display: none" name="src" value="vendor_detail_update">
            </td></tr>
        </table>
    </form>

</div>
<div style="color: red">${state}</div>
</body>
</html>
