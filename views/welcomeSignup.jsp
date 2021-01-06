<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
.signup-success{
	text-align:center;
}
.images

.images img{
 	width:10%;
 	
 }
a { text-decoration:none !important }
 a:hover { text-decoration:none !important }
 a{color:white}
 .buttons-items{
 	margin-top:100px;
 	
 }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<title>회원가입 완료!</title>
</head>

<body>
<div class="signup-success">
<h1>회원가입에 성공했습니다!</h1>
	<div class="success-infor">
		<h4>회원님 회원가입을 진심으로 축하드립니다. 이제부터 다양한 기능들을 이용하실수 있게 되었습니다.</h4>
	</div>
	<div class="images">
		<img src="https://www.flaticon.com/kr/premium-icon/icons/svg/2143/2143252.svg">
	
	</div>
	<div class="buttons-items">
	<button type="button" class="btn btn-dark"><a href="http://localhost:8080/project/login">로그인 하러가기</a></button>
	<button type="button" class="btn btn-info"><a href="http://localhost:8080/project/home">메인 페이지로 이동하기</a></button>
		</div>

</div>
</body>
</html>