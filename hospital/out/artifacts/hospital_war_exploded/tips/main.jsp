<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YAHO
  Date: 2019/5/7
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提示信息</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/tips/css/main.css"/>
    <script src="../tool/jQuery.js"></script>
    <script language="JavaScript">
        //获取用户ID
        function get_user(){
            $('#main1',window.parent.document).html();
            return  parent.get_user();
        }

        //获取用户对应的tips
            function get_tips() {
                let user = get_user();
                $.ajax({
                    url: "/tips/get_tips",
                    type: "post",
                    jsonp:"json",
                    data: {
                        "user": user,
                        "src": "get_tips"
                    },
                    success: function (data) {
                        $(".tips").html('');
                        if (data.length==0){
                            $(".tips").append("没有新的提示！");
                            $(".tips").append(document.createElement('br'));
                        }
                        //console.log(data);
                        for (let i=0;i<data.length;i++){
                            $(".tips").append(data[i]['tips']);  //追加tips
                            $(".tips").append(document.createElement('br'));
                        }
                    }
                });
            }
    </script>
</head>
<body onload="get_tips()">
<%--<div id="tip">--%>
<%--        没有新的提示！--%>
<%--    <table>--%>
<%--        <c:forEach  items="${tips}" var="row" varStatus="status">--%>
<%--            ${row}--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
<div class="tips"></div>
</body>
</html>
