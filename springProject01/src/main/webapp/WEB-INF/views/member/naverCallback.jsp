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
<style>
</style>
</head>
<body>

<script type="text/javascript">
	var naver_id_login = new naver_id_login("6afzdjusqprAB9msW6OV", "http://localhost:8181/springProject01/member/naverCallback");
	// 접근 토큰 값 출력
	alert(naver_id_login.oauthParams.access_token);
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
    
	  //걍 잘 가져오는지 확인하는거임
    alert(naver_id_login.getProfileData('email'));
    alert(naver_id_login.getProfileData('name'));

  }
  
  /* 자바 스크립트 함수 선언(비밀번호 확인) */
	function passConfirm() {
	/* 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치, 그렇지 않으면 불일치 라는 텍스트 출력.*/
	/* document : 현재 문서를 의미함. 작성되고 있는 문서를 뜻함. */
	/* getElementByID('아이디') : 아이디에 적힌 값을 가진 id의 value를 get을 해서 password 변수 넣기 */
		var password = document.getElementById('m_pw');					//비밀번호 
		var passwordConfirm = document.getElementById('m_re_pw');	//비밀번호 확인 값
		var confrimMsg = document.getElementById('confirmMsg');				//확인 메세지
		var correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
		var wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
		
		if(password.value == passwordConfirm.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
			confirmMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
			confirmMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
		}else{
			confirmMsg.style.color = wrongColor;
			confirmMsg.innerHTML ="비밀번호 불일치";
		}
	}
  
  function naverlogin() {
	
	  var m_id = naver_id_login.getProfileData('email');   
//    var m_gender = naver_id_login.getProfileData('gender');   
//    var m_email = naver_id_login.getProfileData('email');
	   var m_name = naver_id_login.getProfileData('name');
// 	   var m_tel = naver_id_login.getProfileData('email');
// 	   var m_pw = naver_id_login.getProfileData('email');
	  
	  $.ajax({
//	       url:"${pageContext.request.contextPath}/members/join", 
			url:"${pageContext.request.contextPath}/member/Naverjoin",  
//	       data:{m_id : m_id , m_email : m_email},
			data:{m_id : m_id , m_name : m_name
				, m_tel : joinForm.m_tel.value
				, m_pw : joinForm.m_pw.value},
			 type: 'POST',
	      dataType:'text',
	      success:function(data){
	          alert("로그인 되었습니다.");
	          window.opener.location.href="${pageContext.request.contextPath}/main/main";
	            self.close();
	      }
	   });
	  
}
</script>
	<form action="${pageContext.request.contextPath}/members/join" method="post" name="joinForm">
	<div>
		<input type="text" id="m_tel" name="m_tel" placeholder="전화번호" required="required"></br>
		<input type="text" id="m_pw" name="m_pw" placeholder="비밀번호" required="required"><br>
		<input type="text" id="m_re_pw" name="m_re_pw" placeholder="비밀번호 확인" required="required" onkeyup="passConfirm()"><br>
		<span id ="confirmMsg"></span> 
		<input type="submit" onclick="naverlogin()" value="확인"> 
	</div>
	</form>

</body>
</html>