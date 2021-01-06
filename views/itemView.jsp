<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="https://kit.fontawesome.com/8c9485b50e.js" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<style>
*{ padding:0; margin:0; list-style: none;}
.clear {clear: both;}
.main-contents{
	width:1000px;
	margin:0 auto;
	margin-top:45px;
}
.nav-container2{
 font-weight: bold;
 display:flex;
 justify-content:center;
 border-bottom: 1px solid gray;
 align-items:center;
}
a{
	color:black;
	text-decoration: none;
}
.nav-items2{
	padding:20px;
}
.nav-items{
	text-align:left;
}
.nav-items img{
	width:100%;
}
#section {margin: 10px;}
#button {float: right; margin-bottom: 30px;}
#gallery {width: 1000px; margin: 0 auto;}
#gallery ul {float: left;}
#image {width: 300px; height: 200px;}

</style>


<title>Item View</title>
</head>
<body>
<div id="wrap">
	<div id="header">
		<nav class="nav-container2">
			<div class="nav-items"><a href="./home"><img src="https://www.freelogodesign.org/file/app/client/thumb/a5ae1939-7ab5-4c73-954e-91a6a7299dd3_200x200.png?1609120650640"></a> </div>
			<div class="nav-items2"><a href="">About us</a> </div>
			<div class="nav-items2"><a href="./pageCount?category=paint&pageNum=1">그림 </a> </div>
			<div class="nav-items2"><a href="./pageCount?category=photo&pageNum=1">사진</a></div>
			<div class="nav-items2"><a href="./pageCount?category=handi&pageNum=1">공예</a> </div>
			<div class="nav-items2"><a href="./pageCount?category=music&pageNum=1">음악</a> </div>
			<div class="nav-items2"><a href="./board">게시판</a> </div>
		</nav>
	</div>
	<div id="section">
		<div id="button">
			<a href="./itemAdd"><button type="button" class="btn btn-success">작품등록하기</button></a>
		</div>
		<div id="gallery" class="clear">
			<%-- <c:forEach items="${itemView}" var="dto">
			<ul>
				<li><img src="${dto.file_dir}"></a></li>
				<li>제목 : ${dto.itemtopic}</li>
			</ul>
			</c:forEach> --%>
			<c:forEach items="${itemView}" var="dto">
			<ul>
				<li><figure class="figure">
				<a href="./itemClickView?item_num=${dto.item_num}">
				<img src="${dto.file_dir}" id="image" class="figure-img img-fluid rounded" alt="...">
				</a>
				<figcaption class="figure-caption">${dto.itemtopic}</figcaption>
			</figure></li>
			</ul>
			</c:forEach>
			<div id="paging" class="clear">
				<a href="./pageCount?category=${category}&pageNum=${pageNum-1}"><input type="button" id="btnPrev" value="이전"></a>
				<c:forEach var="num" begin="1" end="${pageLastNum}" step="1">
					<a href="./pageCount?category=${category}&pageNum=${num}">${num}</a>
				</c:forEach>
				<a href="./pageCount?category=${category}&pageNum=${pageNum+1}"><input type="button" id="btnNext" value="다음"></a>
			</div>
		</div>
	</div>
</div>
</body>
<script>
$(document)
.on('click','#btnPrev',function(){
	if(${pageNum}==1){
		alert("첫 페이지입니다");
		return false;
	}
})
.on('click','#btnNext',function(){
	if(${pageNum}==${pageLastNum}){
		alert("마지막 페이지입니다");
		return false;
	}
})

</script>
</html>