<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section class="order_details section-margin--small">
    <div class="container">
      <div class="order_details_table">
        <h2>${mvo.mname }님 수정페이지</h2>
        <div class="table-responsive">
          <form action="./member?sv=update&mid=${mvo.mid }" class="form-contact contact_form" 
           method="post" id="contactForm" novalidate="novalidate">
	         <table class="table">
	           <thead>
	             <tr>
	               <th scope="col">이름</th>
	               <th scope="col">비밀번호</th>
	               <th scope="col">연락처</th>
	             </tr>
	           </thead>
	           <tbody>
	             <tr>
	               <td>
	          		 <input class="form-control" type="text" name="mname" value="${mvo.mname }">
	               </td>
	               <td>
	                 <input class="form-control" type="text" name="mpwd" value="${mvo.mpwd }">
	               </td>
	               <td>
	                 <input class="form-control" type="text" name="mphone" value="${mvo.mphone }">
	               </td>
	             </tr>
	           </tbody>
	         </table>
	         <div class="form-group text-center text-md-right mt-3">
             		 <button type="submit" class="button button--active button-contactForm">수정완료</button>
           		 </div>
          </form>
        </div>
      </div>
    </div>
  </section>