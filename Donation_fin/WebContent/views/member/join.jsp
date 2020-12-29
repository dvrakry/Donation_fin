<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Join</title>
	<link rel="icon" href="img/Fevicon.png" type="image/png">
  <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="vendors/fontawesome/css/all.min.css">
	<link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
	<link rel="stylesheet" href="vendors/linericon/style.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">

  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  
<section class="login_box_area section-margin">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login_box_img">
						<div class="hover">
							<h4>Already have an account?</h4>
							<p>There are advances being made in science and technology everyday, and a good example of this is the</p>
							<a class="button button-account" href="login.html">Login Now</a>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login_form_inner register_form_inner">
						<h3>Create an account</h3>
						<form action="./member" class="form-contact contact_form" action="contact_process.php" method="post" id="contactForm" novalidate="novalidate">
          					<input type="hidden" name="sv" value="join">
							<p><span id="isOk">회원가입</span></p>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" name="mid" id="input_mid" placeholder="아이디를 입력해주세요" required
								onfocus="this.placeholder = ''" onblur="this.placeholder = 'ID'">
              				</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" name="mname" id="mname" placeholder="이름을 입력해주세요" required 
								onfocus="this.placeholder = ''" onblur="this.placeholder = 'Name'">
							</div>
             				 <div class="col-md-12 form-group">
								<input type="password" class="form-control" name="mpwd" id="mpwd" placeholder="비밀번호를 입력해주세요" required
								onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
              				</div>
              				<div class="col-md-12 form-group">
								<input type="text" class="form-control" name="mphone" id="mphone" placeholder="연락처를 입력해주세요" required
								onfocus="this.placeholder = ''" onblur="this.placeholder = 'Phone Number'">
							</div>
							<div class="col-md-12 form-group">
								<div class="creat_account">
									<input type="checkbox" id="f-option2" name="selector">
									<label for="f-option2">Keep me logged in</label>
								</div>
							</div>
							<div class="col-md-12 form-group">
								<button type="submit" value="submit" class="button button-register w-100">회원가입</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<script>
	$("#input_mid").blur(function(){
		let midVal = $("#input_mid").val();
		$.ajax({
			url: './member?sv=check',
			type: 'POST',
			data: {mid:midVal},
			success: function(result){
				if(result == '0'){
					$("#isOk").html("사용가능한 아이디 입니다.").css("color", "green");
				}else{
					$("#isOk").html("사용 불가능한 아이디 입니다.").css("color", "red");
					$("input[name=mid]").focus();
				}
			}
		});
	});	
	</script>

  
  
	<!-- ================ contact section end ================= -->
  <!-- <script>
    $("#input_mid").blur(function(){
       let email = $("#input_mid").val();
       $.ajax({
          url: './member?sv=check',
          type: 'POST',
          data: {email:email},
          success: function(result){
             if(result == '0'){
                $("#isOk").html("사용가능한 이메일").css("color","green");
             }else{
                $("#isOk").html("사용불가능한 이메일").css("color","red");
                $("input[name=email]").focus();
             }
          }
       });
    });
    </script> -->
  





  <script src="vendors/jquery/jquery-3.2.1.min.js"></script>
  <script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
  <script src="vendors/skrollr.min.js"></script>
  <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
  <script src="vendors/nice-select/jquery.nice-select.min.js"></script>
  <script src="vendors/jquery.form.js"></script>
  <script src="vendors/jquery.validate.min.js"></script>
  <script src="vendors/contact.js"></script>
  <script src="vendors/jquery.ajaxchimp.min.js"></script>
  <script src="vendors/mail-script.js"></script>
  <script src="js/main.js"></script>
</body>
</html>