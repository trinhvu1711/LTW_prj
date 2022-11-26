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
<link rel="stylesheet" href="">
<link rel="stylesheet" href="asserts/css/style.css">
<title>Movies</title>
<title>Insert title here</title>
</head>
<body>
	</section>
	<!--SIDE BAR-->
	<section id="sidebar">
		<a href="movie" class="brand"><img src="./asserts/img/Logo.png"
			alt="">VPMovie</a>
		<ul class="side-menu">
			<li><a href="dashboard" class=""><i class="las la-home icon"></i>Dashboard</a></li>
			<li class="divider">Phim</li>
			<li>
			<li><a href="movie" class="active"><i
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
			<h1 class="title">Movies</h1>
			<ul class="breadcrumbs">
				<li><a href="#">Home</a></li>
				<li class="divider">/</li>
				<li><a href="#">Movie</a></li>
				<li class="divider">/</li>
				<li><a href="#" class="active">List</a></li>

			</ul>

		</main>
		<!-- MAIN -->

		<!-- DEFAULT BOX -->
		<div class="container-fluid">
			<div class="row function-bar">
				<p class="lead">
					<a href="addMovie" class="btn btn-primary"><i
						class="las la-plus"></i> Add movie</a>
				</p>

			</div>
			<div class="row filters">
				<i class="las la-filter"></i>
				<div class="bp-filter">
					<ul class="filter-navbar">
						<li><select class="select" name="status" id="status">
								<option disabled selected>Tình trạng</option>
								<option value="Trailer">TRAILER</option>
								<option value="Đang chiếu">ĐANG CHIẾU</option>
								<option value="Hoàn thành">HOÀN THÀNH</option>
						</select></li>
						<li><select class="select" name="type" id="type">
								<option disabled selected>Định dạng</option>
								<option value="Phim lẻ">PHIM LẺ</option>
								<option value="Phim bộ">PHIM BỘ</option>

						</select></li>
						<li><select class="select" name="category" id="category">
								<option disabled selected>Thể loại</option>
								<option value="Tình cảm">TÌNH CẢM</option>
								<option value="Chính kịch">CHÍNH KỊCH</option>
								<option value="Hành động">HÀNH ĐỘNG</option>
								<option value="Viễn tưởng">VIỄN TƯỞNG</option>
								<option value="Khoa học">KHOA HỌC</option>
						</select></li>
						<li><select class="select" name="region" id="region">
								<option disabled selected>Quốc gia</option>
								<option value="Thổ Nhĩ Kỳ">THỔ NHĨ KỲ</option>
								<option value="Trung Quốc">TRUNG QUỐC</option>
								<option value="Nhật Bản">NHẬT BẢN</option>
								<option value="Hàn Quốc">HÀN QUỐC</option>
						</select></li>
					</ul>
				</div>
			</div>
			<div class>
				<div class="table">
					<table class="crud-table">
						<thead>
							<tr>
								<th class="p-12">Thông tin</th>
								<th>Thumbnail</th>
								<th>Thể loại</th>
								<th>Khu vực</th>
								<th>Actions</th>

							</tr>
						</thead>

						<tbody>
							<c:forEach items="${list}" var="m">
								<c:set var="id" value="${m.id}"></c:set>
								<c:url var="deleteUrl" value="deleteMovie">
									<c:param name="id" value="${m.id}"></c:param>
								</c:url>
								<c:url var="editUrl" value="editMovie">
									<c:param name="id" value="${m.id}"></c:param>
								</c:url>
								<tr>
									<td class="td-info">
										<div>
											<div class="text-primary">
												${m.name} <span class="text-success">
													[${m.publish_year}]</span>
											</div>
											<div class="text-muted">
												<small>(${m.origin_name})<span class="text-danger">[${m.episode_current}]</span></small>
											</div>

											<c:if test="${m.type.name == 'Phim lẻ'}">
												<c:set var="type" value="Phim lẻ"></c:set>
												<c:set var="type_class" value="bg-secondary"></c:set>
											</c:if>
											<c:if test="${m.type.name == 'Phim bộ'}">
												<c:set var="type" value="Phim bộ"></c:set>
												<c:set var="type_class" value="bg-primary"></c:set>
											</c:if>
											<c:if test="${m.status.name == 'Sắp chiếu'}">
												<c:set var="status" value="Trailer"></c:set>
												<c:set var="status_class" value="bg-warning"></c:set>
											</c:if>
											<c:if test="${m.status.name == 'Đang chiếu'}">
												<c:set var="status" value="Đang chiếu"></c:set>
												<c:set var="status_class" value="bg-info"></c:set>
											</c:if>
											<c:if test="${m.status.name == 'Hoàn thành'}">
												<c:set var="status" value="Hoàn thành"></c:set>
												<c:set var="status_class" value="bg-success"></c:set>
											</c:if>

											<div class="badge ${type_class} fw-normal">${m.type.name}</div>
											<div class="badge ${status_class} fw-normal">${m.status.name}</div>

										</div>
									</td>
									<td class="p-12"><span> <a href="#"> <img
												src="${m.thumb_url}" alt="">
										</a>

									</span></td>
									<td class="p-12"><span> <c:forEach
												items="${m.getMovieCategories()}" var="c">
												${c.name}
											</c:forEach>
									</span></td>
									<td class="p-12"><c:forEach items="${m.getMovieRegions()}"
											var="c">
											${c.name}
										</c:forEach></td>
									<td class="p-12">
										<div class="actions">
											<p class="lead">
												<a href="#" class="btn btn-primary"><i
													class="las la-eye"></i> View</a>
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
			<div class="page-nums row">
				<div class="table-length ">
					<ul class="filter-navbar">
						<select class="select" name="table-length" id="table-length">
							<option value="10">10</option>
							<option value="25">25</option>
							<option value="50">50</option>
							<option value="100">100</option>
							<option value="-1">All</option>
						</select> entries per page
					</ul>
				</div>
				<div class="table-num-page"></div>
			</div>
		</div>
		<!-- DEFAULT BOX -->
	</section>
	<!-- CONTENT -->

	<script src="asserts/js/script.js"></script>
</body>
</html>