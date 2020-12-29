<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="resources/vendors/jquery/jquery-3.2.1.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Aroma Shop - Home</title>
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
</head>
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
							<li class="nav-item submenu dropdown"><a
								href="./ins?sv=list" class="nav-link dropdown-toggle">Institution</a></li>
							<li class="nav-item submenu dropdown"><a
								href="./ins?sv=list" class="nav-link dropdown-toggle">Report</a></li>
								<li class="nav-item submenu dropdown"><a
								href="./ins?sv=list" class="nav-link dropdown-toggle">Board</a></li>

						</ul>

						<ul class="nav-shop">
							<li class="nav-item"><button>
									<i class="ti-search"></i>
								</button></li>
							<li class="nav-item"><button>
									<i class="ti-shopping-cart"></i><span class="nav-shop__circle">3</span>
								</button></li>
							<li class="nav-item"><a class="button button-header"
								href="#">Buy Now</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Menu Area =================-->



	<script src="resources/vendors/jquery/jquery-3.2.1.min.js"></script>
	<script src="resources/vendors/bootstrap/bootstrap.bundle.min.js"></script>
	<script src="resources/vendors/skrollr.min.js"></script>
	<script src="resources/vendors/owl-carousel/owl.carousel.min.js"></script>
	<script src="resources/vendors/nice-select/jquery.nice-select.min.js"></script>
	<script src="resources/vendors/jquery.ajaxchimp.min.js"></script>
	<script src="resources/vendors/mail-script.js"></script>
	<script src="resources/js/main.js"></script>
</body>
</html>