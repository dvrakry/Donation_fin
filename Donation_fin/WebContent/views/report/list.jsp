<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!--================Order Details Area =================-->
  <section class="order_details section-margin--small">
    <div class="container">
      <p class="text-center billing-alert">Thank you. Your order has been received.</p>
      <div class="row mb-5">
        <div class="col-md-6 col-xl-12 mb-4 mb-xl-0">
          <div class="confirmation-card">
            <h3 class="billing-title">Member Info</h3>
            <table class="order-rable">
              <tr>
                <td>ID</td>
                <td>: ${ses.mid }</td>
              </tr>
              <tr>
                <td>Name</td>
                <td>: ${ses.mname }</td>
              </tr>
              <tr>
                <td>Phone</td>
                <td>: ${ses.mphone }</td>
              </tr>
            </table>
          </div>
        </div>
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
    </div>
  </section>
  <script>
  $("#btn3").on("click",function(){
		let a = $(".price").length;
		let priceArray = [];
		let countArray = [];
		let totalArray = [];
		for (var i = 0; i < a; i++) {
			priceArray[i] = $(".price").eq(i).text();
			countArray[i] = $("input[name='count']").eq(i).val();
			total[i]=priceArray[i] * countArray[i]
		}
		let totalmoney=0;
		for (var j = 0; j < total.length; j++) {
			totalmoney=totalmoney+total[j];
		}
		$(".total").text(totalmoney);
		
  });	
  
  </script>
  <!--================End Order Details Area =================-->