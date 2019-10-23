<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>8种基本类型</legend>
		<form action="/springmvc/user/save.do" method="post">
			byte: <input type="text" name="b" /> <br />  
			short: <input type="text" name="s" /> <br /> 
			int: <input type="text" name="i" /> <br /> 
			long: <input type="text" name="l" /> <br />
			float: <input type="text" name="f" /> <br />
			double: <input type="text" name="d" /> <br />
			boolean: <input type="text" name="bb" /> <br />
			char: <input type="text" name="c" /> <br />
			<button type="submit">go</button>
		</form>
	</fieldset>
	
	
	<fieldset>
		<legend>对象类型</legend>
		<form action="/springmvc/user/save2.do" method="post">
			id: <input type="text" name="id" /> <br />
			name: <input type="text" name="name" /> <br />
			<!-- springmvc要求的日期格式默认为yyyy/MM/dd -->
			birthday: <input type="text" name="birthday" /> <br />
			money: <input type="text" name="money" /> <br />
			<button type="submit">go</button>
		</form>
	</fieldset>
	
	
	<fieldset>
		<legend>List类型</legend>
		<form action="/springmvc/user/save3.do" method="post">
			hobby: 
			<input type="checkbox" name="hobby" value="football" />足球 <br />
			<input type="checkbox" name="hobby" value="basketball"   />篮球 <br />
			<input type="checkbox" name="hobby" value="volleyball" />排球 <br />
			<button type="submit">go</button>
		</form>
	</fieldset>
	
	<fieldset>
		<legend>Set类型</legend>
		<form action="/springmvc/user/save4.do" method="post">
			hobby: 
			<input type="checkbox" name="hobby" value="hotpot" />火锅 <br />
			<input type="checkbox" name="hobby" value="maocai"   />冒菜 <br />
			<input type="checkbox" name="hobby" value="chuanchuan" />串串 <br />
			<button type="submit">go</button>
		</form>
	</fieldset>
	
	<fieldset>
		<legend>Map类型</legend>
		<form action="/springmvc/user/save5.do" method="post">
			hobby: 
			<input type="checkbox" name="a" value="film" />电影 <br />
			<input type="checkbox" name="b" value="game"   />游戏 <br />
			<input type="checkbox" name="c" value="study" />学习 <br />
			<button type="submit">go</button>
		</form>
	</fieldset>
	
	<fieldset>
		<legend>类类型的参数，可以为null</legend>
		<form action="/springmvc/user/save6.do" method="post">
			a: <input type="text" name="a"/> <br />
			b: <input type="text" name="b"/> <br />
			<button type="submit">go</button>
		</form>
	</fieldset>
	
	
	
</body>
</html>