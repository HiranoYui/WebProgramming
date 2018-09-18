<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ情報詳細参照</title>
<link rel="stylesheet" href=infodetail.css>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
<div class="mx-auto" style="width: 500px;">

<div class="p-3 mb-2 text-white text-right">
<li class="navbar-text">${userInfo.name} さん </li> <a href="LogoutServlet" class="text-danger">ログアウト</a></div>
</div>
</div>
<div class="mx-auto" style="width: 300px;">
<h3 class="user">ユーザ情報詳細参照<br></h3></div>

<div class="mx-auto" style="width: 400px;">
ログインID　　　　　${user.loginId}<br><br>
ユーザ名　　　　　${user.name}<br><br>
生年月日　　　　　${user.birthDate}<br><br>
登録日時　　　　　${user.createDate}<br><br>
更新日時　　　　　${user.updateDate}<br><br>
         </div>

<div class="container">
<a href="userListServlet?id=${user.id}" class="text-primary"　>戻る</a>
</div>
</div>
</body>
</html>