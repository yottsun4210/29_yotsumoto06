<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>Index</title>
</head>
<body>
	<p>英単語と日本語を登録してください。</p>
	<form action="input" method="post">
	<table>
	<tr><th>英単語</th><td><input type="text" name="english"></td></tr>
	<tr><th>日本語</th><td><input type="text" name="japanese"></td></tr>
	</table>
	<input type="submit">
	</form>
</body>
</html>