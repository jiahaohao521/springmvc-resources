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
	<script>
// 		$(function() {
// 			$("form:eq(0)").submit(function() {

// 				var aa=false,bb=false;
				
// 				if($("input[name=username]").val().length == 0) {
// 					$("input[name=username]").next().html("username不能为空");
// 					aa = false;
// 				} else {
// 					$("input[name=username]").next().html("");
// 					aa = true;
// 				}

// 				if($("input[name=password]").val().length == 0) {
// 					$("input[name=password]").next().html("password不能为空");
// 					bb = false;
// 				} else {
// 					$("input[name=password]").next().html("");
// 					bb = true;
// 				}
				
// 				// 在事件处理函数中，如果返回false，则表示，就当这件事情没有发生过。
// 				return aa&&bb;
// 			});
// 		});
	</script>
	<h3>n.jsp</h3>
	<form action="/springmvc/user/save.do" method="post">
		id:<input type="text" name="id" value="${user.id }" /><span>${idError }</span> <br />
		username:<input type="text" name="username" value="${user.username }" /><span>${usernameError }</span> <br />
		password:<input type="text" name="password" value="${user.password }" /><span>${passwordError }</span> <br />
		money:<input type="text" name="money" value="${user.money }" /><span>${moneyError }</span> <br />
		cellphone:<input type="text" name="cellphone" value="${user.cellphone }" /><span>${cellphoneError }</span> <br />
		<button type="submit">注册</button>
	</form>
</body>
</html>