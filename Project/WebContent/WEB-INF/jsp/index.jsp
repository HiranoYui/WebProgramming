<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href=login.css>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<p class="font-italic">
		<div class="mx-auto p-3 mb-2" style="width: 200px;">
			<h3 class="user">
				ログイン画面<br>
			</h3>
		</div>
	</div>
	<c:if test="${errMsg != null}" >
	    <div class="text-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

	<br>
	<form action="LoginServlet" method="post">
		<div class="container">
			<div class="mx-auto" style="width: 250px;">
				<div class="input-group input-group-sm mb-3">
					<div class="input-group-prepend">
						<div class="row">

							<span class="input-group-text" id="basic-addon1">ログインID </span>
						</div>
						<input type="text" name="loginId" class="form-control" placeholder="login_id"
							aria-label="login_id" aria-descｄribedby="basic-addon1">
					</div>
				</div>
			</div>
			<div class="mx-auto" style="width: 250px;">
				<div class="input-group input-group-sm mb-3">
					<div class="input-group-prepend">
						<div class="row">
							<span class="input-group-text" id="basic-addon1">パスワード </span>
						</div>
						<input type="password" class="form-control" placeholder="password"
							aria-label="password" name="password" aria-describedby="basic-addon1">
					</div>
				</div>
			</div>
			<br>
			<div class="mx-auto" style="width: 130px;">
				<h5 class="user">
					<input type="submit" value="ログイン"><br>
				</h5>
			</div>

		</div>

	</form>
</body>
</html>