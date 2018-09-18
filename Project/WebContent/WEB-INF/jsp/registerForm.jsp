<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ新規登録</title>
<link rel="stylesheet" href=newuser.css>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="mx-auto" style="width: 500px;">
			<div class="p-3 mb-2 text-white text-right">
	<div class="p-3 mb-2 text-white text-right">
<li class="navbar-text">${userInfo.name} さん </li> <a href="LogoutServlet" class="text-danger">ログアウト</a>
			</div>
		</div>
		<div class="mx-auto" style="width: 200px;">
			<h3 class="user">
				ユーザ新規登録<br>
			</h3>
		</div>

		<br>
		<c:if test="${errMsg != null}" >
		<div class="mx-auto" style="width: 200px;">
	    <div class="text-danger text-right" role="alert">
		  ${errMsg}
		</div>
		</div>
	</c:if>
		<form class="form-signin" action="RegisterUser" method="post">
			<div class="mx-auto" style="width: 250px;">
				<div class="input-group input-group-sm mb-3">
					<div class="input-group-prepend">
						<div class="row">

							<span class="input-group-text" id="basic-addon1">ログインID </span>
						</div>
						<input name="id" type="text" class="form-control"
							placeholder="login_id" aria-label="login_id"
							aria-describedby="basic-addon1">
					</div>
				</div>
			</div>

			<div class="mx-auto" style="width: 250px;">
				<div class="input-group input-group-sm mb-3">
					<div class="input-group-prepend">
						<div class="row">

							<span class="input-group-text" id="basic-addon1">パスワード </span>
						</div>
						<input name="password" type="password" class="form-control"
							placeholder="password" aria-label="password"
							aria-describedby="basic-addon1">

					</div>
				</div>
			</div>

			<div class="mx-auto" style="width: 250px;">
				<div class="input-group input-group-sm mb-3">
					<div class="input-group-prepend">
						<div class="row">

							<span class="input-group-text" id="basic-addon1">パスワード(確認)
							</span>
						</div>
						<input name="pwc" type="password" class="form-control"
							placeholder="password" aria-label="password"
							aria-describedby="basic-addon1">
					</div>
				</div>
			</div>

			<div class="mx-auto" style="width: 250px;">
				<div class="input-group input-group-sm mb-3">
					<div class="input-group-prepend">
						<div class="row">

							<span class="input-group-text" id="basic-addon1">ユーザ名 </span>
						</div>
						<input name="name" type="text" class="form-control"
							placeholder="user_name" aria-label="user_name"
							aria-describedby="basic-addon1">
					</div>
				</div>
			</div>

			<div class="mx-auto" style="width: 250px;">
				<div class="input-group input-group-sm mb-3">
					<div class="input-group-prepend">
						<div class="row">

							<span class="input-group-text" id="basic-addon1">生年月日 </span>
						</div>
						<input name="birthDate" type="date" class="form-control"
							placeholder="birthday" aria-label="birthday"
							aria-describedby="basic-addon1">
					</div>
				</div>

				<div class="mx-auto" style="width: 100px;">
					<h5 class="user">
						<input type="submit" value="登録"><br>
					</h5>
				</div>

				<div class="mx-auto" style="width: 500px;">
				<div class="container">
<a href="userListServlet?id=${user.id}" class="text-primary"　>戻る</a>
		</form>
		<!-- /form -->
	</div>
	</div>
	</div>





</body>
</html>