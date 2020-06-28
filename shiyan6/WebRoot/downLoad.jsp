<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import = "DAO.getFileName" %>
<%@ page import = "java.io.File" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <meta charset="UTF-8">
    <title>文件下载</title>

  </head>
  
  <body>
  *****点击文件进行下载*****
  <br>
  
  <%
  	String[] list = new String[500];
  	getFileName toGetName = new getFileName();
    list = toGetName.getNames();
    
  	int i=0;
  	while(i<list.length){
  		System.out.println(i);
  
   %>
  
  
   <a href="Download?filename=<%=list[i]%>" style="boackground:#ccc;"><%=list[i]%></a>

   <br>
    <br>
   
   <%
   		i++;
  	}
    %>
  </body>
</html>
