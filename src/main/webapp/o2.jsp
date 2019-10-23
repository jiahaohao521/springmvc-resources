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
	<h3>o2.jsp</h3>

	<script>
		$(function(){
			$("button:eq(0)").click(function() {
				$.ajax({
					type:"get",
					url:"/springmvc/users"
				});
			});

			$("button:eq(1)").click(function() {
				$.ajax({
					type:"get",
					url:"/springmvc/users/22/kkk"
				});
			});

			$("button:eq(2)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/users"
				});
			});

			$("button:eq(3)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/users",
					data: {id:24, "_method":"delete"}
				});
			});

			$("button:eq(4)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/users",
					data: {name:"郑伊健", "_method":"put"}
				});
			});
		});
	</script>
	
	<button>findAll</button>
	<button>findOne</button>
	<button>save</button>
	<button>delete</button>
	<button>update</button>
</body>
</html>