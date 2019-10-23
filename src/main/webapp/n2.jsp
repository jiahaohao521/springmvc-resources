<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h3>恭喜，注册成功！！！</h3>
	
	<form action="/springmvc/user/update.do" method="post">
		username:<input type="text" name="username" value="${user.username }" /><span>${usernameError }</span> <br />
		password:<input type="text" name="password" value="${user.password }" /><span>${passwordError }</span> <br />
		<button type="submit">修改</button>
	</form>
</body>
</html>