<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  正确的账号：123456 密码：123456
  <br>
  <body>
    账号：
    <input type="text" name="userId" id="userId">  <br>
    密码：
    <input type="password" name="userPassword" id="userPassword"><br>
    输入验证码：   <br>
    <input type="text" id="verifi">
    
    
    <label for="" id="myshow" ></label>
    
    <input type="button" value="看不清" name="" onclick="toChange()">

    <br>
    <input type="button" value="提交" name="" onclick="toSubmit()">
    
    
    <div id="showTips"></div>
    
    <script src="./jq/jquery-3.3.1.min.js"></script>

    <script>
        function toSubmit() {
            var userId = $("#userId").val();
            var userPassword = $("#userPassword").val();
            var verifi = $("#verifi").val();
            
            $.ajax({
                url: "verification",
                type: 'POST',
                data: {'userId':userId,'userPassWord':userPassword,'verifi':verifi},
                dataType: "text",
                success: function (data) {
					 if(data == null || data == ""){
					 console.log(data)
					 	window.location.href = "logSuccess.jsp"
					 }else{
					  $('#showTips').text(data)

					 }
                }
            })
        }
        
        
        function toChange(){
        	 $.ajax({
                url: "verification",
                type: 'GET',
                data: {},
                dataType: "text",
                success: function (data) {
					   $('#myshow').text(data)
                }
            })
        }
        
         $.ajax({
                url: "verification",
                type: 'GET',
                data: {},
                dataType: "text",
                success: function (data) {
					   $('#myshow').text(data)
					  // console.log(data)
                }
            })

    </script>

</body>

</html>
