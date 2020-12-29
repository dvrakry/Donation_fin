<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>         


<!-- Start Filter Bar -->
   <!-- 관리자만 뜨게 할것 Start -->
          <div class="filter-bar d-flex flex-wrap align-items-center">
              <div><c:if test="${ses.mid eq 'admin'}">
                	<div class="input-group-append">
                  <a class="button button-header" href="index.jsp?rp=preg">상품등록</a>
                	</div>
                	</c:if>
                	<div class="input-group-append">
                  <a class="button button-header" href="./support?sv=list">장바구니</a>
                	</div>
              </div>
          </div>
          <!-- 관리자만 뜨게 할것 End -->
          <!-- End Filter Bar -->
          
          
          <section class="lattest-product-area pb-40 category-list">
            <div class="row">
            
              
              <!-- 상품 이미지 넣을 공간 -->
            <c:forEach items="${pList }" var="pvo">
              <div class="col-md-6 col-lg-3">
                <div class="card text-center card-product h6">
                  <div class="card-product__img">
                    <img class="card-img" src="upload/${pvo.thumb }" alt="이미지가 나오지 않습니다" style="height:200px; width:200px;">
                  </div><input type="hidden" class="i1" value="${pvo.thumb }">
                  <div class="card-body">
                    <h4 class="card-product__title">${pvo.pname }</h4>
                    <p class="card-product__price pr" style="display:inline-block;">${pvo.price}</p><span>원</span>
                    
                    <p><button class="btn btn-outline-warning btn-sm supBtn">장바구니 담기</button></p>
                    <c:if test="${ses.mid eq 'admin'}">
                    <p><a href="./product?sv=mod&pno=${pvo.pno }">수정</a>
                    &nbsp;&nbsp;<a href="./product?sv=rm&pno=${pvo.pno }">삭제</a></p>
                    </c:if>
                    
                  </div>
                </div>
              </div>
              </c:forEach>
              
            </div>
            <div class="product__pagination">
               <c:if test="${paging.prevBlock > 5 }">
                     <a href="./product?sv=list&cp=${paging.prevBlock }"><i class="fa fa-long-arrow-left"></i></a>
                </c:if>
               <c:forEach var="i" begin="${paging.prevBlock + 1}" 
               end="${paging.totalPage }" varStatus="status">
               <c:if test="${status.count < 6 }">
                     <c:choose>
                        <c:when test="${i eq paging.clPage }">
                           <a href="#">${i }</a>
                        </c:when>
                        <c:otherwise>
                           <a href="./product?sv=list&cp=${i }">${i }</a>
                        </c:otherwise>
                     </c:choose>
                     
               </c:if>
              </c:forEach>
               <c:if test="${paging.nextBlock < paging.totalPage }">
                  <a href="./product?sv=list&cp=${paging.nextBlock }"><i class="fa fa-long-arrow-right"></i></a>
               </c:if>
            </div>
          </section>
         
          
          <!-- End Best Seller -->
          
          <!-- let cnoVal = $(this).closest("tr").find(".z4").text();
                      let inoVal = $(this).closest("tr").find(".z5").text(); -->
          
			<script>
			
			 let supBtn = $(".supBtn");
			
/* 				let ThumbVal = '<c:out value = "${pvo.thumb}"/>';
				let PnameVal = '<c:out value = "${pvo.pname}"/>';
				let PriceVal = '<c:out value = "${pvo.price}"/>'; */
			
				$(document).on("click",".supBtn" ,function(){
			 	let ThumbVal = $(this).closest(".h6").find(".i1").val();
				let PnameVal = $(this).closest(".h6").find("h4").text();
				let PriceVal = $(this).closest(".h6").find(".pr").text();
				$.ajax({
					url : "./support?sv=reg",
					type : "post",
					data : {thumb:ThumbVal,pname:PnameVal,price:PriceVal},
					success : function(result) {
						if(result == '1'){
                            alert("장바구니에 추가되었습니다");
                         }else{
                            alert("장바구니 안됨");
                         }
					}
					
				
				})
				
			});
			</script>
