<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="order_details_table">
	<h2>회원 정보 수정</h2>
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">아이디</th>
					<th scope="col">이름</th>
					<th scope="col">연락처</th>
					<th scope="col">시설명</th>
					<th scope="col">수정</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${ses.mid eq 'admin'}">
						<c:forEach items="${mList }" var="mvo">
							<tr>
								<td class="shoping__cart__item">
									<h5>${mvo.mid }</h5>
								</td>
								<td class="shoping__cart__price">${mvo.mname }</td>
								<td class="shoping__cart__quantity">${mvo.mphone }</td>
								<td class="shoping__cart__quantity">${mvo.mins }</td>

								<td class="shoping__cart__total">
									<button class="btn btn-outline-warning btn-sm modBtn">수정</button>
								</td>
								<td class="shoping__cart__item__close">
									<button class="btn btn-outline-danger btn-sm rmBtn">삭제</button>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<h3>관리자 이외의 접근을 허용하지 않습니다:(</h3>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>

<div id="formTagZone"></div>
<<<<<<< HEAD
<script>
=======

<script> //스크립트로 진행할지 고민
>>>>>>> refs/remotes/origin/master
	let modBtn = $(".modBtn");
	modBtn.on("click", function(){
		let mid = $(this).closest("tr").find("h5").text();
		let formTag = "<form action = './member?sv=modify' method='post' id='modForm'>";
		formTag += "<input type='hidden' name='mid' value='"+mid+"'>";
		formTag += "<button type='submit' id='sbmBtn'>제출</button>";
		formTag += "</form>";
		$('#formTagZone').append(formTag);
		$(document).find("#sbmBtn").click();
	});
</script>
<div id="formTagZone2"></div>
<script>
	let rmBtn = $(".rmBtn");
	rmBtn.on("click", function(){
		let mid = $(this).closest("tr").find("h5").text();
		let formTag = "<form action='./member?sv=delete' method='post' id='deleteForm'>";
		formTag += "<input type='hidden' name='mid' value='"+ mid +"'>";
		formTag += "<button type='submit' id='sbmBtn2'>제출</button>";
		formTag += "</form>";
		$("#formTagZone2").append(formTag);
		$(document).find("#sbmBtn2").click();
	});
</script>





