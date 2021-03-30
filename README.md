# JSP 팀 프로젝트

[개발의도]

    제작목적

    기부를 원하는 회원과 기부가 필요한 시설을 연결해주는 홈페이지의 필요성을 느껴 제작하였습니다.

    
    작업환경
 
    ECLIPSE, JSP, JAVA, JAVASCRIPT, HTML5, CSS3, MySQL 
    

[개발개요]

    회원 관련 파트 와 감사 인사 게시판 작업을 수행했습니다.


[메인화면]
![메인](https://user-images.githubusercontent.com/74029610/111068945-1eefcb00-850e-11eb-9ed3-eb38d7be6581.JPG)

[로그인 화면]
![로그인](https://user-images.githubusercontent.com/74029610/111069042-80179e80-850e-11eb-8b4c-9e348c124f11.JPG)

>회원가입 아이디 중복검사 SCRIPT
 ```java
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
```

[감사게시판]
![감사게시판 글작성](https://user-images.githubusercontent.com/74029610/111069058-9887b900-850e-11eb-8568-bdda0c38f9f5.JPG)

[구매내역]
![구매내역](https://user-images.githubusercontent.com/74029610/111069069-ac331f80-850e-11eb-8c7b-a089e8985cc3.JPG)
