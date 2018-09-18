
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー削除</title>
<link rel="stylesheet" href=infoupdate.css>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
<div class="mx-auto" style="width: 500px;">
<div class="p-3 mb-2 text-white text-right">
<li class="navbar-text">${userInfo.name} さん </li><a href="LogoutServlet" class="text-danger">ログアウト</a></div>
</div>
<div class="mx-auto" style="width: 200px;">
<h3 class="user">ユーザ削除確認<br></h3></div>
<br>

<div class="mx-auto" style="width: 300px;">
ログインID：${user.loginId}<br>
を本当に削除してよろしいでしょうか。
<br>
<br>
<br>
<form action="userDeleteServlet" method="post">
    <table>
        <tr>
        <input type="hidden" name="id" value="${user.id}">
            <td><input name=delete type="submit" value="削除"></td>
        </tr>
    </table>
</form>
<form action="userListServlet" method="get">
    <table>
        <tr>
            <td><input name=cancel type="submit" value="キャンセル"></td>
        </tr>
    </table>
</form>

</div>
</div>

</body>
</html>





