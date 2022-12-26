<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charSet="utf-8" />
            <meta name="viewport" content="initial-scale=1.0, width=device-width" />
            <meta http-equiv="content-language" content="en" />
            <title>Phim hay mới cập nhật 2022</title>
            <link rel="stylesheet" href="assets/libs/bootstrap-3.3.6/css/bootstrap.min.css">
            <link rel="stylesheet" href="assets/libs/bootstrap3-dialog/css/bootstrap-dialog.min.css">
            <link rel="stylesheet" href="assets/css/movie-icon.css">
            <link rel="stylesheet" href="assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="assets/css/bootstrap.theme.css">
            <link rel="stylesheet" href="assets/css/bootstrap.social.css">
            <link rel="stylesheet" href="assets/css/bootstrap.grid.min.css">
            <link rel="stylesheet" href="assets/libs/mCustomScrollbar/jquery.mCustomScrollbar.min.css">
            <link rel="stylesheet" href="assets/libs/owl.carousel/owl.carousel.min.css">
            <link rel="stylesheet" href="assets/libs/wowslider/wowslider.css">
            <link rel="stylesheet" href="assets/libs/slidebars/slidebars.min.css">
            <link rel="stylesheet" href="assets/css/swiper.css">
            <link rel="stylesheet" href="assets/css/style926f.css">
            <link rel="stylesheet" href="assets/css/responsivepv.css">
            <link rel="stylesheet" href="assets/css/custom926f.css">
            <link rel="stylesheet" href="asserts/font/line-awesome-1.3.0/1.3.0/css/line-awesome.css">

        </head>

        <body>
            <header id="header" class="clearfix hidden-sm hidden-xs">
                <nav class="header-top navbar navbar-custom navbar-fixed-top" role="navigation">
                    <div class="container-fluid clearfix">
                        <div class="d-none d-md-block">
                            <div class="lh-25 font-13 d-flex d-lg-flex flex-nowrap">
                                <div class="right-hel">
                                    <div class="ml-auto align-self-center">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="navbar-table">
                            <div class="navbar-cell tight">
                                <div class="navbar-header">
                                    <a class="navbar-brand" href="home" title="Phim hay mới cập nhật 2022">
                                        VCinema
                                    </a>
                                    <span style="width: 100%;"></span>
                                    <div>
                                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                            data-target="#bs-example-navbar-collapse-1" aria-expanded="true">
                                            <span class="fa fa-bars"></span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div class="navbar-cell stretch navbar-custom-menu">
                                <ul class="nav navbar-nav">
                                    <li class="">
                                        <a href="showintheater" title="Chiếu rạp">Chiếu rạp</a>
                                    </li>
                                    <li class="">
                                        <a href="home" title="Trang chủ">Trang chủ</a>
                                    </li>
                                    <li class="dropdown mega-dropdown has-submenu">
                                        <a href="javascript:;" title="Thể loại">Thể loại <i
                                                class="sp-movie-icon-down"></i></a>
                                        <ul class="dropdown-menu mega-dropdown-menu clearfix with-column-3-200"
                                            role="menu">
                                            <c:forEach var="c" items="${c}">
                                                <li> <a href="categoryfilter?id=${c.id}" title="${c.name}">${c.name}</a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li class="dropdown mega-dropdown has-submenu">
                                        <a href="javascript:;" title="Quốc gia">Quốc gia <i
                                                class="sp-movie-icon-down"></i></a>
                                        <ul class="dropdown-menu mega-dropdown-menu clearfix with-column-3-200"
                                            role="menu">
                                            <c:forEach var="r" items="${r}">
                                                <li> <a href="regionfilter?id=${r.id}" title="${r.name}">${r.name}</a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="navbar-cell stretch">
                                <form method="GET" class="form-search" action="searchfilm">
                                    <div class="input-group mb-sm">
                                        <input type="text" class="form-control input-search desktop" name="search"
                                            placeholder="Tìm kiếm phim...">
                                        <span class="input-group-addon btn-search"> <i class="fa fa-search"></i></span>
                                    </div>
                                </form>
                            </div>
                            <div class="navbar-cell stretch">
                               <div class="profile">
                                    <c:set value="${image.path}" var="link"></c:set>
									<c:if test="${(link == null) || (link == '')}">
										<c:set value="./assets/images/defaultavatar.jpg" var="link"></c:set>
									</c:if>
                                    <img src="${link}" alt="">
                                    <ul class="profile-link">
                                        <li><a href="userprofile"><i class="las la-user-circle icon"></i>
                                                Thông tin</a></li>
                                        <li><a href="filmfollow"><i class="las la-user-cog icon"></i>
                                                Phim theo dõi</a></li>
                                        <li><a href="filmhistory"><i class="las la-history"></i>
                                                Phim đã coi</a></li>
                                        <li><a href="logout"><i class="las la-sign-out-alt icon"></i>
                                                Đăng xuất</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                </nav>
            </header>
            <div class="sb-slidebar sb-left">
                <ul class="nav navbar-nav">
                    <li class="">
                        <a href="showintheater" class="dropdown-toggle" data-toggle="dropdown" title="Chiếu rạp">Chiếu
                            rạp</a>
                    </li>
                    <li class="">
                        <a href="home" class="dropdown-toggle" data-toggle="dropdown" title="Trang chủ">Trang chủ</a>
                    </li>
                    <li class="dropdown mega-dropdown has-submenu">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" title="Thể loại">Thể loại
                            <i class="sp-movie-icon-down"></i></a>
                        <ul class="dropdown-menu" role="menu">
                            <c:forEach var="c" items="${c}">
                                <li> <a href="categoryfilter?id=${c.id}" title="${c.name}">${c.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li class="dropdown mega-dropdown has-submenu">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" title="Quốc gia">Quốc gia
                            <i class="sp-movie-icon-down"></i></a>
                        <ul class="dropdown-menu" role="menu">
                            <c:forEach var="r" items="${r}">
                                <li> <a href="regionfilter?id=${r.id}" title="${r.name}">${r.name}</a> </li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
            <div id="mobile-header" class="visible-sm visible-xs sb-slide">
                <form method="post" class="form-search">
                    <div class="input-group input-group-lg">
                        <input type="text" class="form-control input-search mobile" name="search"
                            placeholder="Tìm kiếm phim..." value="">
                        <span class="input-group-addon btn-search"> <i class="fa fa-search"></i> </span>
                    </div>
                </form>
                <div class="navbar-table">
                    <div class="navbar-cell tight">
                        <div class="sb-toggle-left navbar-left"><i class="fa fa-bars"></i></div>
                        <a class="sb-header-text" href="/" title="Phim hay mới cập nhật 2022">
                            VCinema
                        </a>
                        <div class="open-search navbar-right"><i class="fa fa-search"></i></div>
                        <div class="user-acount mobile">
                            <div id="top-user"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ad-container watch-banner-2">
                <img src="" alt="">
            </div>
            <main class="pb-5">
                <div id="sb-site"
                    style="-webkit-transform: none; -moz-transform: unset; -o-transform: unset; transform: none;">
                    <div class="pd120"></div>
                    <div class="light-overlay"></div>
                    <section id="content">
                        <div class="container-fluid clearfix">
                            <div class="container-wrapper">
                                <ol class="breadcrumb clearfix">
                                    <li>
                                        <a class="home" title="Trang chủ" href="home">
                                            <span class="">
                                                Trang chủ
                                            </span>
                                            <meta itemProp="position" content="1" />
                                        </a>
                                    </li>
                                    <li class="">
                                        <a title=" Tài khoản">
                                            <span class="breadcrumb_last">
                                                Tài khoản
                                            </span>
                                        </a>
                                        <meta itemprop="position" content="2">
                                    </li>
                                    <li class="">
                                        <a title="Thông tin">
                                            <span class="breadcrumb_last">
                                               Phim đang theo dõi
                                            </span>
                                        </a>
                                        <meta itemprop="position" content="3">
                                    </li>
                                </ol>
                            </div>

                            <div class="block">
                                <div class="block-heading with-tabs">
                                    <div class="block-title">
                                        <h2 class="block-title"><i class="las la-user-cog"></i>  Phim đang theo dõi</h2>
                                    </div>
                                </div>
                                <div class="block-content">

                                </div>
                            </div>
                            <!-- MAIN -->
                            <div class="block-content">
                                <div class="block-items row fix-row">
                                    <c:forEach items="${phim}" var="phim">
                                        <c:set var="id" value="${phim.id}"></c:set>
                                        <c:url value="detail" var="detailUrl">
                                            <c:param name="id" value="${id}"></c:param>
                                        </c:url>
                                        <div class="col-xlg-2 col-lg-15 col-md-3 col-sm-4 col-xs-6">
                                            <div class="item">
                                                <a class="inner" href="${detailUrl}" title="${phim.name}">
                                                    <img data-src="${phim.thumb_url}" alt="${phim.name}"
                                                        class="movie-thumb lazyload lazy-loaded"
                                                        src="${phim.thumb_url}">
                                                    <span class="thumb-icon">
                                                        <i class="sp-movie-icon-play"></i>
                                                    </span>
                                                    <span class="overlay"></span>
                                                    <div class="description">
                                                        <h3 class="text-nowrap">${phim.name}</h3>
                                                        <div class="meta clearfix">
                                                            <span class="pull-left">${phim.publish_year}</span>
                                                            <span class="pull-right">${phim.episode_current}</span>
                                                        </div>
                                                    </div>
                                                    <span class="badge">${phim.quality} ${phim.language}</span>
                                                </a>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>

                        </div>
                    </section>

                </div>
            </main>


            <div id="footer" class="full">
                <div id="top_footer" class="full">
                    <div class="container-fluid clearfix">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="nav-footer">
                                    <ul id="menuFooter" class="menu-footer">
                                        <li> <a title="Link" href="Link.html">Link</a> </li>
                                        <li> <a title="Link" href="Link.html">Link</a> </li>
                                        <li> <a title="Link" href="Link.html">Link</a> </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="contact_footer col-xs-12 col-sm-12 col-md-2">
                                <p>Phim mới cập nhật liên tục, Xem phim online chất lượng cao, phim thuyết minh, phim
                                    Vietsub.
                                    Cập nhật các bộ phim bom tấn HOT liên tục hàng ngày 24/7</p>
                            </div>
                            <div class="col-xs-12 col-sm-2 col-md-2 link-footer">
                                <p class="title_footer" style="margin-top: 20px;"> Liên hệ </p>
                                <span>email@</span>
                            </div>
                            <div class="col-xs-12 col-sm-2 col-md-2 link-footer">
                                <p class="title_footer" style="margin-top: 20px;">Thể loại nổi bật</p>
                                <ul>
                                    <li> <a title="Phim hành động" href="/">Phim hành động</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-xs-12 col-sm-2 col-md-2 link-footer">
                                <p class="title_footer" style="margin-top: 20px;">Quốc gia nổi bật</p>
                                <ul>
                                    <li> <a title="Mỹ" href="/">Mỹ</a> </li>
                                </ul>
                            </div>
                            <div class="col-sx-12 col-sm-2 col-md-2 link-footer">
                                <p class="title_footer" style="margin-top: 20px;"> Phim Hot </p>
                                <ul>
                                    <li> <a title="Bác Sĩ Xứ Lạ" href="/">Bác Sĩ Xứ Lạ</a> </li>
                                </ul>
                            </div>
                            <div class="col-sx-12 col-sm-2 col-md-2 link-footer">
                                <p class="title_footer" style="margin-top: 20px;"> TextLink </p>
                                <ul>
                                    <li> <a title="TextLink" href="/">TextLink</a> </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="catfish" style="width: 100%;position:fixed;bottom:0;left:0;z-index:222" class="mp-adz">
                <div style="margin:0 auto;text-align: center;overflow: visible;" id="container-ads">
                    <img src="" alt="">
                </div>
            </div>
            <script type="text/javascript">
                const profile = document.querySelector(".profile");
                const imgProfile = profile.querySelector("img");
                const dropdownProfile = profile.querySelector(".profile-link");

                imgProfile.addEventListener("click", function () {
                    dropdownProfile.classList.toggle("show");
                });

                window.addEventListener("click", function (e) {
                    if (e.target !== imgProfile) {
                        if (e.target != dropdownProfile) {
                            if (dropdownProfile.classList.contains("show")) {
                                dropdownProfile.classList.remove("show");
                            }
                        }
                    }
                });

            </script>
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/core.min.js"></script>
            <script src="assets/js/toastr.min.js"></script>
            <script src="assets/js/function.js"></script>

        </body>

        </html>