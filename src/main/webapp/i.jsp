<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>i.jsp</h3>	
	
	页面范围：${pageScope.x } <br />
	请求范围：${requestScope.x } <br />
	会话范围：${sessionScope.x } <br />
	应用范围：${applicationScope.x } <br />
	
	<hr />
	
	${user} <br />
	${user2}<br />
	${string }<br />
	${userList }<br />
	
	<hr />
	
	${aa }<br />
	${date }
	
	<hr />
	
	abc : ${requestScope.abc }<br />
	xyz : ${sessionScope.xyz }<br />
	aaa : ${applicationScope.aaa }<br />
</body>
</html>