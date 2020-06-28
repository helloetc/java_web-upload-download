<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>文件上传</title>
</head>
<body>
<!--表单的enctype属性要设置为multipart/form-data-->
<form action="UploadServlet" method="post" enctype="multipart/form-data">
    <table width="600">
        <tr>
            <td>上传者</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>上传文件</td>
            <td><input type="file" name="myfile"/></td>
        </tr>
        <tr>
            <!--设置单元格可横跨的列数。-->
            <td colspan="2"><input type="submit" value="上传"/></td>
        </tr>
    </table>
 
</form>
</body>
</html>
