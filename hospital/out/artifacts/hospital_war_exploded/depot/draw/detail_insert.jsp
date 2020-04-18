<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/6/10
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加卡片</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/depot/draw/css/detail_insert.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/tool/main.css">
    <script src="../../tool/jQuery.js"></script>
    <script src="../../tool/jquery-ui.js"></script>
    <script src="../../tool/main.js"></script>
    <script language="JavaScript">
        function select() {
            $.ajax({
                url:"/depotDraw/detail_insert_select",
                type:"post",
                data:{
                    "draw_no":${param.draw_no},
                    "card_no":$('#card_no').val(),
                    "src":"detail_insert_select"
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
            })
        }

        //添加卡片
        function insert_card() {
            //获取所有checkbox
            let id = new Array();
            let state = true;                                        //记录审核状态
            let groupCheckbox = $("input[id='check']");
            for (let i = 0; i < groupCheckbox.length; i++) {             //遍历所有checkbox
                if (state == true) {
                    if (groupCheckbox[i].checked) {                //如果处于被选中的状态
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
                        url: "/depotDraw/detail_insert",
                        type: "post",
                        data: {
                            "draw_no":${param.draw_no},
                            "card_no":id[i],
                            "src": "detail_insert"
                        },
                        success: function (data) {
                            if (status == false && data !=0) {
                                alert("添加成功！");
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
    <span>卡片：</span><input id="card_no" name="card_no" type="text" />
    <button onclick="select()">查询</button>
</div>
<br/>
<div>
    <table class="title">
        <tr>
            <td style="width: 50px"></td>
            <td>卡片号</td>
            <td>名称</td>
            <td>供应商</td>
            <td>仓库</td>
        </tr>
    </table>
    <table class="data" border="1px">

    </table>
</div>
<button class="submit" onclick="insert_card()">确定</button>
</body>
</html>
