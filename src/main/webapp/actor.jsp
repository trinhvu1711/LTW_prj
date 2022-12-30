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
			<title>Actor</title>
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
						<h1 class="title">Actors</h1>
					</div>
					<ul class="breadcrumbs">
						<li><a href="#">Home</a></li>
						<li class="divider">/</li>
						<li><a href="#" class="active">Actors</a></li>

					</ul>


				</main>
				<div class="container-fluid">
					<div class="row function-bar">
						<p class="lead">
							<a href="addActor.jsp" class="btn btn-primary"><i class="las la-plus"></i> Add actor</a>
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
										<c:url var="deleteUrl" value="deleteActor">
											<c:param name="id" value="${c.id}"></c:param>
										</c:url>
										<c:url var="editUrl" value="editActor">
											<c:param name="id" value="${c.id}"></c:param>
										</c:url>
										<tr>
											<td class="p-12"><span>${c.name}</span></td>
											<td class="p-12"><span>${c.slug}</span></td>
											<td class="p-12">
												<div class="actions">
													<p class="lead">
														<a href="#" class="btn btn-primary"><i class="las la-eye"></i>
															Preview</a>
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