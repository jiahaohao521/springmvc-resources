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
	<!-- 
		文件上传时，form表单有2个必须：
		1. method必须是post.  
		2. enctype="multipart/form-data"
			如果不加 enctype="multipart/form-data"，
			则enctype默认取值为: application/x-www-form-urlencoded,该值表示表单给后台传数据的格式为：键值对，
			此时不会传递图片的2进制内容
			加上了 enctype="multipart/form-data"以后，则表单就会把图片的名字和2进制一起传送给后台服务器！
	 -->
	<form action="/springmvc/user/upload.do" method="post"
		enctype="multipart/form-data">
		photo:<input type="file" name="photo" /><br />
		<button type="submit">upload</button>
	</form>

	<hr />

	<script> 
		$(function() {
			$("#b2").click(function() {
				// 获取文件上传域中，所选择的图片的二进制
				var p2 = document.getElementById("p2");
				var file = p2.files[0];
				// 模拟表单数据
				var formData = new FormData();
				formData.append("photo", file);

				$.ajax({
					type : "post",
					url : "/springmvc/user/upload.do",
					processData : false, // 使数据不做处理
					contentType : false, // 不要设置Content-Type请求头   等价于表单中的 enctype="multipart/form-data"
					data : formData
				});

			});
		});
	</script>
	<form>
		photo:<input id="p2" type="file" name="photo" /><br />
		<button id="b2" type="button">ajax upload</button>
	</form>
</body>
</html>