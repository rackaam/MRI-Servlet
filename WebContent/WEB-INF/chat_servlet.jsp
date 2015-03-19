<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Title of the document</title>
</head>
<body>
	<form name="chatForm" action="JSPChat" method="post">
		<input type="text" name="ligne" value=""> 
		<input type="submit" name="action" value="submit"> 
		<input type="submit" name="action" value="refresh">
	</form>
	<pre>
<%=request.getAttribute("content")%>
	</pre>
</body>
</html>
