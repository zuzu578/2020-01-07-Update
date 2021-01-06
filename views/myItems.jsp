<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<meta charset="EUC-KR">
<style>
*{
padding:0;
margin:0;

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
	width:200px;
	border-right:1px solid gray;
	height:500px;
	
}
.main{
	display:flex;
	
}
.left-items{
	padding:20px;
	font-weight:bold;
	
	
}
.center{
	padding:20px;
	width:1000px;
	
	
}
.goods{
	padding-top:10px;
	font-weight:bold;
	color:orange;
	border-top:2px solid gray;
	border-bottom:2px solid gray;
	
	
}

</style>
<title>Insert title here</title>
</head>


<body>
<nav class="nav-container">
<div class="nav-items"> </div>


</nav>
<nav class="nav-container2">
<div class="nav-items2"><a href="http://localhost:8080/project/home">메인으로 돌아가기</a> </div>
<div class="nav-items2"><a href="">About us</a> </div>
<div class="nav-items2"><a href="http://localhost:8080/project/paint">그림 </a> </div>
<div class="nav-items2"><a href=""> 사진</a></div>
<div class="nav-items2"><a href="">공예</a> </div>
<div class="nav-items2"><a href="">음악</a> </div>
<div class="nav-items2"><a href="">게시판</a> </div>


</nav>
<div class="main">
<div class="left">
<div class="left-items">
<a href="http://localhost:8080/project/myInfo">회원정보</a>
</div>
<div class="left-items">
<a href="http://localhost:8080/project/myList">등록한 작품</a>
</div>
<div class="left-items">
<a href="http://localhost:8080/project/myItems">보관함</a>
</div>



</div>
<div class="center">
	<div class="myinventory">
	<h1>보관함</h1>
	<div class="goods">
		<div class="paint-items"> 찜</div>
	
	</div>
	
	<div class="goods">
		<div class="picture-items"> 구매내역</div>
	
	</div>
	
	<div class="goods">
		<div class="music-items">판매내역</div>
	
	</div>
	
	
	
	</div>
    
    </div>
    </div>
    

</body>
</html>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script language="javascript">