<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charSet="utf-8" />
        <meta name="viewport" content="initial-scale=1.0, width=device-width" />
        <meta http-equiv="content-language" content="en" />
        
        <title>Xem phim ${movie.name} Vietsub HD</title>
     
        <link rel="canonical" href="view?id=${movie.id}" />
      

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
    <link rel="stylesheet" href="assets/css/comment.css">
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
                                <a class="navbar-brand" href="home" title="Xem phim ${movie.name} ${movie.episode_current} Vietsub HD">
                                    VPhim
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
                                    <a href="/" title="Trang chủ">Trang chủ</a>
                                </li>
                                <li class="dropdown mega-dropdown has-submenu">
                                    <a href="javascript:;" title="Thể loại">Thể loại <i
                                            class="sp-movie-icon-down"></i></a>
                                    <ul class="dropdown-menu mega-dropdown-menu clearfix with-column-3-200" role="menu">
                                        <c:forEach var="c" items="${c}">
                                                <li> <a href="categoryfilter?id=${c.id}" title="${c.name}">${c.name}</a>
                                                </li>
                                            </c:forEach>
                                    </ul>
                                </li>
                                <li class="dropdown mega-dropdown has-submenu">
                                    <a href="javascript:;" title="Quốc gia">Quốc gia <i
                                            class="sp-movie-icon-down"></i></a>
                                    <ul class="dropdown-menu mega-dropdown-menu clearfix with-column-3-200" role="menu">
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
                </div>
            </nav>
        </header>
        <div class="sb-slidebar sb-left">
            <ul class="nav navbar-nav">
                <li class="">
                    <a href="showintheater" class="dropdown-toggle" data-toggle="dropdown"
                        title="Chiếu rạp">Chiếu rạp</a>
                </li>
                <li class="">
                    <a href="/" class="dropdown-toggle" data-toggle="dropdown" title="Trang chủ">Trang chủ</a>
                </li>
                <li class="dropdown mega-dropdown has-submenu">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" title="Thể loại">Thể loại <i
                            class="sp-movie-icon-down"></i></a>
                    <ul class="dropdown-menu" role="menu">
                        <c:forEach var="c" items="${c}">
                                <li> <a href="categoryfilter?id=${c.id}" title="${c.name}">${c.name}</a> </li>
                            </c:forEach>
                    </ul>
                </li>
                <li class="dropdown mega-dropdown has-submenu">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" title="Quốc gia">Quốc gia <i
                            class="sp-movie-icon-down"></i></a>
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
                    <a class="sb-header-text" href="home" title="Xem phim ${movie.name} tập 01 Vietsub HD">
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
                                    <a class="" itemprop="item" href="https://default.ophimcms.com/quoc-gia/trung-quoc"
                                        title="Trung Quốc">
                                        <span itemprop="name">
                                            Trung Quốc
                                        </span>
                                    </a>
                                    <meta itemprop="position" content="3">
                                </li>
                                <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                                    <a class="" itemprop="item" href="https://default.ophimcms.com/the-loai/vo-thuat"
                                        title="Võ Thuật">
                                        <span itemprop="name">
                                            Võ Thuật
                                        </span>
                                    </a>
                                    <meta itemprop="position" content="3">
                                </li>
                                <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                                    <a class="" itemprop="item" href="https://default.ophimcms.com/the-loai/phieu-luu"
                                        title="Phiêu Lưu">
                                        <span itemprop="name">
                                            Phiêu Lưu
                                        </span>
                                    </a>
                                    <meta itemprop="position" content="3">
                                </li>
                                <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                                    <a class="" itemprop="item" href="https://default.ophimcms.com/the-loai/hoat-hinh"
                                        title="Hoạt Hình">
                                        <span itemprop="name">
                                            Hoạt Hình
                                        </span>
                                    </a>
                                    <meta itemprop="position" content="3">
                                </li>
                                <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                                    <a itemprop="item" href="https://default.ophimcms.com/phim/than-an-vuong-toa"
                                        title=" ${movie.name}">
                                        <span itemprop="name">
                                            ${movie.name}
                                        </span>
                                    </a>
                                    <meta itemprop="position" content="4">
                                </li>
                                <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                                    <a itemprop="item"
                                        href="${episode.link}"
                                        title="Tập 01">
                                        <span class="breadcrumb_last" itemprop="name">
                                            ${episode.name}
                                        </span>
                                    </a>
                                    <meta itemprop="position" content="5">
                                </li>
                            </ol>
                        </div>
                        <div id="zoomPlayer"></div>
                        <div class="column-with-300">
                            <div id="normalPlayer">
                                <div id="pl-content">
                                    <div class="player-wrapper">
                                        <div class="player-container">
                                            <div class="embed-responsive embed-responsive-16by9 sixteen-nine">
                                                <div class="embed-responsive-item">
                                                    <div id="media-player-box" style="height: 100%;">
                                                    </div>
                                                    <div class="box_loading_player" style="display: block;"></div>
                                                </div>
                                            </div>
                                            <c:set value="${tap}" var="tap"></c:set>
                                            <div class="mt clearfix">
                                                <center>
                                                    <ul class="server-list">
                                                        <li class="backup-server"> <span class="server-title">Đổi
                                                                Sever</span>
                                                            <ul class="list-episode">
                                                                <li class="episode">
                                                                    <a data-id="239471"
                                                                        data-link="${episode.link}"
                                                                        data-type="m3u8"
                                                                        onclick="chooseStreamingServer(this)"
                                                                        class="streaming-server btn-link-backup btn-episode black episode-link">VIP
                                                                        #1</a>
                                                                    
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </center>
                                            </div>
                                            <div class="mt clearfix">
                                                <div class="pull-left">
                                                    <div id="lightOff" style="display: none;"></div> <a
                                                        class="btn btn-default btn-rounded btn-yellow" title="Tắt đèn"
                                                        href="javascript:();" id="lightBtn"> <i
                                                            class="fa fa-lightbulb-o"></i> Tắt đèn</a> <a
                                                        style="margin-left: 5px;"
                                                        class="btn btn-default btn-rounded btn-yellow"
                                                        onclick="ZoomToggle();" id="zoomBtn"> <i
                                                            class="fa fa-arrows-h"></i>
                                                        Phóng to </a>
                                                    <button style="margin-left: 5px;"
                                                        class="btn btn-default btn-rounded btn-yellow bp-btn-error"
                                                        id="btn-toggle-error" title="Báo lỗi phim ${movie.name}"
                                                        > <i class="fa fa-warning"></i><a href="addmovieerror?id_movie=${movie.id}&tap=${tap}&id_episode=${episode.id}"> Báo lỗi</a> </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="list-servers">
                                        <div class="block-heading">
                                            <h2 class="block-title weight-normal text-blue"> <i class="fa fa-film"></i>
                                                <a href="view?id=${movie.id}"> ${movie.name} </a>
                                            </h2>
                                            
                                        </div>
                                        <div class="server-name"><i class="sp-movie-icon-camera"></i> Vietsub #${tap+1}</div>
                                        <div class="list-episodes">
                                            <div class="episodes mCustomScrollbar _mCS_0 mCS_no_scrollbar">
                                                <div id="mCSB_0"
                                                    class="mCustomScrollBox mCS-light-thin mCSB_vertical mCSB_inside">
                                                    <div id="mCSB_0_container"
                                                        class="mCSB_container mCS_y_hidden mCS_no_scrollbar_y">
                                                        <c:forEach var="ep" items="${ep}" varStatus="loop">
                                                        	 <c:if test="${loop.index == tap}">
                                                        	 <a class="btn btn-rounded btn-deep-orange active" title="${ep.name}"
                                                            href="view?tap=${loop.index}&id=${movie.id}">${ep.name}</a>
                                                        	</c:if>
                                                        	<c:if test="${loop.index != tap}">
                                                        	 <a class="btn btn-rounded btn-deep-orange" title="${ep.name}"
                                                            href="view?tap=${loop.index}&id=${movie.id}">${ep.name}</a>
                                                        	</c:if>
                                                        </c:forEach>
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="movie-info clearfix" style="margin-top: 0;">
                                <div id="before-watching">
                                    <div id="watching">
                                        <div id="fb-comment-before-watching">
                                            <div id="fb-comment-watching">
                                                <div class="block mt-xl">
                                                    <div class="block-heading">
                                                        <h4 class="block-title weight-normal text-pink"><i
                                                                class="sp-movie-icon-user-review"></i><span
                                                                class="text_dv">Bình luận</span></h4>
                                                    </div>
                                                    <div class="content-comment pt">
                                                        <div id="content-comment">
                                                        <div class="comment-input">
                                                            <div class="user-avatar">
                                                                <c:set value="${image.path}" var="link"></c:set>
                                                                <c:if test="${(link == null) || (link == '')}">
                                                                    <c:set value="./assets/images/defaultavatar.jpg"
                                                                        var="link"></c:set>
                                                                </c:if>
                                                                <img class="user-avatar-img" alt="" src="${link}">
                                                            </div>
                                                            <div class="ci-form">
                                                                <div class="user-name">
                                                                    <span class="link-highlight">${account.name}</span>
                                                                </div>
                                                                <form class="preform comment-form" action="addcomment" method="post">
                                                                    <input type="hidden" value="${movie.id}" name="movie_id">
                                                                    <textarea class="form-control form-control-textarea"
                                                                        name="content" maxlength="3000"
                                                                        placeholder="Để lại bình luận" name="content"></textarea>
                                                                    <div class="ci-buttons" id="df-cm-button">
                                                                        <div class="ci-b-left"></div>
                                                                        <div class="ci-b-right">
                                                                            <div class="cb-li">
                                                                                <button class="btn btn-sm btn-warning ml-2" type="submit">
                                                                                	Comment
                                                                                </button>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                        <div class="cw_list">
                                                            <c:forEach items="${comments}" var="c">
	                                                            <c:set value="${c.path}" var="link"></c:set>
																<c:if test="${(link == null) || (link == '')}">
																	<c:set value="./assets/images/defaultavatar.jpg" var="link"></c:set>
																</c:if>
	                                                            <div class="cw_l-line" id="cm-38">
	                                                                <div class="user-avatar">
	                                                                    <img class="user-avatar-img"
	                                                                        src="${link}"
	                                                                        alt="${c.name}">
	                                                                </div>
	                                                                <div class="info">
	                                                                    <div class="ihead">
	                                                                        <c:if test="${c.username == account.username}">
	                                                                        	<span class="link-highlight">${c.name}</span>
	                                                                        </c:if>
	                                                                        <c:if test="${c.username != account.username}">
	                                                                        	<div class="user-name">${c.name}</div>
	                                                                        </c:if>
	                                                                    </div>
	                                                                    <div class="ibody ">
	                                                                        <p>${c.content}</p>
	                                                                    </div>
	                                                                    <c:if test="${c.username == account.username}">
		                                                                    <div class="ibottom">
		                                                                        <div class="ib-li ib-reply" data-id="38">
		                                                                            <i class="mr-1"></i><a class="btn" href="deletecomment?id=${c.id}&movie_id=${movie.id}">Delete</a>
		                                                                        </div>
		                                                                        <div class="clearfix"></div>
		                                                                    </div>
	                                                                     </c:if>
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
                                        <div id="hidden-download">
                                            <div class="block mt-xl">
                                                <h3 class="block-title weight-normal text-pink">
                                                    <i class="sp-movie-icon-user-review text-pink"></i><span
                                                        class="text_dv">Phim liên quan</span>
                                                </h3>
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


	
        <script src="assets/player/js/p2p-media-loader-core.min.js"></script>
        <script src="assets/player/js/p2p-media-loader-hlsjs.min.js"></script>

        <script src="assets/js/jwplayer-8.9.3.js"></script>
        <script src="assets/js/hls.min.js"></script>
        <script src="assets/js/jwplayer.hlsjs.min.js"></script>

        <script>
            $(document).ready(function () {
                $('html, body').animate({
                    scrollTop: $('#media-player-box').offset().top - 40
                }, 'slow');
            });
        </script>

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
            var episode_id = 239471;
            const wrapper = document.getElementById('media-player-box');
            const vastAds = "/storage/files/ads.xml";

            function chooseStreamingServer(el) {
                const type = el.dataset.type;
                const link = el.dataset.link.replace(/^http:\/\//i, 'https://');
                const id = el.dataset.id;

                const newUrl =
                    location.protocol +
                    "//" +
                    location.host +
                    location.pathname.replace(`-${episode_id}`, `-${id}`);

                history.pushState({
                    path: newUrl
                }, "", newUrl);
                episode_id = id;


                Array.from(document.getElementsByClassName('streaming-server')).forEach(server => {
                    server.classList.remove('active');
                })
                el.classList.add('active');

                renderPlayer(type, link, id);
            }

            function renderPlayer(type, link, id) {
                $(".box_loading_player").hide();
                if (type == 'embed') {
                    if (vastAds) {
                        wrapper.innerHTML = `<div id="fake_jwplayer"></div>`;
                        const fake_player = jwplayer("fake_jwplayer");
                        const objSetupFake = {
                            key: "ITWMv7t88JGzI0xPwW8I0+LveiXX9SWbfdmt0ArUSyc=",
                            aspectratio: "16:9",
                            width: "100%",
                            file: "/themes/pcc/player/1s_blank.mp4",
                            volume: 100,
                            mute: false,
                            autostart: true,
                            advertising: {
                                tag: "/storage/files/ads.xml",
                                client: "vast",
                                vpaidmode: "insecure",
                                skipoffset: 5, // Bỏ qua quảng cáo trong vòng 5 giây
                                skipmessage: "Bỏ qua sau xx giây",
                                skiptext: "Bỏ qua"
                            }
                        };
                        fake_player.setup(objSetupFake);
                        fake_player.on('complete', function (event) {
                            $("#fake_jwplayer").remove();
                            wrapper.innerHTML = `<iframe width="100%" height="100%" src="${link}" frameborder="0" scrolling="no"
                    allowfullscreen="" allow='autoplay'></iframe>`
                            fake_player.remove();
                        });

                        fake_player.on('adSkipped', function (event) {
                            $("#fake_jwplayer").remove();
                            wrapper.innerHTML = `<iframe width="100%" height="100%" src="${link}" frameborder="0" scrolling="no"
                    allowfullscreen="" allow='autoplay'></iframe>`
                            fake_player.remove();
                        });

                        fake_player.on('adComplete', function (event) {
                            $("#fake_jwplayer").remove();
                            wrapper.innerHTML = `<iframe width="100%" height="100%" src="${link}" frameborder="0" scrolling="no"
                    allowfullscreen="" allow='autoplay'></iframe>`
                            fake_player.remove();
                        });
                    } else {
                        if (wrapper) {
                            wrapper.innerHTML = `<iframe width="100%" height="100%" src="${link}" frameborder="0" scrolling="no"
                    allowfullscreen="" allow='autoplay'></iframe>`
                        }
                    }
                    return;
                }

                if (type == 'm3u8' || type == 'mp4') {
                    wrapper.innerHTML = `<div id="jwplayer"></div>`;
                    const player = jwplayer("jwplayer");
                    const objSetup = {
                        key: "ITWMv7t88JGzI0xPwW8I0+LveiXX9SWbfdmt0ArUSyc=",
                        aspectratio: "16:9",
                        width: "100%",
                        image: "${movie.thumb_url}",
                        file: link,
                        playbackRateControls: true,
                        playbackRates: [0.25, 0.75, 1, 1.25],
                        sharing: {
                            sites: [
                                "reddit",
                                "facebook",
                                "twitter",
                                "googleplus",
                                "email",
                                "linkedin",
                            ],
                        },
                        volume: 100,
                        mute: false,
                        autostart: true,
                        logo: {
                            file: "",
                            link: "",
                            position: "",
                        },
                        advertising: {
                            tag: "/storage/files/ads.xml",
                            client: "vast",
                            vpaidmode: "insecure",
                            skipoffset: 5, // Bỏ qua quảng cáo trong vòng 5 giây
                            skipmessage: "Bỏ qua sau xx giây",
                            skiptext: "Bỏ qua"
                        }
                    };

                    if (type == 'm3u8') {
                        const segments_in_queue = 50;

                        var engine_config = {
                            debug: !1,
                            segments: {
                                forwardSegmentCount: 50,
                            },
                            loader: {
                                cachedSegmentExpiration: 864e5,
                                cachedSegmentsCount: 1e3,
                                requiredSegmentsPriority: segments_in_queue,
                                httpDownloadMaxPriority: 9,
                                httpDownloadProbability: 0.06,
                                httpDownloadProbabilityInterval: 1e3,
                                httpDownloadProbabilitySkipIfNoPeers: !0,
                                p2pDownloadMaxPriority: 50,
                                httpFailedSegmentTimeout: 500,
                                simultaneousP2PDownloads: 20,
                                simultaneousHttpDownloads: 2,
                                // httpDownloadInitialTimeout: 12e4,
                                // httpDownloadInitialTimeoutPerSegment: 17e3,
                                httpDownloadInitialTimeout: 0,
                                httpDownloadInitialTimeoutPerSegment: 17e3,
                                httpUseRanges: !0,
                                maxBufferLength: 300,
                                // useP2P: false,
                            },
                        };
                        if (Hls.isSupported() && p2pml.hlsjs.Engine.isSupported()) {
                            var engine = new p2pml.hlsjs.Engine(engine_config);
                            player.setup(objSetup);
                            jwplayer_hls_provider.attach();
                            p2pml.hlsjs.initJwPlayer(player, {
                                liveSyncDurationCount: segments_in_queue, // To have at least 7 segments in queue
                                maxBufferLength: 300,
                                loader: engine.createLoaderClass(),
                            });
                        } else {
                            player.setup(objSetup);
                        }
                    } else {
                        player.setup(objSetup);
                    }


                    const resumeData = 'OPCMS-PlayerPosition-' + id;
                    player.on('ready', function () {
                        if (typeof (Storage) !== 'undefined') {
                            if (localStorage[resumeData] == '' || localStorage[resumeData] == 'undefined') {
                                console.log("No cookie for position found");
                                var currentPosition = 0;
                            } else {
                                if (localStorage[resumeData] == "null") {
                                    localStorage[resumeData] = 0;
                                } else {
                                    var currentPosition = localStorage[resumeData];
                                }
                                console.log("Position cookie found: " + localStorage[resumeData]);
                            }
                            player.once('play', function () {
                                console.log('Checking position cookie!');
                                console.log(Math.abs(player.getDuration() - currentPosition));
                                if (currentPosition > 180 && Math.abs(player.getDuration() - currentPosition) >
                                    5) {
                                    player.seek(currentPosition);
                                }
                            });
                            window.onunload = function () {
                                localStorage[resumeData] = player.getPosition();
                            }
                        } else {
                            console.log('Your browser is too old!');
                        }
                    });

                    player.on('complete', function () {
                        if (typeof (Storage) !== 'undefined') {
                            localStorage.removeItem(resumeData);
                        } else {
                            console.log('Your browser is too old!');
                        }
                    })

                    function formatSeconds(seconds) {
                        var date = new Date(1970, 0, 1);
                        date.setSeconds(seconds);
                        return date.toTimeString().replace(/.*(\d{2}:\d{2}:\d{2}).*/, "$1");
                    }
                }
            }
        </script>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const episode = '239471';
                let playing = document.querySelector(`[data-id="${episode}"]`);
                if (playing) {
                    playing.click();
                    return;
                }

                const servers = document.getElementsByClassName('streaming-server');
                if (servers[0]) {
                    servers[0].click();
                }
            });
        </script>

        <script>
            $("#btn-toggle-error").click(() => {
                fetch("view?id=${movie.id}", {
                    method: 'POST',
                    headers: {
                        "Content-Type": "application/json",
                        'X-CSRF-TOKEN': document.querySelector('meta[name="csrf-token"]').getAttribute(
                            'content')
                    },
                    body: JSON.stringify({
                        message: ''
                    })
                });
                $("#btn-toggle-error").remove();
            })
        </script>


        <script src="assets/libs/jquery-raty/jquery.raty.js"></script>
        <link href="assets/libs/jquery-raty/jquery.raty.css" rel="stylesheet" type="text/css"/>

        <script>
            var rated = false;
            $('#movies-rating-star').raty({
                score: 9.0,
                number: 10,
                numberMax: 10,
                hints: ['quá tệ', 'tệ', 'không hay', 'không hay lắm', 'bình thường', 'xem được', 'có vẻ hay', 'hay',
                    'rất hay', 'siêu phẩm'
                ],
                starOff: '/themes/pcc/libs/jquery-raty/images/star-off.png',
                starOn: '/themes/pcc/libs/jquery-raty/images/star-on.png',
                starHalf: '/themes/pcc/libs/jquery-raty/images/star-half.png',
                click: function (score, evt) {
                    if (rated) return
                    fetch("https://default.ophimcms.com/phim/than-an-vuong-toa/rate", {
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