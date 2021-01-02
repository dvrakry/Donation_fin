<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!--================Order Details Area =================-->
  <section class="order_details section-margin--small">
    <div class="container">
      <p class="text-center billing-alert">마이페이지</p>
      <div class="row mb-5 TR">
        <div class="col-md-6 col-xl-12 mb-4 mb-xl-0">
          <div class="confirmation-card">
            <h3 class="billing-title">Member Info</h3>
            <table class="order-rable">
              <tr>
                <td>ID:</td>
                <td><h5 class="Mn">${ses.mid }</h5></td>
              </tr>
              <tr>
                <td>Name:</td>
                <td><h5>${ses.mname }</h5></td>
              </tr>
              <tr>
                <td>Phone:</td>
                <td><h5>${ses.mphone }</h5></td>
              </tr>
            </table>
          </div>
        </div>
	     <button class="btn btn-outline-dark btn-sm modBtn">회원정보수정</button>
	      <button class="btn btn-outline-dark btn-sm rmBtn">회원탈퇴</button>
      </div>
      
      
      <div class="order_details_table">
        <h2>Order Details</h2>
        <div class="table-responsive">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">Product</th>
                <th scope="col">Price</th>
                <th scope="col">Count</th>
                <th scope="col">Total</th>
                <th scope="col">Institution</th>
                <th scope="col">Date</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${rList}" var="rvo">
               <c:if test="${ses.mname eq rvo.name }">
              <tr>
                <td>
                  <p>${rvo.product }</p>
                </td>
                <td>
                  <p>${rvo.price }</p>
                </td>
                <td>
                  <p>${rvo.count }</p>
                </td>
                <td>
                  <p>${rvo.price*rvo.count }</p>
                </td>
                <td>
                  <p>${rvo.ins }</p>
                </td>
                <td>
                  <p>${rvo.regdate }</p>
                </td>
              </tr>
              </c:if>
              </c:forEach>
            </tbody>
          </table>
        </div>
        
      </div>
      <div class="product__pagination">
               <c:if test="${paging.prevBlock > 5 }">
                     <a href="./report?sv=list&cp=${paging.prevBlock }&mname=${ses.mname}"><i class="fa fa-long-arrow-left"></i></a>
                </c:if>
               <c:forEach var="i" begin="${paging.prevBlock + 1}" 
               end="${paging.totalPage }" varStatus="status">
               <c:if test="${status.count < 6 }">
                     <c:choose>
                        <c:when test="${i eq paging.clPage }">
                           <a href="#">${i }</a>
                        </c:when>
                        <c:otherwise>
                           <a href="./report?sv=list&cp=${i }&mname=${ses.mname}">${i }</a>
                        </c:otherwise>
                     </c:choose>
                     
               </c:if>
              </c:forEach>
               <c:if test="${paging.nextBlock < paging.totalPage }">
                  <a href="./report?sv=list&cp=${paging.nextBlock }&mname=${ses.mname}"><i class="fa fa-long-arrow-right"></i></a>
               </c:if>
            </div>
            <br>
    </div>
  </section>
  <div id="formTagZone"></div>
  <script>
/*    $(document).on("click",".modBtn" ,function(){  */
	console.log("check1");
  let modBtn = $(".modBtn");
  modBtn.on("click",function(){
		let mid = $(this).closest(".TR").find(".Mn").text();
		console.log(mid);
		console.log("check2");
		let formTag = "<form action = './member?sv=modify' method='post' id='modForm'>";
			formTag += "<input type='hidden' name='mid' value='"+ mid +"'>";
			formTag += "<button type='submit' id='sbmBtn'>제출</button>";
			formTag += "</form>";
			$('#formTagZone').append(formTag);
			$(document).find('#sbmBtn').click();
	});
  </script>
  
 <div id="formTagZone2"></div>
<script>


	let rmBtn = $(".rmBtn");
	rmBtn.on("click", function(){
		let mid = $(this).closest(".TR").find(".Mn").text();
		console.log(mid);
		let formTag = "<form action='./member?sv=delete' method='post' id='deleteForm'>";
		formTag += "<input type='hidden' name='mid' value='"+ mid +"'>";
		formTag += "<button type='submit' id='sbmBtn2'>제출</button>";
		formTag += "</form>";
		$("#formTagZone2").append(formTag);
		$(document).find("#sbmBtn2").click();
	});
</script>
  <!--================End Order Details Area =================-->