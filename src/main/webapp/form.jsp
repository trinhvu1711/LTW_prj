<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<title>Signup_Signin</title>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>Sign in|Sign up</title>
			<!-- font awesome icons -->
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
				integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
				crossorigin="anonymous" referrerpolicy="no-referrer" />
			<!-- css stylesheet -->
			<link rel="stylesheet" href="./asserts/css/form.css">
			<link rel="stylesheet" href="./asserts/css/alert.css">
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

			<div class="container" id="container">
				<div class="form-container sign-up-container">
					<form action="signup" method="post">
						<h1>Create Account</h1>
						<div class="social-container">
							<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a href="#"
								class="social"><i class="fab fa-google-plus-g"></i></a> <a href="#" class="social"><i
									class="fab fa-linkedin-in"></i></a>
						</div>
						<span>or use your email for registration</span>
						<div class="infield">
							<input type="text" placeholder="Name" name="name" /> <label></label>
						</div>
						<div class="infield">
							<input type="email" placeholder="Email" name="user" /> <label></label>
						</div>
						<div class="infield">
							<input type="password" placeholder="Password" name="pass" /> <label></label>
						</div>
						<button type="submit">Sign Up</button>

					</form>
				</div>
				<div class="form-container sign-in-container">
					<form action="login" method="post">
						<h1>Sign in</h1>
						<div class="social-container">
							<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a href="#"
								class="social"><i class="fab fa-google-plus-g"></i></a> <a href="#" class="social"><i
									class="fab fa-linkedin-in"></i></a>
						</div>
						<span>or use your account</span>
						<div class="infield">
							<input type="email" placeholder="Email" name="email" /> <label></label>
						</div>
						<div class="infield">
							<input type="password" placeholder="Password" name="password" /> <label></label>
						</div>
						<div class="remember">
							<input type="checkbox" name="remember" value="rem">Remember me
						</div>
						<a href="#" class="forgot">Forgot your password?</a>
						<button type="submit">Sign In</button>
					</form>
				</div>
				<div class="overlay-container" id="overlayCon">
					<div class="overlay">
						<div class="overlay-panel overlay-left">
							<h1>Welcome Back!</h1>
							<p>To keep connected with us please login with your personal
								info</p>
							<button>Sign In</button>
						</div>
						<div class="overlay-panel overlay-right">
							<h1>Hello, Friend!</h1>
							<p>Enter your personal details and start journey with us</p>
							<button>Sign Up</button>
						</div>
					</div>
					<button id="overlayBtn"></button>
				</div>
			</div>

			<footer> </footer>

			<!-- js code -->
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