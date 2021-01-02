<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="bvo" value="${bList }"/>
<section class="blog">
	<div class="container">
		<div class="section-intro pb-60px">
			<p>기부내용을 바로 확인할수있는 ${ses.mno }, ${ses.mname }</p>
			<h2>
				감사<span class="section-intro__style">게시판</span>
			</h2>
		</div>
		<c:choose>
			<c:when test="${ses.mins ne null && ses.mins ne '' }">
				<div class="col-md-12 form-group">
					<button type="button" onclick="location.href='index.jsp?rp=write'"
						class="button button-register w-80">글쓰기</button>
				</div>
			</c:when>
			<c:otherwise>
				<div class="col-md-12 form-group">
					<button type="button"
						onclick="alert('시설회원만 글을 작성할 수 있습니다!');return false;"
						class="button button-register w-80">글쓰기</button>
				</div>
				
			</c:otherwise>
		</c:choose>
		<div class="row">
			<c:forEach items="${bList }" var="bvo">
				<div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
					<div class="card card-blog">
						<div class="card-blog__img">
							<img class="card-img rounded-0"
								src="upload/${bvo.thumb }" alt="" style="height:270px; width:270px;">
						</div>
						<div class="card-body">
							<ul class="card-blog__info">
								<li><a href="#"><i class="ti-comments-smiley"></i>후원받은 시설명: ${bvo.iname }</a></li>
							</ul>
							<ul class="card-blog__info">
								<li><a href="#"><i class="ti-comments-smiley"></i> 후원자: ${bvo.bperson } / 후원자ID: ${bvo.bid }</a></li>
			
							</ul>
							<i class='far fa-comment'></i> 감사인사:
							<h4 class="card-blog__title">
							${bvo.bcontent }
							</h4>
							<!-- 디테일~~ 1111-->
							<a class="card-blog__link" href="./board?sv=info&bno=${bvo.bno }">Read More</a>
								
								<button type="button" onclick="location.href='./board?sv=mod&bno=${bvo.bno}'"
								class="btn btn-outline-info">수정</button>
								<button type="button" onclick="location.href='./board?sv=delete&bno=${bvo.bno}'"
								class="btn btn-outline-info">삭제</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="product__pagination">
			<c:if test="${paging.prevBlock > 5 }">
				<a href="./product?sv=list&cp=${paging.prevBlock }"><i
					class="fa fa-long-arrow-left"></i></a>
			</c:if>
			<c:forEach var="i" begin="${paging.prevBlock + 1 }"
				end="${paging.totalPage }" varStatus="status">
				<c:if test="${status.count < 6 }">
					<c:choose>
						<c:when test="${i eq paging.clPage }">
							<a href="#">${i }</a>
						</c:when>
						<c:otherwise>
							<a href="./board?sv=list&cp=${i }">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:forEach>
			<c:if test="${paging.nextBlock < paging.totalPage }">
				<a href="./product?sv=list&cp=${paging.nextBlock }"> <i
					class="fa fa-long-arrow-right"></i></a>
			</c:if>
		</div>
	</div>
</section>