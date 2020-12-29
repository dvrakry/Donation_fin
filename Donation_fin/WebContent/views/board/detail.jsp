<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!--================Single Product Area =================-->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 posts-list">
				<div class="single-post row">
					<div class="col-lg-12">
						<div class="feature-img">
							<img class="img-fluid" src="upload/${bvo.imgfile }" alt="">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 blog_details">
						<h3>시설명: ${bvo.iname }</h3>
						<h5>후원자: ${bvo.bperson }</h5>
						<h5>후원자ID: ${bvo.bid }</h5>
						<p>감사의 인사: ${bvo.bcontent }</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4"></div>
		
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
		
		</div>
		<br> <br>
		<c:if test="${ses.mname ne null || ses.mname ne '' }">
			<form>
				<input type="text" id="cmt" class="f"
					placeholder="Enter Your Comment"
					style="width: 70%; margin-right: 10px;">

				<button class="btn btn-default" type="button" id="cmtBtn">
					입력</button>

			</form>
		</c:if>
		<table id="cmtList">

		</table>
		<div id="formTagZone"></div>
	</div>
	<!-- 
	<script>
		$(function(){
			bnoVal = '<c:out value="${bvo.bno}"/>';
			writerVal = '<c:out value="${bvo.iname}"/>';
			getlistComment(bnoVal);
		});
		function getlistComment(bnoVal){
			$("#cmtList").html("");
			$.ajax({
				url:"./comment/list"
			})
		};
	
	</script>
	
	
	
	
	
	
	 -->
	
	