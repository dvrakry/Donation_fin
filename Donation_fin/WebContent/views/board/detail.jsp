<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="owl-carousel owl-theme s_Product_carousel">
						<div class="single-prd-item">
							<img class="img-fluid" src="upload/${bvo.thumb }" alt="">
						</div>
						<!-- <div class="single-prd-item">
							<img class="img-fluid" src="img/category/s-p1.jpg" alt="">
						</div>
						<div class="single-prd-item">
							<img class="img-fluid" src="img/category/s-p1.jpg" alt="">
						</div> -->
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text">
						<h3>시설명: ${bvo.iname }</h3>
						<h5>후원자: ${bvo.bperson }</h5>
						<h5>후원자ID: ${bvo.bid }</h5>
						<p>감사의 인사: ${bvo.bcontent }</p>
						<c:choose>
							<c:when test="${ses.mid eq bvo.bid }">
								<button type="button" onclick="location.href='./board?sv=mod&bno=${bvo.bno}'"
								class="button button-register w-80">수정</button>
								<button type="button" onclick="location.href='./board?sv=delete&bno=${bvo.bno}'"
								class="button button-register w-80">삭제</button>
							</c:when>
							<c:otherwise>
								<button type="button" onclick="alert('본인이 작성한 글만 수정할 수 있습니다.');return false;"
								class="button button-register w-80">수정</button>
								<button type="button" onclick="alert('본인이 작성한 글만 삭제할 수 있습니다.');return false;"
								class="button button-register w-80">삭제</button>
							</c:otherwise>
						</c:choose>
						<p></p>
						<p></p>
						<p></p>
					</div>
				</div>
			</div>
		</div>
	</div>