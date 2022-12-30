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
		<title>Add director</title>
	</head>

	<body>

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
					<h1 class="title">Director</h1>
					<h4>
						Add director. <a href="">Back to all directors</a>
					</h4>
				</div>
				<ul class="breadcrumbs">
					<li><a href="#">Home</a></li>
					<li class="divider">/</li>
					<li><a href="#">Directors</a></li>
					<li class="divider">/</li>
					<li><a href="#" class="active">Add</a></li>
				</ul>
			</main>

			<!-- MAIN -->
			<form action="addDirector" method="post">
				<div class="card">
					<div class="card-heading">
						<div>
							<label for="">Tên</label> <input type="text" name="name" class="mt-8">
						</div>
						<div class="mt-15">
							<label for="">Đường dẫn tĩnh</label> <input type="text" name="slug" class="mt-8">
						</div>
						<div class="mt-15">
							<label for="">Ảnh</label> <input type="text" name="thumb_url" class="mt-8">
						</div>
						<div class="mt-15">
							<label for="">Giới tính</label>
							<select name="is_male" class="form-option">
								<option value="0">Female</option>
								<option value="1">Male</option>
							</select>
						</div>
					</div>
					<div class="card-footer">
						<button class="lead" type="submit">

							<div class="btn btn-teal">
								<i class="las la-save"></i> Save
							</div>
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
	</body>

	</html>