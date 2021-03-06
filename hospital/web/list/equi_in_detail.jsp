<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/6/12
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入库明细</title>
    <link href="http://localhost:8080/list/css/equi_in_detail.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost:8080/tool/main.css" rel="stylesheet" type="text/css"/>
    <script src="../tool/jQuery.js"></script>
    <script src="../tool/jquery-ui.js"></script>
    <script src="../tool/main.js"></script>
    <script language="JavaScript">
        function select() {
            $.ajax({
                url: "/List/equi_in_detail",
                type: "post",
                data: {
                    "month":$('#month').val(),
                    "store":$('#store').val(),
                    "src":"equi_in_detail"
                },
                success: function (data) {
                    //console.log(data, '22222');
                    let tbody = document.querySelector('.data');
                    $(tbody).html(''); //每次生成之前清空页面
                    for (let i = 0; i < data.length; i++) {
                        //console.log(i)
                        let tr = document.createElement('tr');
                        for (let j = 0 ; j < data[i].length; j++) {
                            let td = document.createElement('td');
                            //console.log(td)
                            $(td).html(data[i][j]);
                            $(tr).append(td);
                        }
                        //console.log(tr);
                        $(tbody).append(tr);
                    }
                }
            });
        }
    </script>
</head>
<body>
<div>
    <tr><td>年月：<input type="month" id="month" name="month"></td></tr>
    <tr><td>仓库：<input type="text" id="store" name="store" onkeyup="get_option2(this)"></td></tr>
</div>
<button id="select" onclick="select()">查询</button>
<div>
    <table class="title">
        <tr>
            <td>单号</td>
            <td>资产名称</td>
            <td>价格</td>
            <td>购买人</td>
            <td>供应商</td>
            <td>状态</td>
            <td>入库日期</td>
        </tr>
    </table>
    <table class="data">
    </table>
</div>
</body>
</html>
