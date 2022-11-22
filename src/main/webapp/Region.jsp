<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="asserts/font/line-awesome-1.3.0/1.3.0/css/line-awesome.css">
<link rel="stylesheet" href="asserts/css/profile.css">
<link rel="stylesheet" href="asserts/css/style.css">
<title>Region</title>
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
			<li><a href="#"><i class="las la-list icon"></i>Phân loại <i
					class="las la-angle-left icon-right icon"></i></a>
				<ul class="side-dropdown">
					<li><a href="catalog"><i class="las la-pager"></i> Danh sách</a></li>
					<li><a href="category"><i class="las la-at icon"></i> Thể loại</a></li>
					<li><a href="tag"><i class="las la-link icon"></i> Tags</a></li>
					<li><a href="region"><i class="las la-globe icon"></i> Khu vực</a></li>
					<li><a href="actor"><i class="lab la-gratipay icon"></i> Diễn
							viên</a></li>
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
				<h1 class="title">Regions</h1>
			</div>
			<ul class="breadcrumbs">
				<li><a href="#">Home</a></li>
				<li class="divider">/</li>
				<li><a href="#" class="active">Regions</a></li>

			</ul>


		</main>
		<div class="container-fluid">
			<div class="row function-bar">
				<p class="lead">
					<a href="addRegion.jsp" class="btn btn-primary"><i
						class="las la-plus"></i> Add Region</a>
				</p>

			</div>
			<div>
				<div class="table class-table">
					<table class="crud-table">
						<thead>
							<tr>
								<th>Tên</th>
								<th>Đường dẫn tĩnh</th>
								<th>Actions</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.list}" var="c">
								<c:url var="deleteUrl" value="deleteRegion">
									<c:param name="id" value="${c.id}"></c:param>
								</c:url>
								<c:url var="editUrl" value="editRegion">
									<c:param name="id" value="${c.id}"></c:param>
								</c:url>
								<tr>
									<td class="p-12"><span>${c.name}</span></td>
									<td class="p-12"><span>${c.slug}</span></td>
									<td class="p-12">
										<div class="actions">
											<p class="lead">
												<a href="#" class="btn btn-primary"><i
													class="las la-eye"></i> Preview</a>
											</p>
											<p class="lead">
												<a href="${editUrl}" class="btn btn-primary"><i
													class="las la-edit"></i> Edit</a>
											</p>
											<p class="lead">
												<a href="${deleteUrl}" class="btn btn-primary"><i
													class="las la-trash-alt"></i> Delete</a>
											</p>

										</div>
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- MAIN -->

	</section>

	<!-- CONTENT -->
	<script src="asserts/js/script.js"></script>
</body>
</html>
v
