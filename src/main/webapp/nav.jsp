<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Dashboard</title>
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link rel="stylesheet" href="asserts/font/line-awesome-1.3.0/1.3.0/css/line-awesome.css">
			<link rel="stylesheet" href="">
			<link rel="stylesheet" href="asserts/css/style.css">
		</head>

		<body>
			<!--SIDE BAR-->
			<section id="sidebar">
				<a href="#" class="brand"><img src="./asserts/img/Logo.png" alt="">VPMovie</a>
				<ul class="side-menu">
					<li><a href="dashboard" class="active"><i class="las la-home icon"></i>Dashboard</a></li>
					<li class="divider">Phim</li>
					<li>
					<li><a href="movie"><i class="las la-play-circle icon"></i>Danh sách phim</a></li>
					<li><a href="#"><i class="las la-list icon"></i></i>Phân loại <i
								class="las la-angle-left icon-right icon"></i></a>
						<ul class="side-dropdown">
							<li><a href="catalog"><i class="las la-pager"></i> Danh sách</a></li>
							<li><a href="category"><i class="las la-at icon"></i> Thể loại</a></li>
							<li><a href="tag"><i class="las la-link icon"></i> Tags</a></li>
							<li><a href="region"><i class="las la-globe icon"></i> Khu vực</a></li>
							<li><a href="actor"><i class="lab la-gratipay icon"></i> Diễn
									viên</a></li>
							<li><a href="director"><i class="lab la-odnoklassniki-square icon"></i> Đạo diễn</a></li>
							<li><a href="studio"><i class="lab la-connectdevelop icon"></i>
									Studio</a></li>
						</ul>
					</li>
					<li><a href="movieerror"><i class="las la-info-circle icon"></i></i>Phim
							lỗi</a></li>

					</li>
					<li class="divider">Mở rộng</li>
					<li>
					<li><a href="statistical"><i class="las la-play-circle icon"></i>Thống kê</a></li>
					</li>

					<li class="divider">Administration</li>
					<li>
					<li><a href="administration"><i class="las la-users icon"></i>Authentication</a></li>
					</li>
				</ul>

			</section>
			<!--SIDE BAR-->
			<!-- CONTENT -->

			<script src="asserts/js/script.js"></script>
		</body>

		</html>