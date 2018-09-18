<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="p-3 mb-2 text-white text-right">
<li class="navbar-text">${userInfo.name} さん </li><a href="LogoutServlet" class="text-danger">ログアウト</a></div>
ユーザー情報更新<br>
<span>ログインID</span><input type="text" name="login_id"><br>
<br>
<span>パスワード</span><input type="password" name="password"><br>
<br>
<span>パスワード(確認)</span><input type="password" name="passwordc"><br>
<br>
<span>ユーザ名</span><input type="text" name="user_name"><br>
<br>
<span>生年月日</span><input type="date" name="birthdate"><br>
<br>
<input type="submit" value="更新">
</body>
</html>