<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ情報更新</title>
<link rel="stylesheet" href=infoupdate.css>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
<div class="mx-auto" style="width: 500px;">
<div class="p-3 mb-2 text-white text-right">
<li class="navbar-text">${userInfo.name} さん </li>　<a href="LogoutServlet" class="text-danger">ログアウト</a></div>
</div>
<div class="mx-auto" style="width: 200px;">
<h3 class="user">ユーザ情報更新<br></h3></div>
<br>
<c:if test="${errMsg != null}" >
	    <div class="text-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
<form class="form-signin" action="userEditServlet" method="post">
<div class="mx-auto" style="width: 250px;">
ログインID　　　　　${user.loginId}<br><br><br><br>

<div class="mx-auto" style="width: 250px;">
<div class="input-group input-group-sm mb-3">
  <div class="input-group-prepend">
  <div class="row">


    <span class="input-group-text" id="basic-addon1">パスワード　</span>
  </div>
  <input name="password" type="password" class="form-control" placeholder="password" aria-label="password" aria-describedby="basic-addon1">

</div>
</div></div>

<div class="mx-auto" style="width: 250px;">
<div class="input-group input-group-sm mb-3">
  <div class="input-group-prepend">
  <div class="row">

    <span class="input-group-text" id="basic-addon1">パスワード(確認)　</span>
  </div>
  <input name="pwc" type="password" class="form-control" placeholder="password" aria-label="password" aria-describedby="basic-addon1">
</div>
</div></div>

<div class="mx-auto" style="width: 250px;">

ユーザ名　　　　　<input name="name"type="text" class="form-control" placeholder="text"  aria-describedby="basic-addon1" value="${user.name}"><br><br>
生年月日　　　　　<input name="birthDate" type="text" class="form-control" placeholder="text"  aria-describedby="basic-addon1" value="${user.birthDate}"><br><br>
</div>

<div class="mx-auto" style="width: 100px;">

<input type="hidden" value="${user.id}" name="id">

<input type="submit" value="更新">

<div class="mx-auto" style="width: 500px;">
<a href="userListServlet?id=${user.id}" class="text-primary"　>戻る</a>
</div>
</div>
</div>
</form>

</div>
</body>
</html>