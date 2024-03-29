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
            <link rel="stylesheet" href="asserts/css/statistical.css">
            <link rel="stylesheet" href="asserts/css/style.css">
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
                            <li><a href="profile"><i class="las la-user-cog icon"></i>
                                    Settings</a></li>
                            <li><a href="logout"><i class="las la-sign-out-alt icon"></i>
                                    Logout</a></li>
                        </ul>
                    </div>
                </nav>


                <!-- MAIN -->
                <main>
                    <h1 class="title">Dashboard</h1>
                    <ul class="breadcrumbs">
                        <li><a href="#">Home</a></li>
                        <li class="divider">/</li>
                        <li><a href="#" class="active">Dashboard</a></li>
                    </ul>


                </main>

                <div class="container-fluid animated fadeIn">
                    <div class="row">
                        <div class="col-md-2">
                            <div class="card-counter primary">
                                <i class="la la-play-circle"></i>
                                <span class="count-numbers counter">${totalMovie}</span>
                                <span class="count-name">Tổng số phim</span>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <div class="card-counter info">
                                <i class="las la-server"></i>
                                <span class="count-numbers counter">${totalEpisode}</span>
                                <span class="count-name">Tổng số tập</span>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <div class="card-counter danger">
                                <i class="las la-bug"></i>
                                <span class="count-numbers counter">${totalMovieError}</span>
                                <span class="count-name">Tập lỗi</span>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <div class="card-counter success">
                                <i class="las la-user"></i>
                                <span class="count-numbers counter">${totalMember}</span>
                                <span class="count-name">Users</span>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <div class="card-counter bg-primary">
                                <i class="las la-eye"></i>
                                <span class="count-numbers counter">${totalView}</span>
                                <span class="count-name">Tổng lượt xem</span>
                            </div>
                        </div>

                        <div class="col-md-2">
                            <div class="card-counter">
                                <i class="las la-puzzle-piece"></i>
                                <span class="count-numbers counter">${totalVisit}</span>
                                <span class="count-name">Tổng lượt truy cập</span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="p-3 col-md-4">
                            <table class="table table-sm">
                                <thead>
                                    <tr>
                                        <th colspan="2" scope="col">TOP NGÀY</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white">
                                    <c:forEach var="m" items="${ld}">
                                        <tr>
                                            <td><a href="view?id=${m.id}">${m.name}</a></td>
                                            <td class="text-right"><span class="badge badge-success"><i
                                                        class="las la-eye"></i> ${m.view_month }</span></td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <div class="p-3 col-md-4">
                            <table class="table table-sm">
                                <thead>
                                    <tr>
                                        <th colspan="2" scope="col">TOP TUẦN</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white">
                                    <c:forEach var="m" items="${lw}">
                                        <tr>
                                            <td><a href="view?id=${m.id}">${m.name}</a></td>
                                            <td class="text-right"><span class="badge badge-success"><i
                                                        class="las la-eye"></i> ${m.view_month }</span></td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <div class="p-3 col-md-4">
                            <table class="table table-sm">
                                <thead>
                                    <tr>
                                        <th colspan="2" scope="col">TOP THÁNG</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white">
                                    <c:forEach var="m" items="${lm}">
                                        <tr>
                                            <td><a href="view?id=${m.id}">${m.name}</a></td>
                                            <td class="text-right"><span class="badge badge-success"><i
                                                        class="las la-eye"></i> ${m.view_month }</span></td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- MAIN -->
                <!-- NAVBAR -->

            </section>
            <!-- CONTENT -->

            <script src="asserts/js/script.js"></script>
        </body>

        </html>