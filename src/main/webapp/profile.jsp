<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="asserts/font/line-awesome-1.3.0/1.3.0/css/line-awesome.css">
<link rel="stylesheet" href="">
<link rel="stylesheet" href="asserts/css/style.css">
<link rel="stylesheet" href="asserts/css/profile.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="./asserts/css/alert.css">
<title>Profile</title>
</head>

<body>

	</section>
	<!--SIDE BAR-->
	<section id="sidebar">
		<a href="#" class="brand"><img src="./asserts/img/Logo.png" alt="">VPMovie</a>
		<ul class="side-menu">
			<li><a href="dashboard"><i class="las la-home icon"></i>Dashboard</a></li>
			<li class="divider">Phim</li>
			<li>
			<li><a href="movie"><i class="las la-play-circle icon"></i>Danh
					sách phim</a></li>
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
					<li><a href="profile"><i class="las la-user-cog icon"></i>
							Settings</a></li>
					<li><a href="logout"><i class="las la-sign-out-alt icon"></i>
							Logout</a></li>
				</ul>
			</div>
		</nav>
		<!-- NAVBAR -->

		<!-- MAIN -->
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
		<c:if test="${msg == 'notDuplicatecpass'}">
			<div class="alert alert-danger show	">
				<span class="icon"> <i class="fa fa-times"></i>
				</span>
				<div class="text">
					<strong>Lỗi</strong>
					<p>Mật khẩu xác nhận lại không khớp mới mật khẩu mới</p>

				</div>
				<div class="close">
					<i class="fa fa-close"></i>
				</div>
			</div>
		</c:if>
		<c:if test="${msg == 'opassFail'}">
			<div class="alert alert-danger show	">
				<span class="icon"> <i class="fa fa-times"></i>
				</span>
				<div class="text">
					<strong>Lỗi</strong>
					<p>Mật khẩu cũ không đúng</p>

				</div>
				<div class="close">
					<i class="fa fa-close"></i>
				</div>
			</div>
		</c:if>
		<c:if test="${msg == 'duplicateopass'}">
			<div class="alert alert-danger show	">
				<span class="icon"> <i class="fa fa-times"></i>
				</span>
				<div class="text">
					<strong>Lỗi</strong>
					<p>Mật khẩu mới trùng với mật khẩu cũ</p>

				</div>
				<div class="close">
					<i class="fa fa-close"></i>
				</div>
			</div>
		</c:if>
		<c:if test="${msg == 'success'}">
			<div class="alert alert-success show">
				<span class="icon"> <i class="fa fa-times"></i>
				</span>
				<div class="text">
					<strong>Thành công</strong>
					<p>Đổi mật khẩu thành công</p>

				</div>
				<div class="close">
					<i class="fa fa-close"></i>
				</div>
			</div>
		</c:if>

		<main>
			<h1 class="title">My Account</h1>
			<ul class="breadcrumbs">
				<li><a href="#">Home</a></li>
				<li class="divider">/</li>
				<li><a href="#" class="active">My Account</a></li>
			</ul>
		</main>

		<!-- MAIN -->
		<form action="updateProfile" method="post">
			<div class="card">
				<div class="card-heading">Update Account Info</div>
				<div class="card-body">
					<input type="hidden" name="username" class="mt-8"
						value="${account.username}"> <input type="hidden"
						name="pass" class="mt-8" value="${account.password}"> <input
						type="hidden" name="pass" class="mt-8" value="${account.name}">
					<div class="card-item">
						<label for="">Name</label> <input type="text" name="nname"
							value="${account.name}" class="mt-8">
					</div>
					<div class="card-item">
						<label for="">Email</label> <input type="text" name="nusername"
							value="${account.username}" class="mt-8">
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

		<form action="changePasswordProfile" method="post">

			<div class="card">
				<div class="card-heading">Change Password</div>
				<div class="card-body">
					<input type="hidden" name="username" class="mt-8"
						value="${account.username}"> <input type="hidden"
						name="pass" class="mt-8" value="${account.password}">
					<div class="card-item">
						<label for="">Old password</label> <input type="text" name="opass"
							class="mt-8">
					</div>
					<div class="card-item">
						<label for="">New password</label> <input type="text" name="npass"
							class="mt-8">
					</div>
					<div class="card-item">
						<label for="">Confirm password</label> <input type="text"
							name="rpass" class="mt-8">
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