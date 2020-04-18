<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/4/16
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>医院固定资产管理系统</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/login/css/left.css">
    <script src="../tool/jQuery.js"></script>
    <script language="JavaScript">
        // 控制菜单栏滑动动画
        $(document).ready(function(){
            $(".tree li").click(function(){
                if (this.className != 'normal'){                 //获取到的class不是normal，控制对应的菜单栏滑动
                    $("."+this.className+"_detail").slideToggle("normal");
                }
            });
        });
        //根据left的data-src控制右侧显示的页面
        $(document).ready(function(){                   //一级菜单
            $(".normal  a").click(function(){
                let  src = $(this).attr("data-src");
                $('#main1',window.parent.document).attr("src",src);
            });
        });
        $(document).ready(function(){
            $(".tree ul li a").click(function(){          //二级菜单
                let  src = $(this).attr("data-src");
                $('#main1',window.parent.document).attr("src",src);
            });
        });
    </script>
</head>
<body>
<div class="main">
    <ul class="tree">
        <li class="normal"><span></span><a data-src="../tips/main.jsp" id="tips">提示信息</a></li>
        <li class="depot"><span></span><a>库房管理</a></li>
        <ul class="depot_detail">
            <li><a data-src="../depot/in/main.jsp" id="in">资产入库</a></li>
            <li><a data-src="../depot/out/main.jsp" id="out">资产退库</a></li>
            <li><a data-src="../depot/draw/main.jsp">科室领用</a></li>
        </ul>
        <li class="normal"><span></span><a data-src="../scrap/main.jsp">资产处置</a></li>
        <li class="normal"><span></span><a data-src="../select/main.jsp">资产查询</a></li>
        <li class="list"><span></span><a>报表查询</a></li>
        <ul class="list_detail">
            <li><a data-src="../list/equi_month_list.jsp">资产月报</a></li>
            <li><a data-src="../list/equi_in_detail.jsp">入库明细</a></li>
            <li><a data-src="../list/dept_draw_list.jsp">科室明细</a></li>
        </ul>
        <li class="setting"><span></span><a>基础设置</a></li>
        <ul class="setting_detail">
            <li><a data-src="../setting/vendor.jsp">供应商字典</a></li>
            <li><a data-src="../setting/dept.jsp">部门字典</a></li>
            <li><a data-src="../setting/equi.jsp">资产字典</a></li>
        </ul>
    </ul>
</div>
</body>
</html>
