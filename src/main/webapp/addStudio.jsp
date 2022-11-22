<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="asserts/font/line-awesome-1.3.0/1.3.0/css/line-awesome.css">
<link rel="stylesheet" href="">
<link rel="stylesheet" href="asserts/css/style.css">
<link rel="stylesheet" href="asserts/css/profile.css">
<title>Add studio</title>
</head>
<body>

	</section>
	<!--SIDE BAR-->
	<section id="sidebar">
		<a href="#" class="brand"><img src="./asserts/img/Logo.png" alt="">VPMovie</a>
		<ul class="side-menu">
			<li><a href="./Dashboard.html"><i class="las la-home icon"></i>Dashboard</a></li>
			<li class="divider">Phim</li>
			<li>
			<li><a href="./movies.html"><i
					class="las la-play-circle icon"></i>Danh sách phim</a></li>
			<li><a href="#"><i class="las la-list icon"></i></i>Phân loại <i
					class="las la-angle-left icon-right icon"></i></a>
				<ul class="side-dropdown">
					<li><a href="catalog"><i class="las la-pager"></i> Danh
							sách</a></li>
					<li><a href="category"><i class="las la-at icon"></i> Thể
							loại</a></li>
					<li><a href="tag"><i class="las la-link icon"></i> Tags</a></li>
					<li><a href="region"><i class="las la-globe icon"></i> Khu
							vực</a></li>
					<li><a href="actor"><i class="lab la-gratipay icon"></i>
							Diễn viên</a></li>
					<li><a href="director"><i
							class="lab la-odnoklassniki-square icon"></i> Đạo diễn</a></li>
					<li><a href="studio"><i class="lab la-connectdevelop icon"></i>
							Studio</a></li>
				</ul></li>
			<li><a href="#"><i class="las la-info-circle icon"></i></i>Phim
					lỗi</a></li>

			</li>

			<li class="divider">Tùy chỉnh</li>
			<li>
			<li><a href="#"><i class="las la-paint-brush icon"></i>Giao
					diện <i class="las la-angle-left icon-right icon"></i></a>
				<ul class="side-dropdown">
					<li><a href="#">Chủ đề</a></li>
					<li><a href="#">Menu</a></li>
				</ul></li>
			<li><a href="#"><i class="las la-cog icon"></i></i>Cài đặt <i
					class="las la-angle-left icon-right icon"></i></a>
				<ul class="side-dropdown">
					<li><a href="#">General</a></li>
					<li><a href="#">Seo</a></li>
					<li><a href="#">Jwplayer</a></li>
					<li><a href="#">Khác</a></li>
				</ul></li>
			<li><a href="#"><i class="las la-map icon"></i></i>Sitemap</a></li>

			</li>

			<li class="divider">Mở rộng</li>
			<li>
			<li><a href="#"><i class="las la-play-circle icon"></i>Crawler</a></li>
			</li>

			<li class="divider">Administration</li>
			<li>
			<li><a href="#"><i class="las la-users icon"></i>Authentication</a></li>
			</li>
		</ul>

	</section>
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
				<h1 class="title">Studios</h1>
				<h4>
					Add studio. <a href="">Back to all studios</a>
				</h4>
			</div>
			<ul class="breadcrumbs">
				<li><a href="#">Home</a></li>
				<li class="divider">/</li>
				<li><a href="#">Studios</a></li>
				<li class="divider">/</li>
				<li><a href="#" class="active">Add</a></li>
			</ul>
		</main>

		<!-- MAIN -->
		<form action="addStudio" method="post">
			<div class="card">
				<div class="card-heading">
					<div>
						<label for="">Tên</label> <input type="text" name="name"
							class="mt-8">
					</div>
					<div class="mt-15">
						<label for="">Đường dẫn tĩnh</label> <input type="text"
							name="slug" class="mt-8">
					</div>
					<div class="mt-15">
						<label for="">Ảnh</label> <input type="text" name="thumb_url"
							class="mt-8">
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