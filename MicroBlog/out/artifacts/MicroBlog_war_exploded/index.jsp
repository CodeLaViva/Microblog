<%--
  Created by IntelliJ IDEA.
  User: 焱
  Date: 2018/6/2
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="jquery-3.1.1.js" language="JavaScript"></script>

    <script type="text/javascript">
        $.ajax({
            type: "GET",//put delete get post
            url: "localhost:8080/userinfo.do",
            async:true,//默认异步
            data : {
                'user_id':'lhz'
            },
            dataType:'json',
            //contentType:"application/x-www-form-urlencoded",//默认值
            success: function(data){
                alert(JSON.stringify(data));

                //alert("操作成功");
            },
            error: function(xhr,status,errMsg){
                alert(errMsg);
            }
        });
    </script>
  </head>
  <body>
  $END$
  </body>
</html>
