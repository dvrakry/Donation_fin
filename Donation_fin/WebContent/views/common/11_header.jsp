<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Donation Site - Home</title>
<link rel="icon" href="resources/img/Fevicon.png" type="image/png">
<link rel="stylesheet"
	href="resources/vendors/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
	href="resources/vendors/fontawesome/css/all.min.css">
<link rel="stylesheet"
	href="resources/vendors/themify-icons/themify-icons.css">
<link rel="stylesheet"
	href="resources/vendors/nice-select/nice-select.css">
<link rel="stylesheet"
	href="resources/vendors/owl-carousel/owl.theme.default.min.css">
<link rel="stylesheet"
	href="resources/vendors/owl-carousel/owl.carousel.min.css">

<link rel="stylesheet" href="resources/css/style.css">
<script src="resources/vendors/jquery/jquery-3.2.1.min.js"></script>
<script src="resources/vendors/bootstrap/bootstrap.bundle.min.js"></script>
<script src="resources/vendors/skrollr.min.js"></script>
<script src="resources/vendors/owl-carousel/owl.carousel.min.js"></script>
<script src="resources/vendors/nice-select/jquery.nice-select.min.js"></script>
<script src="resources/vendors/jquery.ajaxchimp.min.js"></script>
<script src="resources/vendors/mail-script.js"></script>
<script src="resources/js/main.js"></script>
</head>
<c:set var="ses" value="${ses_mvo }" scope="session" />
<c:set var="ises" value="${ses_ivo }" scope="session" />
<body>
	<!--================ Start Header Menu Area =================-->
	<header class="header_area">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container">
					<a class="navbar-brand logo_h" href="index.html"><img
						src="img/logo.png" alt=""></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="collapse navbar-collapse offset"
						id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto mr-auto">
							<li class="nav-item active"><a class="nav-link"
								href="index.jsp">Home</a></li>
							<li class="nav-item submenu dropdown"><a href="./ins?sv=list"
								class="nav-link dropdown-toggle">Institution</a>
								</li>
							<li class="nav-item submenu dropdown"><a href="./product?sv=list"
								class="nav-link dropdown-toggle">Shop</a>
								</li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Pages</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
									<li class="nav-item"><a class="nav-link"
										href="register.html">Register</a></li>
									<li class="nav-item"><a class="nav-link"
										href="tracking-order.html">Tracking</a></li>
								</ul></li>
							<li class="nav-item"><a class="nav-link" href="./board?sv=list">감사게시판</a></li>
						</ul>
						<c:choose>
							<c:when test="${ses.mid ne '' && ses.mid ne null }">
								<c:choose>
									<c:when test="${ses.mid eq 'admin'}">
										<ul class="nav-shop">
											<li class="nav-item">환영합니다.</li>
											<li class="nav-item"><i
													class="fa fa-user"></i>관리자님
											</li>
											<li class="nav-item"><a class="button button-header"
												href="./member?sv=list">회원관리</a></li>
											<li class="nav-item"><a class="button button-header"
												href="./member?sv=logout">LogOut</a></li>
										</ul>
									</c:when>
									<c:otherwise>
										<ul class="nav-shop">
											<li class="nav-item">환영합니다.</li>
											<li class="nav-item"><i class="fa fa-user"></i>${ses.mname }님
											</li>
											<li class="nav-item"><a class="button button-header"
												href="./report?sv=list_m&mname=${ses.mname }">마이페이지</a></li>
											<li class="nav-item"><a class="button button-header"
												href="./member?sv=logout">LogOut</a></li>
										</ul>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<ul class="nav-shop">
									<li class="nav-item"><button>
											<i class="ti-search"></i>
										</button></li>
									<li class="nav-item"><button>
											<i class="ti-shopping-cart"></i><span
												class="nav-shop__circle">3</span>
										</button></li>
									<li class="nav-item"><a class="button button-header"
										href="index.jsp?rp=prejoin">Join</a></li>
									<li class="nav-item"><a class="button button-header"
										href="index.jsp?rp=login">LogIn</a></li>
								</ul>
							</c:otherwise>

						</c:choose>

						<!-- <div class="modal" id="loginModal">
							<div class="modal-dialog">
								<div class="modal-content">

									Modal Header
									<div class="modal-header">
										<h4 class="modal-title">Login Member</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>

									<form action="./member" method="post">
										<input type="hidden" name="sv" value="login">
										Modal body
										<div class="modal-body">
											<div class="form-group">
												<p>
													Member ID (아이디)<span>*</span>
												</p>
												<input class="form-control" type="text" name="mid" required>
											</div>
											<div class="form-group">
												<p>
													Password (비밀번호)<span>*</span>
												</p>
												<input class="form-control" type="password" name="mpwd"
													required>
											</div>
										</div>

										Modal footer
										<div class="modal-footer">
											<button type="submit" class="btn btn-success">로그인</button>
										</div>
									</form>
								</div>
							</div>
						</div> -->
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Menu Area =================-->