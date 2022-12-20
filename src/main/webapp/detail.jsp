<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charSet="utf-8" />
            <meta name="viewport" content="initial-scale=1.0, width=device-width" />
            <meta http-equiv="content-language" content="en" />
            <meta name="robots" content="index,follow" />
            <meta name="revisit-after" content="1 days" />
            <meta name="ROBOTS" content="index,follow" />
            <meta name="googlebot" content="index,follow" />
            <meta name="BingBOT" content="index,follow" />
            <meta name="yahooBOT" content="index,follow" />
            <meta name="slurp" content="index,follow" />
            <meta name="msnbot" content="index,follow" />
            <meta name="csrf-token" content="v2BTcT1i3uwxuW3hpQ2eEPao6UiSyCyzp9eyflO0">
            <meta property="fb:app_id" content="" />
            <link rel="shortcut icon" href="" type="image/png" />
            <title>${movie.name}</title>
            <meta name="description"
                content="Lần Đầu Yêu Anh là một bộ phim về tình yêu tuổi trẻ của đạo diễn Thẩm Thấm Nguyên với sự tham gia của Điền Hi Vi và Vương Tinh Việt.Bộ phim kể về Lư V...">
            <meta name="keywords" content="Lần Đầu Yêu Anh, Special: First Love">
            <link rel="canonical" href="https://default.ophimcms.com/phim/lan-dau-yeu-anh" />
            <link rel="prev" href="https://default.ophimcms.com" />
            <meta property="og:site_name" content="Ophim.TV" />
            <meta property="og:title" content="${movie.name}" />
            <meta property="og:type" content="movie" />
            <meta property="og:locale" content="vi-VN" />
            <meta property="og:updated_time" content="2022-12-17 15:50:26" />
            <meta property="og:url" content="https://default.ophimcms.com/phim/lan-dau-yeu-anh" />
            <meta property="og:description"
                content="Lần Đầu Yêu Anh là một bộ phim về tình yêu tuổi trẻ của đạo diễn Thẩm Thấm Nguyên với sự tham gia của Điền Hi Vi và Vương Tinh Việt.Bộ phim kể về Lư V..." />
            <meta property="og:image"
                content="https://default.ophimcms.com/storage/images/lan-dau-yeu-anh/lan-dau-yeu-anh-thumb.jpg" />
            <meta property="og:image"
                content="https://default.ophimcms.com/storage/images/lan-dau-yeu-anh/lan-dau-yeu-anh-poster.jpg" />

            <meta name="twitter:site" content="Ophim.TV" />
            <meta name="twitter:title" content="${movie.name}" />
            <meta name="twitter:card" content="movie" />
            <meta name="twitter:image"
                content="https://default.ophimcms.com/storage/images/lan-dau-yeu-anh/lan-dau-yeu-anh-thumb.jpg" />
            <meta name="twitter:description"
                content="Lần Đầu Yêu Anh là một bộ phim về tình yêu tuổi trẻ của đạo diễn Thẩm Thấm Nguyên với sự tham gia của Điền Hi Vi và Vương Tinh Việt.Bộ phim kể về Lư V..." />
            <meta name="twitter:url" content="https://default.ophimcms.com/phim/lan-dau-yeu-anh" />
            <script
                type="application/ld+json">{"@context":"https://schema.org","name":"Phim hay mới cập nhật 2022","description":"Ophim.TV","image":null}</script>
            <script
                type="application/ld+json">{"@context":"https://schema.org","@type":"movie","name":"${movie.name}","description":"Lần Đầu Yêu Anh là một bộ phim về tình yêu tuổi trẻ của đạo diễn Thẩm Thấm Nguyên với sự tham gia của Điền Hi Vi và Vương Tinh Việt.Bộ phim kể về Lư V...","url":"https://default.ophimcms.com/phim/lan-dau-yeu-anh","image":["https://default.ophimcms.com/storage/images/lan-dau-yeu-anh/lan-dau-yeu-anh-thumb.jpg","https://default.ophimcms.com/storage/images/lan-dau-yeu-anh/lan-dau-yeu-anh-poster.jpg"],"dateCreated":"2022-12-17T15:50:26.000000Z","director":"Shen Qin Yuan"}</script>

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
            <link rel="stylesheet" href="assets/css/style926f.css?ver=2.45">
            <link rel="stylesheet" href="assets/css/responsivepv.css">
            <link rel="stylesheet" href="assets/css/custom926f.css?ver=2.45">
			<link rel="stylesheet" href="asserts/font/line-awesome-1.3.0/1.3.0/css/line-awesome.css">

        </head>

        <body>
            <c:url value="view" var="viewUrl">
                <c:param name="id" value="${movie.id}"></c:param>
            </c:url>
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
                                    <a class="navbar-brand" href="/" title="${movie.name}">
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
                                        <a href="/danh-sach/phim-chieu-rap" title="Chiếu rạp">Chiếu rạp</a>
                                    </li>
                                    <li class="">
                                        <a href="/" title="Trang chủ">Trang chủ</a>
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
                                            placeholder="Tìm kiếm phim..." value="">
                                        <span class="input-group-addon btn-search"> <i class="fa fa-search"></i></span>
                                    </div>
                                </form>
                            </div>
                            <div class="navbar-cell stretch">
                                <div class="profile">
                                    <img src="./asserts/img/admin.png" alt="">
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
                        <a href="/" class="dropdown-toggle" data-toggle="dropdown" title="Trang chủ">Trang chủ</a>
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
                                <li> <a href="regionfilter?id=${r.id}" title="${r.name}">${r.name}</a>
                                </li>
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
                        <a class="sb-header-text" href="/" title="${movie.name}">
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
                                <ol class="breadcrumb clearfix" itemScope itemType="https://schema.org/BreadcrumbList">
                                    <li itemProp="itemListElement" itemScope itemType="http://schema.org/ListItem">
                                        <a class="" itemProp="item" title="Xem phim" href="/">
                                            <span class="" itemProp="name">
                                                Xem phim
                                            </span>
                                            <meta itemProp="position" content="1" />
                                        </a>
                                    </li>
                                    <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                                        <a class="" itemprop="item" href="/danh-sach/phim-bo" title="Phim bộ">
                                            <span itemprop="name">
                                                Phim bộ
                                            </span>
                                        </a>
                                        <meta itemprop="position" content="2">
                                    </li>

                                    <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                                        <a class="" itemprop="item"
                                            href="https://default.ophimcms.com/quoc-gia/trung-quoc" title="Trung Quốc">
                                            <span itemprop="name">
                                                Trung Quốc
                                            </span>
                                        </a>
                                        <meta itemprop="position" content="3">
                                    </li>
                                    <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                                        <a class="" itemprop="item" href="https://default.ophimcms.com/the-loai/tam-ly"
                                            title="Tâm Lý">
                                            <span itemprop="name">
                                                Tâm Lý
                                            </span>
                                        </a>
                                        <meta itemprop="position" content="3">
                                    </li>
                                    <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                                        <a class="" itemprop="item"
                                            href="https://default.ophimcms.com/the-loai/hoc-duong" title="Học Đường">
                                            <span itemprop="name">
                                                Học Đường
                                            </span>
                                        </a>
                                        <meta itemprop="position" content="3">
                                    </li>
                                    <li class="" itemprop="itemListElement" itemscope=""
                                        itemtype="http://schema.org/ListItem">
                                        <a itemprop="item" href="https://default.ophimcms.com/phim/lan-dau-yeu-anh"
                                            title="${movie.name}">
                                            <span class="breadcrumb_last" itemprop="name">
                                                ${movie.name}
                                            </span>
                                        </a>
                                        <meta itemprop="position" content="4">
                                    </li>
                                </ol>
                            </div>

                            <div class="column-with-300">
                                <div class="movie-banner">
                                    <div class="movie-banner-src lazyload"
                                        style="background-image:url('${movie.thumb_url}')">
                                    </div>
                                    <div class="icon-play">
                                        <a href="" title="${movie.name}"></a>
                                    </div>
                                </div>
                                <div class="movie-info clearfix">
                                    <div id="before-watching"></div>
                                    <div class="column-300 pull-left">
                                        <div class="thumbnail mb-none">
                                            <img class="info-poster-img" src="${movie.thumb_url}" alt="${movie.name}" />
                                        </div>
                                        <div class="button-play">
                                            <a class="btn btn-blue btn-rounded" title="Trailer ${movie.name}"
                                                href="javascript:trailer()"> <i class="sp-movie-icon-camera"></i>
                                                Trailer </a>

                                            <a class="btn btn-red btn-rounded" title="${movie.name}" href="${viewUrl}">
                                                <i class="sp-movie-icon-camera"></i> Xem Phim </a>
                                            <c:if test="${check}">
                                            	 <a class="btn btn-green btn-rounded" title="Theo dõi ${movie.name}" href="follow?id=${movie.id}">
                                                <i class="sp-movie-icon-camera"></i> Theo dõi</a>
                                            </c:if>
                                           <c:if test="${!check}">
                                            	 <a class="btn btn-pink btn-rounded" title="Theo dõi ${movie.name}" href="unfollow?id=${movie.id}">
                                                <i class="sp-movie-icon-camera"></i> Bỏ theo dõi</a>
                                            </c:if>
                                        </div>
                                        <div class="block mt-xl">
                                            <div class="weight-normal font-24">
                                                <i class="sp-movie-icon-film"></i> Thông tin
                                            </div>
                                            <div class="block-content movie-info-sidebar bin-bg">
                                                <ul class="list-style-none list-inline">
                                                    <li class="common-list">
                                                        <span> Trạng Thái:</span>
                                                        <font color="red">${movie.episode_current}</font>
                                                    </li>
                                                    <li class="common-list">
                                                        <span> Tổng số tập:</span>
                                                        ${movie.episode_total}
                                                    </li>
                                                    <li class="common-list">
                                                        <span> Thể loại:</span>
                                                        <c:forEach var="category" items="${category}" varStatus="loop">
                                                            <a href="categoryfilter?id=${category.id}"
                                                                title="${category.name}"><span>${category.name}</span></a>
                                                            <c:if test="${!loop.last}">,</c:if>
                                                        </c:forEach>

                                                    </li>
                                                    <li class="common-list">
                                                        <span> Quốc gia:</span>
                                                        <c:forEach var="region" items="${region}" varStatus="loop">
                                                            <a href="regionfilter?id=${region.id}"
                                                                title="${region.name}"><span>${region.name}</span></a>
                                                            <c:if test="${!loop.last}">,</c:if>
                                                        </c:forEach>
                                                    </li>
                                                    <li class="common-list">
                                                        <span> Năm phát hành: </span> ${movie.publish_year}
                                                    </li>
                                                    <li class="common-list">
                                                        <span> Đạo diễn:</span>
                                                        <span itemprop="director">
                                                            <c:forEach var="directors" items="${directors}"
                                                                varStatus="loop">
                                                                <a class="director" href="#"
                                                                    title="${directors.name}"><span>${directors.name}</span></a>
                                                                <c:if test="${!loop.last}">,</c:if>
                                                            </c:forEach>

                                                        </span>
                                                    </li>
                                                    <li class="common-list">
                                                        <span> Thời lượng:</span> ${movie.episode_time}
                                                    </li>
                                                    <li class="common-list">
                                                        <span> Lượt xem:</span> ${movie.view_total}
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="ads ads-info-left"></div>
                                    </div>
                                    <div class="column-with-300 pull-right">
                                        <div class="movie-info-top">
                                            <h2 class="movie-title">${movie.name}</h2>
                                            <div class="movie-subtitle">${movie.origin_name}</div>
                                            <div class="movie-rating">
                                                <div id="movies-rating-star"></div>
                                                (0.0
                                                sao
                                                /
                                                0 đánh giá)
                                                <span class="hint" id="movies-rating-msg"></span>
                                                <div class="rate-star">
                                                    <i class="sp-movie-icon-star-line"></i>
                                                    <span class="avg_vote">0.0</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="hidden-download">
                                            <div class="block mt-xl">
                                                <div class="block-heading">
                                                    <h2 class="block-title weight-normal text-blue">
                                                        <i class="sp-movie-icon-book"></i>
                                                        <span class="text_dv">Giới thiệu</span>
                                                    </h2>
                                                </div>
                                                <div class="block-content bin-bg">
                                                    <div class="page-content mt">
                                                        <div class="content_film">
                                                            ${movie.content}
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="block mt-xl">
                                                <div class="block-heading">
                                                    <h2 class="block-title weight-normal">
                                                        <i class="sp-movie-icon-user-review"></i>
                                                        <span class="text_dv">Diễn viên</span>
                                                    </h2>
                                                </div>
                                                <div class="block-content list-actor bin-bg">
                                                    <div class="items clearfix">
                                                        <c:forEach var="actor" items="${actors}">
                                                            <div class="item">
                                                                <div class="item-inner">
                                                                    <a href="#" class="actor-ava"
                                                                        style="background-image: url('assets/images/dienvien.png')"
                                                                        title="${actor.name}"></a>
                                                                    <h3 class="actor-info">
                                                                        <a href=""
                                                                            title="${actor.name}">${actor.name}</a>
                                                                    </h3>
                                                                </div>
                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </div>
                                            <div id="trailer" class="block mt-xl">
                                                <div class="block-heading">
                                                    <h2 class="block-title weight-normal"><i
                                                            class="sp-movie-icon-videocam text-danger"></i><span
                                                            class="text_dv">Trailers &amp; Videos</span></h2>
                                                </div>
                                                <div class="block-content bin-bg">
                                                    <div class="row fix-row row-trailer">
                                                        <div class="col-md-12">
                                                            <div class="trailer">
                                                                <div class="trailer-image-wrap">
                                                                    <img class="lazyload lazy-loaded"
                                                                        data-src="${movie.trailer_url}" alt="trailers"
                                                                        src="${movie.trailer_url}">
                                                                    <div class="icon-play"> <a
                                                                            href="javascript:void(0);" rel="nofollow"
                                                                            data-id="P2Dqud3ZZQU"> <i
                                                                                class="sp-movie-icon-play"></i>
                                                                        </a> </div>
                                                                </div>
                                                                <div class="trailer-info">
                                                                    <div class="trailer-info-block">
                                                                        <h3>${m.name}</h3>
                                                                        <p class="genry">
                                                                            <a href="https://default.ophimcms.com/the-loai/tam-ly"
                                                                                title="Tâm Lý"><span>Tâm Lý</span></a>,
                                                                            <a href="https://default.ophimcms.com/the-loai/hoc-duong"
                                                                                title="Học Đường"><span>Học
                                                                                    Đường</span></a>
                                                                        </p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div id="fb-comment-watching">
                                                <div class="block mt-xl">
                                                    <div class="block-heading">
                                                        <div class="block-title weight-normal text-pink">
                                                            <i class="sp-movie-icon-user-review"></i>
                                                            <span class="text_dv">Bình luận</span>
                                                        </div>
                                                    </div>
                                                    <div class="block-content pt bin-bg">
                                                        <div class="fb-comments"
                                                            data-href="https://default.ophimcms.com/phim/lan-dau-yeu-anh"
                                                            data-width="100%" data-num-posts="5"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="block mt-xl">
                                                <div class="block-heading">
                                                    <h3 class="block-title weight-normal text-pink">
                                                        <i class="sp-movie-icon-user-review text-pink"></i>
                                                        <span class="text_dv">Phim liên quan</span>
                                                    </h3>
                                                </div>

                                                <div class="block-content pt">
                                                    <div id="recoment-films" class="block-items row fix-row">


                                                        <c:forEach items="${recommend}" var="phim">
                                                            <c:set var="id" value="${phim.id}"></c:set>
                                                            <c:url value="detail" var="detailUrl">
                                                                <c:param name="id" value="${id}"></c:param>
                                                            </c:url>
                                                            <div class="col-xlg-2 col-lg-15 col-md-3 col-sm-4 col-xs-6">
                                                                <div class="item">
                                                                    <a class="inner" href="${detailUrl}"
                                                                        title="${phim.name}">
                                                                        <img data-src="${phim.thumb_url}"
                                                                            alt="${phim.name}"
                                                                            class="movie-thumb lazyload lazy-loaded"
                                                                            src="${phim.thumb_url}">
                                                                        <span class="thumb-icon">
                                                                            <i class="sp-movie-icon-play"></i>
                                                                        </span>
                                                                        <span class="overlay"></span>
                                                                        <div class="description">
                                                                            <h3 class="text-nowrap">${phim.name}</h3>
                                                                            <div class="meta clearfix">
                                                                                <span
                                                                                    class="pull-left">${phim.publish_year}</span>
                                                                                <span
                                                                                    class="pull-right">${phim.episode_current}</span>
                                                                            </div>
                                                                        </div>
                                                                        <span class="badge">${phim.quality}
                                                                            ${phim.language}</span>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="right-sidebar column-300">
                                <div class="block" id="sidebar">
                                    <div class="block-heading" style="border: none;">
                                        <div class="block-title">
                                            <i class="fa fa-star"></i> Top phim lẻ
                                        </div>
                                    </div>
                                    <div class="box-asian-tabs tab-remote-sidebar">
                                        <ul class="nav nav-tabs nav-justified"></ul>
                                        <div class="tab-content p-none block-single list_data_tab_pb"
                                            style="position: static; zoom: 1;">
                                            <div class="content-tab-sidebar" id="owl-slide">
                                                <ul class="list-group list-group-movie clearfix">
                                                    <c:forEach items="${topphimle}" var="phim">
                                                        <c:set var="id" value="${phim.id}"></c:set>
                                                        <c:url value="detail" var="detailUrl">
                                                            <c:param name="id" value="${id}"></c:param>
                                                        </c:url>
                                                        <li class="list-group-item clearfix">
                                                            <div class="thumbnail">
                                                                <a href="${phim.thumb_url}" title="${phim.name}">
                                                                    <img data-src="${phim.thumb_url}" class="lazyload"
                                                                        alt="${phim.name}" />
                                                                </a>
                                                            </div>
                                                            <div class="meta-item">
                                                                <h3 class="name-1">
                                                                    <a href="${detailUrl}"
                                                                        title="${phim.name}">${phim.name}</a>
                                                                </h3>
                                                                <h4 class="name-2">${phim.origin_name}
                                                                    (${phim.publish_year})</h4>
                                                                <p>${phim.episode_current}</p>
                                                                <p>
                                                                    <i class="fa fa-video-camera"></i>
                                                                    ${phim.view_month}
                                                                </p>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="block" id="sidebar">
                                    <div class="block-heading" style="border: none;">
                                        <div class="block-title">
                                            <i class="fa fa-star"></i> Top phim bộ
                                        </div>
                                    </div>
                                    <div class="box-asian-tabs tab-remote-sidebar">
                                        <ul class="nav nav-tabs nav-justified"></ul>
                                        <div class="tab-content p-none block-single list_data_tab_pb"
                                            style="position: static; zoom: 1;">
                                            <div class="content-tab-sidebar" id="owl-slide">
                                                <ul class="list-group list-group-movie clearfix">
                                                    <c:forEach items="${topphimbo}" var="phim">
                                                        <c:set var="id" value="${phim.id}"></c:set>
                                                        <c:url value="detail" var="detailUrl">
                                                            <c:param name="id" value="${id}"></c:param>
                                                        </c:url>
                                                        <li class="list-group-item clearfix">
                                                            <div class="thumbnail">
                                                                <a href="${phim.thumb_url}" title="${phim.name}">
                                                                    <img data-src="${phim.thumb_url}" class="lazyload"
                                                                        alt="${phim.name}" />
                                                                </a>
                                                            </div>
                                                            <div class="meta-item">
                                                                <h3 class="name-1">
                                                                    <a href="${detailUrl}"
                                                                        title="${phim.name}">${phim.name}</a>
                                                                </h3>
                                                                <h4 class="name-2">${phim.origin_name}
                                                                    (${phim.publish_year})</h4>
                                                                <p>${phim.episode_current}</p>
                                                                <p>
                                                                    <i class="fa fa-video-camera"></i>
                                                                    ${phim.view_month}
                                                                </p>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                    
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
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

            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/core.min.js"></script>
            <script src="assets/js/toastr.min.js"></script>
            <script src="assets/js/function.js"></script>



            <script src="assets/libs/jquery-raty/jquery.raty.js"></script>
            <link href="assets/libs/jquery-raty/jquery.raty.css" rel="stylesheet" type="text/css" />

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

            <script>
                var rated = false;
                $('#movies-rating-star').raty({
                    score: 0.0,
                    number: 10,
                    numberMax: 10,
                    hints: ['quá tệ', 'tệ', 'không hay', 'không hay lắm', 'bình thường', 'xem được', 'có vẻ hay', 'hay',
                        'rất hay', 'siêu phẩm'
                    ],
                    starOff: 'assets/libs/jquery-raty/images/star-off.png',
                    starOn: 'assets/libs/jquery-raty/images/star-on.png',
                    starHalf: 'assets/libs/jquery-raty/images/star-half.png',
                    click: function (score, evt) {
                        if (rated) return
                        fetch("https://default.ophimcms.com/phim/lan-dau-yeu-anh/rate", {
                            method: 'POST',
                            headers: {
                                "Content-Type": "application/json",
                                'X-CSRF-TOKEN': document.querySelector(
                                    'meta[name="csrf-token"]')
                                    .getAttribute(
                                        'content')
                            },
                            body: JSON.stringify({
                                rating: score
                            })
                        });
                        rated = true;
                        $('#movies-rating-star').data('raty').readOnly(true);
                        $('#movies-rating-msg').html(`Bạn đã đánh giá ${score} sao cho phim này!`);
                    }
                });
            </script>



        </body>

        </html>