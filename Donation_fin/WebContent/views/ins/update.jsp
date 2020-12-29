<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section class="login_box_area section-margin">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="login_form_inner register_form_inner">
						<h3>Institution Register</h3>
						<form class="row login_form" action="./ins?sv=modify" id="register_form" method="post" enctype="multipart/form-data" >
							<input type="hidden" name="ino" value="${ivo.ino }">
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="name" name="iname" value="${ivo.iname }" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="loc" name="loc" value="${ivo.loc }" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email Address'">
              </div>
              <div class="col-md-12 form-group">
								<input type="text" class="form-control" id="ipeople" name="ipeople" value="${ivo.ipeople }" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
              </div>
              <div class="col-md-12 form-group">
              					<textarea rows="7" cols="60" name="icnt" >${ivo.icnt }</textarea>
							</div>
							<div class="col-md-12 form-group">
								<div class="creat_account">
									<input type="file" id="imgfile" name="imgfile">
								</div>
							</div>
							<div class="col-md-6 form-group">
								<button type="submit" class="button button-register w-100">수정하기</button>
								<button type="reset" class="button button-register w-100">작성초기화</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>