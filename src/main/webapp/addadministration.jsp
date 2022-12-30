<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="asserts/font/line-awesome-1.3.0/1.3.0/css/line-awesome.css">
		<link rel="stylesheet" href="">
		<link rel="stylesheet" href="asserts/css/style.css">
		<link rel="stylesheet" href="asserts/css/profile.css">
		<link rel="stylesheet" href="./asserts/css/alert.css">
		<title>Add User</title>
	</head>

	<body>
		<c:if test="${msg == 'nullError'}">
			<div class="alert alert-danger show	">
				<span class="icon"> <i class="fa fa-times"></i>
				</span>
				<div class="text">
					<strong>Lỗi</strong>
					<p>Thông tin nhập chưa đầy đủ hoặc sai định dạng</p>

				</div>
				<div class="close">
					<i class="fa fa-close"></i>
				</div>
			</div>
		</c:if>
		<c:if test="${requestScope.msg == 'signupError'}">
			<div class="alert alert-danger show	">
				<span class="icon"> <i class="fa fa-times"></i>
				</span>
				<div class="text">
					<strong>Lỗi</strong>
					<p>Tài khoản đã tồn tài</p>

				</div>
				<div class="close">
					<i class="fa fa-close"></i>
				</div>
			</div>
		</c:if>

		<c:if test="${requestScope.msg == 'signinError'}">
			<div class="alert alert-danger show	">
				<span class="icon"> <i class="fa fa-times"></i>
				</span>
				<div class="text">
					<strong>Lỗi</strong>
					<p>Tài khỏan hoặc mật khẩu không chính xác!</p>
				</div>
				<div class="close">
					<i class="fa fa-close"></i>
				</div>
			</div>
		</c:if>

		<c:if test="${requestScope.msg == 'signupSuccess'}">
			<div class="alert alert-success show">
				<span class="icon"> <i class="fa fa-times"></i>
				</span>
				<div class="text">
					<strong>Thành công</strong>
					<p>Tài khỏan đã được tạo thành công!</p>
				</div>
				<div class="close">
					<i class="fa fa-close"></i>
				</div>
			</div>
		</c:if>

		<!--SIDE BAR-->
		<jsp:include page="nav.jsp"></jsp:include>
		<!--SIDE BAR-->

		<!-- CONTENT -->
		<section id="content">
			<!-- NAVBAR -->
			<nav>
				<i class="las la-bars toggle-sidebar"></i> <span class="divider"></span>
				<div class="profile">
					<img src="./asserts/img/admin.png" alt="">
					<ul class="profile-link">
						<li><a href="#"><i class="las la-user-circle icon"></i>
								Profile</a></li>
						<li><a href="#"><i class="las la-user-cog icon"></i>
								Settings</a></li>
						<li><a href="#"><i class="las la-sign-out-alt icon"></i>
								Logout</a></li>
					</ul>
				</div>
			</nav>
			<!-- NAVBAR -->

			<!-- MAIN -->
			<main>
				<div class="heading">
					<h1 class="title">Add ADMINISTRATION </h1>
					<h4>
						Add ADMINISTRATION. <a href="">ADMINISTRATION</a>
					</h4>
				</div>
				<ul class="breadcrumbs">
					<li><a href="#">Home</a></li>
					<li class="divider">/</li>
					<li><a href="#">Categories</a></li>
					<li class="divider">/</li>
					<li><a href="#" class="active">Add</a></li>
				</ul>
			</main>

			<!-- MAIN -->
			<form action="addadministration" method="post">
				<div class="card">
					<div class="card-heading">
						<div>
							<label for="">Tên</label> <input type="text" name="name" class="mt-8">
						</div>
						<div class="mt-15">
							<label for="">Email</label> <input type="text" name="email" class="mt-8">
						</div>
						<div class="mt-15">
							<label for="">Mật khẩu</label> <input type="password" name="password" class="mt-8">
						</div>
						<div class="mt-15">
							<label for="">Xác nhận mật khẩu</label> <input type="password" name="repassword"
								class="mt-8">
						</div>
						<div class="mt-15">
							<input type="checkbox" name="role" class="mt-8"><label for=""> Admin</label>
						</div>
					</div>
					<div class="card-footer">
						<button class="lead" type="submit">

							<div class="btn btn-teal"><i class="las la-save"></i> Save</div>
						</button>
						<button class="lead" type="reset">
							<a href="#" class="btn btn-gray">Cancel</a>
						</button>
					</div>
				</div>
			</form>

		</section>

		<!-- CONTENT -->
		<script src="asserts/js/script.js"></script>
		<script type="text/javascript">
			let alert_close_icons = document.querySelectorAll('.alert>.close');
			if (alert_close_icons) {
				alert_close_icons.forEach((alert_close_icon) => {
					alert_close_icon.addEventListener('click', function () {
						this.closest('.alert').classList.add('close');

						this.closest('.alert').addEventListener('transitionend', function (event) {
							if (event.propertyName == 'transform') {
								this.remove();
							}
						});
					});
				});
			}
		</script>
	</body>

	</html>