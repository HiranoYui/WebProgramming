<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page import="model.Users"%>
<%Users loginUser=(Users)session.getAttribute("loginUser"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ管理</title>
<link rel="stylesheet" href=userdata.css>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="p-3 mb-2 text-white text-right">
		<ul class="nav navbar-nav navbar-right">
            <li class="navbar-text">${userInfo.name} さん </li>
  			<li class="dropdown">
  			  <a href="LogoutServlet" class="text-danger">ログアウト</a>
		</div>
		<div class="mx-auto" style="width: 200px;">
			<h3 class="user">
				ユーザ一覧<br>
			</h3>
		</div>


		<div class="text-right">
			<a href="RegisterUser" class="text-primary">新規登録</a>
		</div>

<form action="userListServlet" method="post">


		<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
				<div class="mx-auto" style="width: 250px;">
					<span class="input-group-text" id="basic-addon1">ログインID</span>
				</div>
				<input type="text" class="form-control" placeholder="login_id"
					aria-label="login_id" aria-describedby="basic-addon1" name=loginId>
			</div>


			<div class="input-group input-group-sm mb-3">
				<div class="input-group-prepend">
					<div class="mx-auto" style="width: 250px;">
						<span class="input-group-text" id="basic-addon1">ユーザ名</span>
					</div>
					<input type="text" class="form-control" placeholder="Username"
						aria-label="Username" aria-describedby="basic-addon1" name=name>
				</div>

				<div class="input-group input-group-sm mb-3">
					<div class="input-group-prepend">
						<div class="mx-auto" style="width: 250px;">
							<span class="input-group-text" id="basic-addon1">生年月日</span>
						</div>
						<input name=birthDateS type="date" class="form-control" placeholder="Username"
							aria-label="Username" aria-describedby="basic-addon1">～ <input name=birthDateE
							type="date" class="form-control" placeholder="Username"
							aria-label="Username" aria-describedby="basic-addon1">
					</div>
				</div>

				<input type="submit" value="検索" style="text-align: right;"><br>
				</p>

			</div>
		</div>

</form>


		<div class="table-responsive">
			<table class="table table-striped">
				<thead>

					<tr>

						<th scope="col">ログインID</th>
						<th scope="col">ユーザ名</th>
						<th scope="col">生年月日</th>
						<th scope="col"></th>
					</tr>

				</thead>
				<tbody>
					<c:forEach var="user" items="${userList}">
						<tr>
							<td>${user.loginId}</td>
							<td>${user.name}</td>
							<td>${user.birthDate}</td>


							<td><a class="btn btn-primary"
								href="userDetailServlet?id=${user.id}">詳細</a>
								<c:if test="${userInfo.loginId=='admin' || user.loginId==userInfo.loginId}" ><a
								class="btn btn-success" href="userEditServlet?id=${user.id}">更新</a>
								</c:if>
								<c:if test="${userInfo.loginId=='admin'}" >
								<a class="btn btn-danger" href="userDeleteServlet?id=${user.id}">削除</a>

								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
</body>
</html>