<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% int count = (int)request.getAttribute("registcount"); %>
<% int wordNum = (int)request.getAttribute("total"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
<p><%= count %>件登録しました。</p>
<p>登録件数は<%= wordNum %>件です。</p>
</body>
</html>