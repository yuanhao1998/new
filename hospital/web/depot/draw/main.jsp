<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/4/18
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科室领用</title>
    <link href="http://localhost:8080/depot/draw/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080/tool/main.css" rel="stylesheet" type="text/css"/>
    <script src="../../tool/jQuery.js"></script>
    <script src="../../tool/jquery-ui.js"></script>
    <script src="../../tool/main.js"></script>
    <script language="JavaScript">
        //打开添加页面
        function insert() {
            window.open("/depot/draw/insert.jsp?user="+get_user(),"_blank","width=600, height=600,left=600px,top=180px");
        }


        //打开详情页面
        function detail(obj,obj1) {
            //var a=$("#"+obj).attr("id");
            window.open("/depot/draw/detail.jsp?draw_no="+obj+"&state="+obj1,"_blank","width=1200, height=800,left=350px,top=100px");
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
                        $('.data tbody').find("tr").eq(i).each(function () {
                            let trs = $(this).find("td").eq(6).text();
                            if (trs == '已审核') {
                                alert("有单据已审核，请先消审！");
                                state = false;
                            }
                        })
                    }
                }
            }
            if (state == true) {
                let status = false;          //控制审核成功对话框只弹出来一次
                //循环调用，实现选定多个同时删除
                for (let i = 0; i < id.length; i++) {
                    //将单号和sql_key传递给后台
                    $.ajax({
                        url: "/depotDraw/delete",
                        type: "post",
                        data: {
                            "id":id[i],
                            "src": "delete"
                        },
                        success: function (data) {
                            if (status == false && data > 0) {
                                alert("删除成功！");
                                status = true;
                            }
                        }
                    });
                }
            }
        }

        //审核
        function audit() {
            let groupCheckbox = $("input[id='check']");    //遍历寻找选中的checkbox
            let id = new Array();                   //数组存放选定的单据
            let user = get_user();                  //登录用户
            let state = true;                      //记录审核状态
            for (let i = 0; i < groupCheckbox.length; i++) {
                if (state == true) {
                    if (groupCheckbox[i].checked) {
                        id.push(groupCheckbox[i].value);         //单号
                        $('.data tbody').find("tr").eq(i).each(function (){
                            let trs = $(this).find("td").eq(6).text();
                            if (trs == '已审核') {
                                alert("有单据已审核过！");
                                state = false;
                            }
                        })
                    }
                }
            }
            if (state == true) {
                let status = false;          //控制审核成功对话框只弹出来一次
                for (let i = 0; i < id.length; i++) {
                    $.ajax({
                        url: "/depotDraw/audit",
                        type: "post",
                        data: {
                            "id": id[i],
                            "src": "audit",
                            "user": user
                        },
                        success: function (data) {
                            if (status == false && data > 0) {
                                alert("审核成功！");
                                status = true;
                            }
                            else if (status == false && data== -1 ) {
                                alert("有卡片已被退库或没有添加卡片");
                                status = true;
                            }
                        }
                    });
                }
            }
        }


        //消审
        function remove() {
            let groupCheckbox = $("input[id='check']");    //遍历寻找选中的checkbox
            let id = new Array();
            let state = true;                      //记录审核状态
            for (let i = 0; i < groupCheckbox.length; i++) {
                if (state == true) {
                    if (groupCheckbox[i].checked) {
                        id.push(groupCheckbox[i].value);         //单号
                        $('.data tbody').find("tr").eq(i).each(function () {
                            let trs = $(this).find("td").eq(6).text();
                            if (trs == '新建') {
                                alert("新建单据无法消审！");
                                state = false;
                            }
                            if (trs == '消审') {
                                alert("不能重复消审！");
                                state = false;
                            }
                        })
                    }
                }
            }
            if (state == true) {
                let status = false;          //控制审核成功对话框只弹出来一次
                for (let i = 0; i < id.length; i++) {
                    $.ajax({
                        url: "/depotDraw/remove",
                        type: "post",
                        data: {
                            "id": id[i],
                            "src": "remove",
                        },
                        success: function (data) {
                            if (status == false && data>0) {
                                alert("消审成功！");
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
    <form action="/depotDraw/select" method="post">
        <table>
            <tr>
                <td>领用日期：<input type="date" name="bdate">至<input type="date" name="edate"></td>
                <td>领用单号：<input type="text" name="draw_no"></td>
            </tr>
            <tr>
                <td>领用科室：<input type="text" id="dept" name="dept" onkeyup="get_option2(this)"></td>
                <td>库房：<input type="text" id="store" name="store" onkeyup="get_option2(this)"></td>
                <td>状态：<input type="text" name="state"></td>
            </tr>
            <tr>
                <td>制单人：<input type="text" name="create"></td>
            </tr>
            <input type="submit" id="select" value="查询"/>
            <input  style="display: none" name="src" value="depotDraw_select"/>
        </table>
    </form>
</div>
<div class="button">
    <br/>
    <div style="float:left;height: 50px;width: 100%">
        <button onclick="insert()">添加</button>
        <button onclick="del()">删除</button>
        <button onclick="audit()">审核</button>
        <button onclick="remove()">消审</button>
    </div>
</div>
<div class="result">
    <table class="title">
        <tr>
            <td>单号</td>
            <td>部门</td>
            <td>仓库</td>
            <td>制单人</td>
            <td>制单日期</td>
            <td>状态</td>
            <td>审核人</td>
            <td>备注</td>
            <td>查看</td>
        </tr>
    </table>
    <table class="data" id="data" border="1">
        <%--循环读取二维数组--%>
        <c:forEach items="${result}" var="row" varStatus="status">
            <%--            当数组中此行有数据才输出--%>
            <c:if test="${row[0]!=null}">
                <tr>
                    <td style="width: 10px;"><input type="checkbox" value="${row[0]}" name="${status.count}" id="check"></td>
                        <%--                <c:out value="${status.count}"/>--%>
                    <c:forEach items="${row}" var="ele">
                        <td>${ele}</td>
                    </c:forEach>
                    <td><button id="${row[0]}" onclick="detail(${row[0]},'${row[5]}')">详细</button></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>

</body>
</html>
