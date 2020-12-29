<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="login_box_area section-margin">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="login_form_inner register_form_inner">
					<h3>Institution Register</h3>
					<form class="row login_form" action="./ins?sv=reg"
						id="register_form" method="post" enctype="multipart/form-data">
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="name" name="iname"
								placeholder="시설이름" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Username'">
						</div>
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="represent" name="represent"
								placeholder="시설대표자" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Represent'">
						</div>
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="loc" name="loc"
								placeholder="주소" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Location'">
						</div>
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="ipeople"
								name="ipeople" placeholder="시설 인원"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'People'">
						</div>
						<div class="col-md-12 form-group">
							<textarea rows="7" cols="60" name="icnt" placeholder="시설내용"></textarea>
						</div>
						<div class="col-md-12 form-group">
							<div class="creat_account">
								<input type="file" id="imgfile" name="imgfile">
							</div>
						</div>
						<div class="col-md-12 form-group">
							<button type="submit" class="button button-register w-100">Register</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>