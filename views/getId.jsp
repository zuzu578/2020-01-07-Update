<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<meta charset="EUC-KR">
<title>Insert title here</title>
 <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Agency - Start Bootstrap Theme</title>
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/styles.css">

</head>
<style>
.find-id{
	width:700px;
	margin: 0 auto;
	margin-top:100px;
	
	
	
}
.nav-container2{
 display:flex;
 justify-content:center;
 border-bottom: 1px solid gray;
}
a{
	color:black;
	text-decoration: none;
}
.nav-items2{
	padding:20px;
	

}
.left{
	width:400px;
	
}
.main{
	display:flex;
	
}
.left-items{
	padding:20px;
	font-weight:bold;
	
}
.find-form{
	padding-top:30px;
	padding-bottom:50px;
}
</style>
<body>
  <nav class="nav-container2">
<div class="nav-items2"><a href="http://localhost:8080/project/home">메인으로 돌아가기</a> </div>
<div class="nav-items2"><a href="http://localhost:8080/project/Aboutus">About us</a> </div>
<div class="nav-items2"><a href="">그림 </a> </div>
<div class="nav-items2"><a href=""> 사진</a></div>
<div class="nav-items2"><a href="">공예</a> </div>
<div class="nav-items2"><a href="">음악</a> </div>
<div class="nav-items2"><a href="">게시판</a> </div>


</nav>
<div class="find-id">
<form action="ㅇ" method="POST">
<h1>아이디를 잊으셨다구요?</h1>
<h2>아이디를 찾기위해 이름과 이메일을 입력해주세요..!</h2>
<div class="find-form">
<div class="input-group mb-3">
  
  <input type="text" class="form-control" id="name" name="name" placeholder="여기에 이름을 입력해주세요!" aria-label="Username" aria-describedby="basic-addon1">
</div>


<div class="input-group mb-3">

  <input type="email" class="form-control" id="email"name="email"placeholder="여기에 이메일을 입력해주세요!" aria-label="Username" aria-describedby="basic-addon1">
</div>
<div class="buttons">
<button type="submit" id="submit" name="submit" class="btn btn-primary btn-lg">나의 아이디 찾기</button>
</div>
<div class="youridis">
	<p class="p-items"> 당신의 아이디는.. </p>
</div>

 <input type="email" class="form-control" id="id"name="email"placeholder="" aria-label="Username" aria-describedby="basic-addon1">


</div>
</form>
</div>
  
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="assets/mail/jqBootstrapValidation.js"></script>
        <script src="assets/mail/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>

</body>
</html>