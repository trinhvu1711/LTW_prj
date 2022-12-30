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
<link rel="stylesheet" href="./asserts/css/alert.css">
<title>Category</title>
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
				<h1 class="title">Categories</h1>
			</div>
			<ul class="breadcrumbs">
				<li><a href="#">Home</a></li>
				<li class="divider">/</li>
				<li><a href="addCategory.jsp" class="active">Categories</a></li>

			</ul>


		</main>
		<div class="container-fluid">
			<div class="row function-bar">
				<p class="lead">
					<a href="addadministration.jsp" class="btn btn-primary"><i
						class="las la-plus"></i> Add Member</a>
				</p>

			</div>
			<div>
				<div class="table class-table">
					<table class="crud-table">
						<thead>
							<tr>
								<th>Tên</th>
								<th>Email</th>
								<th>Quyền</th>
								<th>Actioins</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="c">
								<c:url var="deleteUrl" value="deleteadministration">
									<c:param name="username" value="${c.username}"></c:param>
								</c:url>
								<c:url var="editUrl" value="editadministration">
									<c:param name="username" value="${c.username}"></c:param>
									<c:param name="password" value="${c.password}"></c:param>
								</c:url>
								<tr>
									<td class="p-12"><span>${c.name}</span></td>
									<td class="p-12"><span>${c.username}</span></td>
									<c:if test="${c.role == 1}">
										<c:set value="Admin" var="role"></c:set>
									</c:if>
									<c:if test="${c.role == 2}">
										<c:set value="Member" var="role"></c:set>
									</c:if>
									<td class="p-12"><span>${role}</span></td>
									<td class="p-12">
										<div class="actions">
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
	<script>
        const container = document.getElementById('container');
        const overlayCon = document.getElementById('overlayCon');
        const overlayBtn = document.getElementById('overlayBtn');
        overlayBtn.addEventListener('click', () => {
            container.classList.toggle('right-panel-active');
            overlayBtn.classList.remove('btnScaled');
            window.requestAnimationFrame(() => {
                overlayBtn.classList.add('btnScaled');
            })
        })
        
        
    </script>
	<script type="text/javascript">
	let alert_close_icons = document.querySelectorAll('.alert>.close');
	if(alert_close_icons)
	{
	  alert_close_icons.forEach((alert_close_icon)=>{
	    alert_close_icon.addEventListener('click', function()
	    {
	      this.closest('.alert').classList.add('close');
	      
	      this.closest('.alert').addEventListener('transitionend', function(event){
	        if(event.propertyName=='transform')
	        {
	          this.remove();
	        }
	      });
	    });
	  });
	}
    </script>
</body>
</html>