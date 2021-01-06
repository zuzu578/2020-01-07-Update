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
	width:400px;
	
}
.main{
	display:flex;
	
}
.left-items{
	padding:20px;
	font-weight:bold;
	
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
<div class="nav-items2"><a href="">그림 </a> </div>
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
<a href="http://localhost:8080/project/myItems">등록한 작품</a>
</div>
<div class="left-items">
<a href="http://localhost:8080/project/myList">보관함</a>
</div>



</div>
<div class="center">
<form action="" method="POST">
	<table class="table table-striped" style="width:800px">
   		<tr><td algin=right>아아디</td> <td><input type="text" id="id"name="id"value='${modify_view.bId }'></td></tr>
    	<tr><td algin=right>비밀번호</td> <td><input type="password" id="passwd" name="passwd" value='${modify_view.bTitle }'></td></tr>
    	<tr><td algin=right>비밀번호 확인</td> <td><input type="password"id="password2"  name="password2"value='${modify_view.bName }'></td></tr>
    	<tr><td algin=right>이름</td> <td><input type="text"id="name"name="name"value='${modify_view.bName }'></td></tr>
    	<tr><td algin=right>성별</td><td><input type=radio value='f' id=female name=gender>여성
           				<input type=radio value='m' id=male name=gender>남성</td></tr>
    	<tr><td algin=right>이메일</td> <td><input type="text" id="email" name="email"value='${modify_view.bName }'></td></tr>
    	<tr><td algin=right>핸드폰</td> <td><input type="text" id="moblie" name="moblie"value='${modify_view.bName }'></td></tr>
    	<tr><td algin=right>주소</td> <td><input type="text" id="address" name="address"value='${modify_view.bName }'></td></tr>
    	
    </table>
    <div class="Buttons">
    <button type="submit" name="submit" id="submit" class="btn btn-success">수정하기</button>
    </div>
    </form>
    
    </div>
    </div>
    

</body>
</html>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script language="javascript">
var p2 = $("#password2").val();
var emailVal = $("#email").val();
var phoneVal = $("#mobile").val();
//var idVal = $("#userid").val();
var regPhone = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;
var regex = /^01\d\d{3,4}\d{4}$/;
var result = regex.exec($("#mobile").val());
var regExpId = /^[0-9a-z]+$/;
var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
var passRule = /^[A-Za-z0-9]{6,12}$/;//숫자와 문자 포함 형태의 6~12자리 이내의 암호 정규식

$(document)
.on("click","#submit",function(){
	if($("#id").val()==""){
		alert("아이디는 공백으로 둘수없습니다.");
		
		return false;
	}
	if(!/^[a-z0-9]{4,20}$/.test($("#id").val())) {
  		alert("아이디는 영 소문자, 숫자 4~20자리로 입력해주세요.");
  			return false;
	 }
	if($("#passwd").val()==""){
		alert("비밀번호는 공백을 둘 수없습니다.");
		return false;
	}
	
	if($("#passwd").val()!=$("#password2").val()){
		console.log(p2);
		alert("비밀번호 확인란에 있는 비밀번호와 일치하지 않습니다!");
		return false;
	}
	if(!passRule.test($("input[id='passwd']").val())) {
	    alert("비밀번호는 숫자와 문자 포함 형태의 6~12자리 이내로 설정해야합니다")
	 
	    return flase;
	}
	if($("#passwd").val()==""){
		alert("비밀번호는 공백을 둘 수없습니다.");
		return false;
	}
	
	if($("input[name=gender]:radio:checked").length<1){
		alert("성별을 선택해주세요.")
		return false;
	}
	if($("#mobile").val()==""){
		console.log(p2);
		alert("전화번호는 공백으로 둘수없습니다.");
		return false;
	}
	
	  // 입력 값이 000-0000-0000 형식인지 확인한다.
		var inputtedPhoneNumber = $("#mobile").val();
		var phoneNumberRegex = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;
	  if(!phoneNumberRegex.test(inputtedPhoneNumber)) {
		  alert("휴대폰번호를 하이픈(-) 포함해서 000-0000-0000 형식으로 입력해주세요..!)");
	    return false;
	  } 
	  
	  
	if($("#address").val()==""){
		console.log(p2);
		alert("주소를 입력해주세요.");
		return false;
	}
	
	
	if($("#name").val()==""){
		console.log(p2);
		alert("이름을 입력해주세요.");
		return false;
	}
	 if ($("#name").val().length <= 1) {
			alert("이름을 정확히 입력해주세요");
			return false;
		}
	 if($("#email").val()==""){
			alert("이메일은 공백으로 둘수없습니다.");
			return false;
		}
		if(emailVal.match(regExp) = null) {
		    alert("이메일형식에 어긋납니다.");
		    return false;
	  }
	
		 
	   
})
</script>