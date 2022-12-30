<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link rel="stylesheet" href="asserts/font/line-awesome-1.3.0/1.3.0/css/line-awesome.css">
			<link rel="stylesheet" href="asserts/css/profile.css">
			<link rel="stylesheet" href="asserts/css/style.css">
			<title>Episode Error</title>
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
						<h1 class="title">Episode Error</h1>
					</div>
					<ul class="breadcrumbs">
						<li><a href="#">Home</a></li>
						<li class="divider">/</li>
						<li><a href="#" class="active">Episode </a></li>

					</ul>
				</main>
				<div class="container-fluid">
					<div>
						<div class="table class-table">
							<table class="crud-table">
								<thead>
									<tr>
										<th>Tên</th>
										<th>Tập</th>
										<th>Link</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${requestScope.list}" var="c">
										<tr>
											<td class="p-12"><span>${c.name_movie}</span></td>
											<td class="p-12"><span>${c.name_episode}</span></td>
											<td class="p-12"><span>${c.link}</span></td>
											<td class="p-12">
												<div class="actions">
													<p class="lead">
														<a href="view?id=${c.id_movie}&tap=${c.tap}"
															class="btn btn-primary"><i class="las la-eye"></i> Open
															it</a>
													</p>
													<p class="lead">
														<a href="editmovieerror?id_episode=${c.id_episode}"
															class="btn btn-primary"><i class="las la-edit"></i> Edit</a>
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