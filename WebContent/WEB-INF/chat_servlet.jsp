<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Chat</title>
<link rel="stylesheet" href="design.css"></head>
<body>
	<form id="form" name="chatForm" action="JSPChat" method="post">
		<input type="text" name="ligne" value=""> 
		<input type="submit" name="action" value="submit"> 
		<input type="submit" name="action" value="refresh">
		<input type="submit" name="action" value="logout">		
	</form>	
	<pre id="content">
	Vous &ecirc;tes connect&eacute; en tant que: <%=session.getAttribute("login")%>
	<%=request.getAttribute("content")%>	
	</pre>
</body>
</html>
