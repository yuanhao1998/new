<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/5/23
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退库单详情</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/depot/out/css/detail.css">
    <link href="http://localhost:8080/tool/main.css" rel="stylesheet" type="text/css"/>
    <script src="../../tool/jQuery.js"></script>
    <script src="../../tool/jquery-ui.js"></script>
    <script src="../../tool/main.js"></script>
    <script language="JavaScript">
        //打开添加页面
        function insert(obj) {
            window.open("/depot/out/detail_insert.jsp?out_no="+obj,"_blank","width=1000, height=600,left=480px,top=170px");
        }
        //当单据审核或者生成卡片后无法修改
        function init() {
            let state= decodeURI(window.location.search.substring(1)).split('=')[2];  //获取传进来的state
            //alert(state)
            if (state == '已审核' || state == '已生成'){
                $('#insert').attr('disabled',true);
                $('#del').attr('disabled',true);
            }
        }

        //查询
        function select() {
            $.ajax({
                url:"/depotOut/detail_select",
                type:"post",
                data:{
                    "out_no":${param.out_no},
                    "src": "detail_select"
                },
                success:function (data) {
                    //console.log(data, '22222');
                    let tbody = document.querySelector('.data');
                    $(tbody).html(''); //每次生成之前清空页面
                    for (let i = 0; i < data.length; i++) {
                        //console.log(i)
                        let tr = document.createElement('tr');
                        let td = document.createElement('td');
                        let checkbox = document.createElement('input');
                        $(checkbox).attr('type', 'checkbox');
                        $(checkbox).attr('id', 'check');
                        $(td).html(checkbox);
                        $(tr).html(td);
                        for (let j = 0 ; j < data[i].length; j++) {
                            let td = document.createElement('td');
                            //console.log(td)
                            $(td).html(data[i][j]);
                            $(tr).append(td);
                            if (j === 0) {
                                $(checkbox).val(data[i][j])
                            }

                        }
                        //console.log(tr);
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
                    }
                }
            }
            if (state == true) {
                let status = false;          //控制审核成功对话框只弹出来一次
                //循环调用，实现选定多个同时删除
                for (let i = 0; i < id.length; i++) {
                    //将单号和src传递给后台
                    $.ajax({
                        url: "/depotOut/detail_delete",
                        type: "post",
                        data: {
                            "id":id[i],
                            "src": "detail_delete"
                        },
                        success: function (data) {
                            if (status == false && data == 1) {
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
    <button id="insert" onclick="insert(${param.out_no})">添加</button>
    <button id="del" onclick="del()">删除</button>
    <button id="select" onclick="select()">查询</button>
</div>
<div>
    <br/>
    <table class="title">
        <tr>
            <td style="width: 50px"></td>
            <td>卡片号</td>
            <td>资产名称</td>
            <td>规格</td>
            <td>仓库</td>
            <td>供应商</td>
        </tr>
    </table>
    <table class="data" border="1px">

    </table>
</div>
</body>
</html>
