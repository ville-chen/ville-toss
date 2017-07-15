<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>requestMapping method参数测试</title>
</head>
<body>
hello from spring-mvc demo!

<a href="/test/default">Get请求default</a>

<form action="/test/default" method="post">
    <input type="submit" value="Post请求default">
</form>
</body>
</html>