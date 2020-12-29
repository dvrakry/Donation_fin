<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section
	class="blog_area single-post-area py-80px section-margin--small">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 posts-list">
				<div class="single-post row">
					<div class="col-lg-12">
						<div class="feature-img">
							<img class="img-fluid" src="upload/${ises.imgfile }" alt="">
						</div>
					</div>

					<div class="col-lg-12 col-md-12 blog_details">
						<h2>${ises.iname }</h2>
						<p>${ises.loc }</p>
						<p>${ises.icnt }</p>
					</div>

				</div>

			</div>


			<div class="col-lg-4">
				<div class="blog_right_sidebar">
					<aside class="single_sidebar_widget search_widget">
						<div class="input-group"></div>
						<!-- /input-group -->
						<div class="br"></div>
					</aside>
					<aside class="single_sidebar_widget author_widget"></aside>
				</div>
			</div>
			<c:if test="${ses.mname eq ises.represent || ses.mid eq 'admin' }">
			<a href="./ins?sv=update&ino=${ises.ino }"
				class="button button-postComment button--active">수정</a>&nbsp;&nbsp; 
				<a href="./ins?sv=remove&ino=${ises.ino }"
				class="button button-postComment button--active">삭제</a>
				&nbsp;&nbsp;
				</c:if>
				<a href="./product?sv=list"
				class="button button-postComment button--active">지원</a>&nbsp;&nbsp; <a href="ins?sv=list"
				class="button button-postComment button--active">목록</a>
		</div><br><br>
		<c:if test="${ses.mname eq ises.represent || ses.mid eq 'admin' }">
		<form>
			<input type="text" id="cmt" class="f"
				placeholder="Enter Your Comment" style="width:70%; margin-right : 10px;">

			<button class="btn btn-default" type="button" id="cmtBtn">
				입력</button>

		</form>
		</c:if>
		<table id="cmtList">

		</table>
		<div id="formTagZone"></div>
		</div>
		<script>
                                      	$(function(){
                                      		inoVal = '<c:out value="${ises.ino}"/>';
                                      		writerVal = '<c:out value="${ises.iname}"/>';
                                      		getlistComment(inoVal);
                                      	});
                                function getlistComment(inoVal){
    							$("#cmtList").html("");
    							$.ajax({
    								url:"./comment/list",
    								type:"post",
    								data:{ino:inoVal},
    								success: function(list){ //list -> String
    									let listObj = JSON.parse(list);
    									printListComment(listObj); //datatype = object
    								},
    								error:function(msg){
    								}
    							});
    						};
    						function printListComment(listObj){               
 				               for(let cvo of listObj){
 				                  let lis = '';
 				                  	lis += '<tr><td class="z1"></td> <td class="z2"></td> <td class="z3"></td>';
 				                  	lis += '<td><c:if test="${ses.mname eq ises.represent || ses.mid eq 'admin' }"><button class="rmBtn">삭제</button></c:if></td>';
 				                  	lis += '<td><input type="hidden" name="cnumber" class="z4"></td>';
 				                  	lis += '<td><input type="hidden" name="inumber" class="z5"></td></tr>'
 				                  $("#cmtList").append(lis);
 				                  
 				                  for(let key in cvo){
 				                     switch (key) {
 				                     case "writer":
 				                        $("#cmtList tr:last-child .z1").text('['+cvo[key]+']');
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
 				                    case "ino":
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
 							let inoVal = $(this).closest("tr").find(".z5").text();
 							$.ajax({
								url: "./comment/rm",
								type: "post",
								data: {cno:cnoVal},
								success: function(result){
									let res = parseInt(result);
									if(res>0){
										alert("댓글 삭제 완료");
										getlistComment(inoVal);
										$("#cmt").val("");
									}else{
										alert("댓글 삭제 실패! \n 관리자에게 문의하세요.")
									}
								},
								error: function(msg){
									alert(msg);
								}
							});
 							
 						
 						});
 						$("#cmtBtn").on("click",function(){
								let cmtVal = $("#cmt").val();
								$.ajax({
									url: "./comment/add",
									type: "post",
									data: {ino:inoVal, writer:writerVal, comment:cmtVal},
									success: function(result){
										let res = parseInt(result);
										if(res>0){
											alert("댓글 등록 완료");
											getlistComment(inoVal);
											$("#cmt").val("");
										}else{
											alert("댓글 등록 실패! \n 관리자에게 문의하세요.")
										}
									},
									error: function(msg){
										alert(msg);
									}
								});
							});
                                      	
                                      </script>
</section>
<!--================Blog Area =================-->