<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link rel="stylesheet" href="asserts/font/line-awesome-1.3.0/1.3.0/css/line-awesome.css">
			<link rel="stylesheet" href="asserts/css/ckeditor.css">
			<link rel="stylesheet" href="asserts/css/style.css">
			<link rel="stylesheet" href="asserts/css/add.css">
			<link rel="stylesheet" href="./asserts/css/alert.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
			<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
			<script src="https://cdn.ckeditor.com/ckeditor5/35.3.0/classic/ckeditor.js"></script>
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
				integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
				crossorigin="anonymous" referrerpolicy="no-referrer" />
			<title>Movies</title>
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
						<h1 class="title">Movies</h1>
						<h4>
							Add movie. <a href="">Back to all movies</a>
						</h4>
					</div>
					<ul class="breadcrumbs">
						<li><a href="#">Home</a></li>
						<li class="divider">/</li>
						<li><a href="#">Movies</a></li>
						<li class="divider">/</li>
						<li><a href="#" class="active">Add</a></li>

					</ul>

				</main>
				<!-- MAIN -->
				<c:if test="${requestScope.msg == 'errorValue'}">
					<div class="alert alert-danger show	">
						<span class="icon"> <i class="fa fa-times"></i>
						</span>
						<div class="text">
							<strong>Lỗi</strong>
							<p>Vui lòng nhập đầy đủ thông tin và đúng định dạng</p>
						</div>
						<div class="close">
							<i class="fa fa-close"></i>
						</div>
					</div>
				</c:if>
				<!-- DEFAULT BOX -->
				<div class="nav-tab">
					<div class="tab">
						<button class="tablinks" onclick="openCity(event, 'thong-tin-phim')" id="defaultOpen">Thông tin
							phim</button>
						<button class="tablinks" onclick="openCity(event, 'phan-loai')">Phân
							loại</button>
						<button class="tablinks" onclick="openCity(event, 'danh-sach-tap-phim')">Danh sách
							tập phim</button>
						<button class="tablinks" onclick="openCity(event, 'khac')">Khác</button>
					</div>
					<form action="addMovie" method="post">
						<div id="thong-tin-phim" class="tabcontent">
							<div class="film-info">
								<div class="form-group mt-15">
									<div class="form-item">
										<label for="">Tên phim</label> <input type="text" name="name"
											placeholder=" Tên">
									</div>
									<div class="form-item">
										<label for="">Tên gốc</label> <input type="text" name="origin_name">
									</div>
								</div>
								<div class="mt-15">
									<label for="">Đường dẫn tĩnh</label> <input type="text" name="slug">
								</div>
								<div class="mt-15">
									<label for="">Ảnh thumb</label>
									<div class="fl-0">
										<input type="text" name="thumb-url" id="thumb-url">
										<input type="file" name="thumb-btn" id="thumb-btn" style="display:none;" />
										<label class="btn btn-info reset-lb" for="thumb-btn">Browse</label>
									</div>
								</div>
								<div class="mt-15">
									<label for="">Ảnh poster</label>
									<div class="fl-0">
										<input type="text" name="poster-url" id="poster-url">
										<input type="file" name="poster-btn" id="poster-btn" style="display:none;" />
										<label class="btn btn-info reset-lb" for="poster-btn">Browse</label>
									</div>
								</div>
								<div class="mt-15">
									<label for="">Nội dung</label>
									<textarea name="content" id="editor" placeholder="Nội dung...">
                        			</textarea>
								</div>
								<div class="mt-15">
									<label for="">Thông báo / ghi chú</label> <input type="text" name="notify">
								</div>
								<div class="mt-15">
									<label for="">Lịch chiếu phim</label> <input type="text" name="showtimes">
								</div>
								<div class="mt-15">
									<label for="">Trailer Youtube URL</label> <input type="text" name="trailer_url">
								</div>
								<div class="form-group mt-15">
									<div class="form-item">
										<label for="">Thời lượng phim</label> <input type="text" name="episode_time">
									</div>
									<div class="form-item">
										<label for="">Tập phim hiện tại</label> <input type="text"
											name="episode_current">
									</div>
									<div class="form-item">
										<label for="">Tổng số tập phim</label> <input type="text" name="episode_total">
									</div>
								</div>
								<div class="form-group mt-15">
									<div class="form-item">
										<label for="">Ngôn ngữ</label> <input type="text" name="language"
											placeholder=" Ngôn ngữ">
									</div>
									<div class="form-item">
										<label for="">Chất lượng</label> <input type="text" name="quality" value="HD">
									</div>
									<div class="form-item">
										<label for="">Năm xuất bản</label> <input type="text" name="publish_year">
									</div>
								</div>
							</div>
						</div>

						<div id="phan-loai" class="tabcontent">
							<div class="film-type">
								<div class="mt-15">
									<label for="">Định dạng *</label>
									<c:forEach items="${requestScope.type}" var="t">
										<div class="form-check mt-8">
											<input type="radio" value="${t.id}" name="type"> <label>${t.name}</label>
										</div>
									</c:forEach>
								</div>
								<div class="mt-15">
									<label for="">Tình trạng *</label>
									<c:forEach items="${requestScope.status}" var="s">
										<div class="form-check mt-8">
											<input type="radio" value="${s.id}" name="status"> <label>${s.name }</label>
										</div>
									</c:forEach>
								</div>
								<div class="mt-15">
									<label for="">Thể loại</label>
									<div class="form-check-row">
										<c:forEach items="${requestScope.c}" var="r">
											<div class="form-check mt-8">
												<input type="checkbox" value="${r.id}" name="category">
												<label>${r.name}</label>
											</div>
										</c:forEach>

									</div>
								</div>
								<div class="mt-15">
									<label for="">Khu vực</label>
									<div class="form-check-row">
										<c:forEach items="${requestScope.r}" var="r">
											<div class="form-check mt-8">
												<input type="checkbox" value="${r.id}" name="region">
												<label>${r.name}</label>
											</div>
										</c:forEach>

									</div>
								</div>
								<div class="mt-15">
									<label>Đạo diễn</label> <select class="js-multiple" multiple="multiple"
										style="width: 100%" name="director">
										<c:forEach items="${requestScope.d}" var="d">
											<option value="${d.id}">${d.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="mt-15">
									<label>Diễn viên</label> <select class="js-multiple" name="actor"
										multiple="multiple" style="width: 100%">
										<c:forEach items="${requestScope.a}" var="d">
											<option value="${d.id}">${d.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="mt-15">
									<label>Tags</label> <select class="js-multiple" name="tag" multiple="multiple"
										style="width: 100%">
										<c:forEach items="${requestScope.t}" var="d">
											<option value="${d.id}">${d.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="mt-15">
									<label>Studio</label> <select class="js-multiple" name="studio" multiple="multiple"
										style="width: 100%">
										<c:forEach items="${requestScope.s}" var="d">
											<option value="${d.id}">${d.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>

						<div id="danh-sach-tap-phim" class="tabcontent">
							<div>
								<div class="table">
									<table class="crud-table " id="episode_table">
										<thead>
											<tr>
												<th>Name</th>
												<th>Slug</th>
												<th>Link</th>
												<th></th>
											</tr>
										</thead>
										<tbody id="table-body">
											<tr>
												<td><input type="text" placeholder=" tập 1" value="tập 1"
														name="episode_name"></td>
												<td><input type="text" placeholder=" tap-1" value="tap-1"
														name="episode_slug"></td>
												<td><input type="text" name="link"></td>
												<td>
													<button class="lead" onclick="remove_tr(this)">
														<a href="#" class="btn btn-primary">Delete</a>
													</button>
												</td>

											</tr>
										</tbody>
									</table>
									<div class="table-btn mt-15">
										<button class="lead" onclick="create_tr()">
											<a href="#" class="btn btn-warning"><i class="las la-plus"></i>
												Thêm tập mới</a>
										</button>
									</div>
								</div>
							</div>
						</div>

						<div id="khac" class="tabcontent">
							<div>
								<div class="mt-15">
									<div class="form-check mt-8">
										<input type="checkbox" name="is_shown_in_theater"> <label>Phim
											chiếu rạp</label>
									</div>
									<div class="form-check mt-8">
										<input type="checkbox" name="is_copyright"> <label>Có
											bản quyền phim</label>
									</div>
									<div class="form-check mt-8">
										<input type="checkbox" name="is_sensitive_content"> <label>Cảnh
											báo nội dung người lớn</label>
									</div>
									<div class="form-check mt-8">
										<input type="checkbox" value="is_recommended"> <label>Đề
											cử</label>
									</div>
								</div>
							</div>

						</div>

						<div class="form-btn">
							<button class="lead btn btn-teal" type="submit">
								<i class="las la-save"></i>Save and back
							</button>
							<button class="lead" type="reset">
								<a href="movie" class="btn btn-gray">Cancel</a>
							</button>
						</div>
					</form>
					<!-- DEFAULT BOX -->
			</section>
			<!-- CONTENT -->
			<script>
				$(document).ready(function () {
					$('.js-multiple').select2();
				});
			</script>

			<script>
				function openCity(evt, cityName) {
					var i, tabcontent, tablinks;
					tabcontent = document.getElementsByClassName("tabcontent");
					for (i = 0; i < tabcontent.length; i++) {
						tabcontent[i].style.display = "none";
					}
					tablinks = document.getElementsByClassName("tablinks");
					for (i = 0; i < tablinks.length; i++) {
						tablinks[i].className = tablinks[i].className.replace(" active", "");
					}
					document.getElementById(cityName).style.display = "block";
					evt.currentTarget.className += " active";
				}

				// Get the element with id="defaultOpen" and click on it
				document.getElementById("defaultOpen").click();
			</script>
			<script>
				ClassicEditor
					.create(document.querySelector('#editor'))
					.catch(error => {
						console.error(error);
					});
			</script>
			<script src="asserts/js/script.js"></script>
			<script>
				function create_tr() {
					let table_body = document.getElementById("episode_table");
					let first_tr = table_body.children[1];
					let tr_clone = first_tr.cloneNode(true);
					table_body.append(tr_clone);
				}
				function remove_tr(This) {
					This.closest('tr').remove();
				}
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

			<script type="text/javascript">
				const actualBtn = document.getElementById('thumb-btn');
				const fileChosen = document.getElementById('thumb-url');
				actualBtn.addEventListener('change', function () {
					fileChosen.value = this.files[0].name
				})
			</script>

			<script type="text/javascript">
				const actualBtn2 = document.getElementById('poster-btn');
				const fileChosen2 = document.getElementById('poster-url');
				actualBtn2.addEventListener('change', function () {
					fileChosen2.value = this.files[0].name
				})
			</script>
		</body>

		</html>