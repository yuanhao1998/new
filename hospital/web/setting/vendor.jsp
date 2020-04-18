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
    <title>供应商字典</title>
    <link href="http://localhost:8080/setting/css/vendor.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080/tool/main.css" rel="stylesheet" type="text/css"/>
    <script src="../tool/jQuery.js"></script>
    <script src="../tool/jquery-ui.js"></script>
    <script src="../tool/main.js"></script>
    <script language="JavaScript">
        // 打开添加页面
        function insert() {
            window.open("/setting/vendor_insert.jsp","_blank","width=600, height=900,left=750px,top=75px,location=no");
        }
        //打开详细页面
        function detail(obj) {
            //var a=$("#"+obj).attr("id");
            //alert(obj);
            window.open("/setting/vendor_detail.jsp?ven_code="+obj,"_blank",'width=550, height=850,left=750px,top=100px,scrollbars=no');
        }
        //删除
        function del() {
            //获取所有checkbox
            let id = new Array();
            let state = true;                                        //记录审核状态
            let groupCheckbox = $("input[id='check']");
            for (let i = 0; i < groupCheckbox.length; i++) {             //遍历所有checkbox
                if (state == true) {
                    if (groupCheckbox[i].checked) {                //如果处于被选中的状态，执行删除
                        id.push(groupCheckbox[i].value);           //单号
                    }
                }
            }
            if (state == true) {
                let status = false;          //控制审核成功对话框只弹出来一次
                //循环调用，实现选定多个同时删除
                for (let i = 0; i < id.length; i++) {
                    //将单号和src传递给后台
                    $.ajax({
                        url: "/setting/vendor_delete",
                        type: "post",
                        data: {
                            "id":id[i],
                            "src": "vendor_delete"
                        },
                        success: function (data) {
                            if (status == false && data!=0) {
                                alert("删除成功！");
                                status = true;
                            }
                        },
                        error:function () {
                            alert("此供应商已在单据中使用，无法删除！");
                        }
                    });
                }
            }
        }
    </script>
</head>
<body>
<div class="input">
    <form action="/setting/vendor_select" method="post">
        <table>
            <tr>
                <td>供应商名称：<input type="text" name="ven_name"></td>
                <td>供应商编码：<input type="text" name="ven_code"></td>
                <td>供应商类型：<input type="text" id="ven_type" name="ven_type" onkeyup="get_option2(this)"></td>
            </tr>
            <input type="submit" id="select" value="查询"/>
            <input  style="display: none" name="src" value="vendor_select"/>
        </table>
    </form>
</div>
<div class="button">
    <button onclick="insert()">添加</button>
    <button onclick="del()">删除</button>
</div>
<div class="data">
    <br/>
    <table class="title">
        <tr>
            <td style="width: 10px"></td>
            <td>供应商编码</td>
            <td>供应商名称</td>
            <td>供应商类型</td>
            <td style="width: 50px"></td>
        </tr>
    </table>
    <table class="data" border="1px">
        <c:forEach items="${result}" var="row" varStatus="status">
            <%--            当数组中此行有数据才输出--%>
            <c:if test="${row[0]!=null}">
                <tr>
                    <td style="width: 10px;"><input type="checkbox" value="${row[0]}" name="${status.count}" id="check"></td>
                        <%--                <c:out value="${status.count}"/>--%>
                    <c:forEach items="${row}" var="ele">
                        <td>${ele}</td>
                    </c:forEach>
                    <td style="width: 50px"><button id="${row[0]}" onclick="detail('${row[0]}')">详细</button></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>
</body>
</html>
