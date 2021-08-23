<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@include file="/WEB-INF/views/main/script.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>네이버 로그인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- 카카오 로그인 --> 
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css"/>
<style>
</style>
</head>
<body>

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">

function passConfirm() {
	var password = document.getElementById('m_pw');					//비밀번호 
	var passwordConfirm = document.getElementById('m_re_pw');	//비밀번호 확인 값
	var confrimMsg = document.getElementById('confirmMsg');				//확인 메세지
	var correctColor = "#269F70";	//맞았을 때 출력되는 색깔.
	var wrongColor ="#CC3D3D";	//틀렸을 때 출력되는 색깔
	
	if(password.value == passwordConfirm.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
		confirmMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
		confirmMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
	}else{
		confirmMsg.style.color = wrongColor;
		confirmMsg.innerHTML ="비밀번호 불일치";
	}
}

	function kakaoLogin() {
		
// 		var m_id =  joinForm.m_id.value;
// 		var m_name = joinForm.m_name.value;
// 		alter("m_id"+m_id);
// 		alter("m_name"+m_name)
		
		$.ajax({
			url:"${pageContext.request.contextPath}/member/kakaojoin",  
			data:{
// 				m_id : m_id , m_name : m_name, 
				m_tel : joinForm.m_tel.value
				, m_pw : joinForm.m_pw.value},
			type: 'POST',
		    dataType:'text',
		    success:function(data){
		    	alert("회원가입 되었습니다.");
		        window.opener.location.href="${pageContext.request.contextPath}/main/main";
		        	self.close();
		    }
		});		
	
	}

</script>

	<form action="${pageContext.request.contextPath}/member/kakaojoin" method="post" name="joinForm">
	<div class="find_div">
		<input type="hidden" id="m_id" name="m_id" value="${m_id }">
		<input type="hidden" id="m_name" name="m_name" value="${m_name }">
		<input type="text" id="m_tel" name="m_tel" placeholder="전화번호" required="required" class="find_text"></br>
		<input type="text" id="m_pw" name="m_pw" placeholder="비밀번호" required="required" class="find_text"><br>
		<input type="text" id="m_re_pw" name="m_re_pw" placeholder="비밀번호 확인" required="required" onkeyup="passConfirm()">
		<input type="submit" onclick="kakaoLogin()" value="확인" class="sub_btn"><br>
		<span id ="confirmMsg"></span> 
	</div>
	</form>

</body>
</html>