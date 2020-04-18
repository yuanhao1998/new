<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/5/7
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入库单详情页</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/depot/in/css/detail.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/tool/main.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/tool/main.js">
    <script src="../../tool/jQuery.js"></script>
    <script src="../../tool/jquery.page.js"></script>
    <script language="JavaScript">

        //当单据审核或者生成卡片后无法修改
        function init() {
           let state= decodeURI(window.location.search.substring(1)).split('=')[2];  //获取传进来的state
           //alert(state)
            if (state == '已审核' || state == '已生成'){
                $('#insert').attr('disabled',true);
                $('#del').attr('disabled',true);
            }
        }
        
        //打开添加页面
        function insert(obj) {
            window.open("/depot/in/detail_insert.jsp?in_no="+obj,"_blank","width=600, height=600,left=600px,top=180px");
        }
        
        //查询
        function select() {
            <%--alert(${param.in_no});--%>
            $.ajax({
                url:"/depotIn/detail_select",
                type:"post",
                data:{
                    "in_no":${param.in_no},
                    "src": "depotIn_detail_select"
                },
                success:function (data) {
                    console.log(data);
                    let tbody = document.querySelector('.data');
                    $(tbody).html('');  //每次生成之前清空页面
                    for (let i = 0; i < data.length; i++) {
                        let tr = document.createElement('tr');
                        let checkbox = document.createElement('input');
                        $(checkbox).attr('type', 'checkbox');
                        $(checkbox).attr('id', 'check');
                        $(tr).html(checkbox);
                        for (let j = 0 ; j < data[i].length; j++) {
                            if (data[i][j]) {
                                let td = document.createElement('td');
                                $(td).html(data[i][j]);
                                $(tr).append(td);
                                if (j === 0) {
                                    $(checkbox).val(data[i][j])
                                }
                            } else {
                                return
                            }
                        }
                        $(tbody).append(tr);
                    }
                }
            });
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
                        //alert(id.toString());
                    }
                }
            }
            if (state == true) {
                let status = false;          //控制审核成功对话框只弹出来一次
                //循环调用，实现选定多个同时删除
                for (let i = 0; i < id.length; i++) {
                    //将单号和sql_key传递给后台
                    $.ajax({
                        url: "/depotIn/detail_delete",
                        type: "post",
                        data: {
                            "id":id[i],
                            "src": "depotIn_detail_delete"
                        },
                        success: function () {
                            if (status == false) {
                                alert("删除成功！");
                                status = true;
                            }
                        }
                    });
                }
            }
        }
    </script>
</head>
<body onload="init()">
<div class="button">
    <br/>
    <button id="insert" onclick="insert(${param.in_no})">添加</button>
    <button id="del" onclick="del()">删除</button>
    <button id="select" onclick="select()">查询</button>
<%--    <form action="/depotIn/datail_select" method="post" id="select">--%>
<%--        <input style="display: none" name="in_no" value="${param.in_no}">--%>
<%--        <input style="display: none" name="src" value="depotIn_datail_select">--%>
<%--        <input type="submit" value="查询">--%>
<%--    </form>--%>
</div>
<div>
    <br/>
    <table class="title">
        <tr>
            <td style="width: 15px"></td>
            <td>序号</td>
            <td>资产名称</td>
            <td>单价</td>
            <td>数量</td>
            <td>规格</td>
            <td>备注</td>
        </tr>
    </table>
    <table class="data" border="1">

    </table>
</div>
<%--<div>--%>
<%--    <table class="data" id="data" border="1">--%>
<%--        &lt;%&ndash;循环读取二维数组&ndash;%&gt;--%>
<%--        <c:forEach items="${data}" var="row" varStatus="status">--%>
<%--            &lt;%&ndash;            当数组中此行有数据才输出&ndash;%&gt;--%>
<%--            <c:if test="${row[0]!=null}">--%>
<%--                <tr>--%>
<%--                    <td style="width: 10px;"><input type="checkbox" value="${row[0]}" name="${status.count}" id="check"></td>--%>
<%--                        &lt;%&ndash;                <c:out value="${status.count}"/>&ndash;%&gt;--%>
<%--                    <c:forEach items="${row}" var="ele">--%>
<%--                        <td>${ele}</td>--%>
<%--                    </c:forEach>--%>
<%--                </tr>--%>
<%--            </c:if>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
</body>
</html>
