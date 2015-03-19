<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat</title>
<link rel="stylesheet" href="design.css"></head>
</head>
<body>
	<form id="formLogin" name="chatForm" action="JSPChat" method="post">
		Veillez sasir un login pour acc&eacute;der au chat.
		<input type="text" name="login"  value=""> 
		<input type="submit" name="action" value="Login">
	</form>
</body>
</html>