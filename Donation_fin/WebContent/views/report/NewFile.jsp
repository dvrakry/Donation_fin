<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<section class="cart_area">
      <div class="container">
      <form action="./report?sv=reg" method="post">
          <div class="cart_inner">
              <div class="table-responsive">
                  <table class="table">
                      <thead>
                          <tr>
                              <th scope="col">Thumb</th>
                              <th scope="col">Product</th>
                              <th scope="col">Price</th>
                              <th scope="col">Count</th>
                          </tr>
                      </thead>
                      
                      <tbody>
                      
                              
                      <c:forEach items="${sList }" var="svo">
                      <input type="hidden" name="mname" value="${ses.mname }">
                                  <input type="hidden" name="product" value="${svo.pname }">
                                  <input type="hidden" name="sprice" value="${svo.price } }">                                  
                                  <input type="hidden" name="ins" value="${ises.iname }">
                          <tr>
                              <td>
                              <h5><img src="upload/${svo.thumb }"></h5>
                              </td>
                              <td>
                                  <h5>${svo.pname }</h5>
                              </td>
                              <td>
                                  <h5 class="price">${svo.price }</h5>
                              </td>
                              <td>
                                  <div class="product_count">
                                      <input type="number" name="count" id="sst" maxlength="12" value="1" title="Quantity:"
                                          class="input-text qty count">
                                      <button onclick="var result = document.getElementById('sst');var sst = result.value;if( !isNaN( sst )) result.value++;return false;"
                                          class="increase items-count" type="button"><i class="lnr lnr-chevron-up"></i></button>
                                      <button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 0 ) result.value--;return false;"
                                          class="reduced items-count" type="button"><i class="lnr lnr-chevron-down"></i></button>
                                  </div>
                              </td>
                              <td>
                              <a class="button button-header" href="./support?sv=rm&sno=${svo.sno }">삭제</a>
                              </td>
                          </tr>
                              </c:forEach>
                              
                          <tr class="bottom_button">
                              <td>
                                  <a class="button" href="./product?sv=list">상품 목록으로</a>
                              </td>
                              <td>
                              </td>
                              <td>
                              </td>
                              <td>
                                  <div class="cupon_text d-flex align-items-center">
                                 
                                  <button type="submit" class="subBtn">구매하기</button>
                                      <a class="button" href="./report?sv=rm">구매하기</a>
                                      
                                  </div>
                              </td>
                          </tr>
                          <tr>
                              <td>
                     <p><button id="btn3">버튼</button></p>
                              </td>
                              <td>

                              </td>
                              <td>
                                  <h5>Subtotal</h5>
                              </td>
                              <td>
                                  <h5 class="total"></h5>
                              </td>
                          </tr>
                          
                      </tbody>
                  </table>
              </div>
              
          </div>
          </form>
      </div>
      
  </section>
  <script>
  	$()
      function total(){
      let a = $(".price").length;
      let priceArray = [];
      let countArray = [];
      let totalArray = [];
      for (var i = 0; i < a; i++) {
         priceArray[i] = $(".price").eq(i).text();
         console.log("check1 > " + priceArray[i]);
         countArray[i] = $("input[name='count']").eq(i).val();
         console.log("check2 > " + countArray[i]);
         totalArray[i]=priceArray[i] * countArray[i];
         console.log("check3 >" + totalArray[i]);
      }
      let totalmoney=0;
      for (var j = 0; j < totalArray.length; j++) {
         totalmoney=totalmoney+totalArray[j];
      }
      $(".total").text(totalmoney);
      
  };   
  </script>
  
  