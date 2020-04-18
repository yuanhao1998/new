<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/5/25
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资产查询</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/select/css/main.css">
    <link href="http://localhost:8080/tool/main.css" rel="stylesheet" type="text/css"/>
    <script src="../tool/jQuery.js"></script>
    <script src="../tool/jquery-ui.js"></script>
    <script src="../tool/main.js"></script>
</head>
<body>
<div class="input">
    <form action="/equiSelect/select" method="post">
        <table>
            <tr>
                <td>生成日期：<input type="date" name="bdate">至<input type="date" name="edate"></td>
                <td>卡片号：<input type="text" name="card_no"></td>
                <td>资产编码：<input type="text" name="equi_code"></td>
            </tr>
            <tr>
                <td>供应商：<input type="text" name="vendor"></td>
                <td>库房：<input type="text" name="store"></td>
                <td>状态：<input type="text" name="state"></td>
            </tr>
            <tr>
                <td>资产类别：<input type="text" name="equi_type"></td>
                <td>负责人：<input type="text" name="prin_emp"></td>
            </tr>
            <tr><td><input type="submit" id="select" value="查询" /></td></tr>
            <input  style="display: none" name="src" value="select"/>
        </table>
    </form>
</div>
<div>
    <br/>
    <table class="title">
        <thead>
        <tr>
            <td>卡片号</td>
            <td>资产编码</td>
            <td>资产名称</td>
            <td>供应商</td>
            <td>仓库</td>
            <td>生成日期</td>
            <td>负责人</td>
            <td>状态</td>
        </tr>
        </thead>
        <tbody class="data">
        <c:forEach items="${result}" var="row" varStatus="status">
            <%--            当数组中此行有数据才输出--%>
            <c:if test="${row[0]!=null}">
                <tr>
                    <c:forEach items="${row}" var="ele">
                        <td>${ele}</td>
                    </c:forEach>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
