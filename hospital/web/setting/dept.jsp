<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/5/27
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门字典</title>
    <link href="http://localhost:8080/setting/css/dept.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080/tool/main.css" rel="stylesheet" type="text/css"/>
    <script src="../tool/jQuery.js"></script>
    <script src="../tool/main.js"></script>
    <script language="JavaScript">
        //打开添加页面
        function insert() {
            window.open("/setting/dept_insert.jsp","_blank","width=600, height=550,left=690px,top=170px,location=no");
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
                        url: "/setting/dept_delete",
                        type: "post",
                        data: {
                            "id":id[i],
                            "src": "dept_delete"
                        },
                        success: function (data) {
                            if (status == false && data!=0) {
                                alert("删除成功！");
                                status = true;
                            }
                        },
                        error:function () {
                            alert("此部门已在单据中使用，无法删除！");
                        }
                    });
                }
            }
        }

        //停/启用
        function update_state() {
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
                //循环调用，实现选定多个同时
                for (let i = 0; i < id.length; i++) {
                    //将单号和src传递给后台
                    $.ajax({
                        url: "/setting/dept_update_state",
                        type: "post",
                        data: {
                            "id":id[i],
                        },
                        success: function (data) {
                            if (status == false && data!=0) {
                                alert("修改成功！");
                                status = true;
                            }
                        }
                    });
                }
            }
        }
    </script>
</head>
<body>
<div class="input">
    <form action="/setting/dept_select" method="post">
        <table>
            <tr>
                <td>部门编码：<input type="text" name="dept_code"></td>
                <td>部门名称：<input type="text" name="dept_name"></td>
            </tr>
            <input type="submit" id="select" value="查询"/>
            <input  style="display: none" name="src" value="dept_select"/>
        </table>
    </form>
</div>
<br/>

<div class="button">
    <button onclick="insert()">添加</button>
    <button onclick="del()">删除</button>
    <button onclick="update_state()">停/启用</button>
</div>
<div>
    <table class="title">
        <tr>
            <td style="width: 10px"></td>
            <td>部门编码</td>
            <td>部门名称</td>
            <td>是否停用</td>
        </tr>
    </table>
    <table class="data" border="1">
        <c:forEach items="${result}" var="row" varStatus="status">
            <%--            当数组中此行有数据才输出--%>
            <c:if test="${row[0]!=null}">
                <tr>
                    <td style="width: 10px;"><input type="checkbox" value="${row[0]}" name="${status.count}" id="check"></td>
                        <%--                <c:out value="${status.count}"/>--%>
                    <c:forEach items="${row}" var="ele">
                        <td>${ele}</td>
                    </c:forEach>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>
</body>
</html>
