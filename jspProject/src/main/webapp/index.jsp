<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Date d=new Date();
out.println(d);
%>
<br>
<form action="login.jsp" method="post">
<input type="text" name="user" placeholder="Kullanıcı Adı"><br>
<input type="password" name="pass" placeholder="Şifre"><br>
<input type="submit" value="Login"><input type="reset" value="Reset">
</form>
</body>
</html>