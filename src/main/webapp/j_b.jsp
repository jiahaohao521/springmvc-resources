<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.js"></script>
</head>
<body>
	<h3>j_b.jsp</h3>
	
	<button>ajax go</button><br />
	<button>ajax go2</button><br />
	<button>ajax go3</button><br />
	
	<button>ajax go4</button><br />
	
	
	<button>ajax go5</button><br />
	
	<button>ajax go6</button><br />
	
	<script>
		$(function() {
			$("button:eq(0)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/user/save.do",
					headers: {
						Accept: "application/json"
					},
					success: function(data) {
						alert(data);
					}
				});				
			});


			$("button:eq(1)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/user/save2.do",
					// data:{id:100, name:"andy", birthday:"2012/12/21", money:2000},
					data: "id::200||name::eason",
					headers: {
						"Content-Type":"text/user"
					},
					success: function(data) {
					}
				});				
			});

			$("button:eq(2)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/user/save3.do",
					data: "id::300##name::ella##birthday::2012-2-23##money::555",
					headers: {
						"Content-Type":"text/user"
					},
					success: function(data) {
					}
				});				
			});


			$("button:eq(3)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/user/save4.do",
					data: "{\"id\":111,\"name\":\"hebe\",\"birthday\":\"2019/12/29\", \"money\":300}",   
					headers: {
						"Content-Type":"application/json"
					},	
					success: function(data) {
					}
				});				
			});


			$("button:eq(4)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/user/save5.do",
					headers: {
						Accept:"text/user"
					},	
					success: function(data) {
						alert(data);
					}
				});				
			});

			$("button:eq(5)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/user/save6.do",
					headers: {
						Accept:"application/json"
					},	
					success: function(data) {
						alert(data);
					}
				});				
			});
		});



	</script>
	
	
</body>
</html>