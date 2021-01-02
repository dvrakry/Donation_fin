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
						<p>테스트: ${ses.mno }, ${ses.mname }
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
	<script src="resources/vendors/jquery/jquery-3.2.1.min.js"></script>
	<script>
		$(function(){
			bnoVal = '<c:out value="${bvo.bno}"/>';
			mnoVal = '<c:out value="${ses.mno}"/>';
			console.log(mnoVal);
			writerVal = '<c:out value="${ses.mname}"/>';
			getlistComment(bnoVal);
		});
		function getlistComment(bnoVal){
			$("#cmtList").html("");
			$.ajax({
				url:"./comment/list_m",
				type:"post",
				data:{mno:mnoVal},
				success: function(list){
					let listObj = JSON.parse(list);
					printListComment(listObj);
				},
				error:function(msg){
				}
			});
		};
		function printListComment(listObj){
			for(let cvo of listObj){
				let lis = '';
					lis += '<tr><td class="z1"></td> <td class="z2"></td> <td class="z3"></td>';
					lis += '<td><button class="rmBtn">삭제</button></td>';
					lis += '<td><input type="hidden" name="cnumber" class="z4"></td>';
					lis += '<td><input type="hidden" name="mnumber" class="z5"></td></tr>'
				$("#cmtList").append(lis);
				
			for(let key in cvo){
				switch (key) {
				case "writer":
					$("#cmtList tr:last-child .z1").text('['+ cvo[key]+ ']');
					break;
				 case "comment":
                     $("#cmtList tr:last-child .z2").html(cvo[key]);
                     break;
                  case "cregdate":
                     $("#cmtList tr:last-child .z3").text(cvo[key]);
                     break;
                  case "cno":
                 	$("#cmtList tr:last-child .z4").text(cvo[key]);
                 	break;
                 case "mno":
                 	$("#cmtList tr:last-child .z5").text(cvo[key]);
                 	break;
				default:
					break;
				}
			}
			}
		}
		
		
		$(document).on("click",".rmBtn" ,function(){
			let cnoVal = $(this).closest("tr").find(".z4").text();
			let mnoVal = $(this).closest("tr").find(".z5").text();
			let sesVal = '<c:out value="${ses.mno }"/>';
			if(mnoVal == sesVal){
			$.ajax({
			url: "./comment/rm",
			type: "post",
			data: {cno:cnoVal, mno:mnoVal},
			success: function(result){
				let res = parseInt(result);
				if(res>0){
					alert("댓글 삭제 완료");
					getlistComment(mnoVal);
					$("#cmt").val("");
				}else{
					alert("댓글 삭제 실패! \n 관리자에게 문의하세요.")
				}
			},
			error: function(msg){
				alert(msg);
			}
		});
			}else{
				alert("댓글 삭제 실패! \n 관리자에게 문의하세요.")
			}
	});
		
		$("#cmtBtn").on("click",function(){
			let cmtVal = $("#cmt").val();
			$.ajax({
				url: "./comment/add_m",
				type: "post",
				data: {mno:mnoVal, writer:writerVal, comment:cmtVal},
				success: function(result){
					let res = parseInt(result);
					if(res>0){
						alert("댓글 등록 완료");
						getlistComment(mnoVal);
						$("#cmt").val("");
					}else{
						alert("댓글 등록 실패! \n 관리자에게 문의하세요.");
					}
				},
				error: function(msg){
					alert(msg);
				}
			});
		});
		
	</script>
	
	
	
	
	
	
	
	
	