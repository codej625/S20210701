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

	<form action="${pageContext.request.contextPath}/members/join" method="post" name="joinForm">
	<div>
		<input type="text" id="m_tel" name="m_tel" placeholder="전화번호" required="required"></br>
		<input type="text" id="m_pw" name="m_pw" placeholder="비밀번호" required="required"><br>
		<input type="text" id="m_re_pw" name="m_re_pw" placeholder="비밀번호 확인" required="required" onkeyup="passConfirm()"><br>
		<span id ="confirmMsg"></span> 
		<input type="submit" onclick="naverlogin()" value="확인"> 
	</div>
	</form>
<script type="text/javascript">
	//카카오
	window.Kakao.init("e2fd8d66aec38708604ef29d89508490");
	
	function naverlogin() {
	   window.Kakao.Auth.login({
	      scope: 'profile_nickname, account_email',
	      success: function(authObj) {
	         console.log(authObj);
	         window.Kakao.API.request({
	            url: '/v2/user/me',
	            success: res => {
	               const Kakao_account = res.kakao_account;
	               console.log('authObj-->', authObj);
	               console.log('Kakao_account-->', Kakao_account);
	               console.log('Kakao_account-->', Kakao_account_email);
	
	               var m_id = Kakao_account.email;
// 	               var m_name = Kakao_profile_nickname;
	
	               $.ajax({
	            	   url:"${pageContext.request.contextPath}/member/Naverjoin",
	                  data: {m_id : m_id },
	                  dataType: 'text',
	                  success:function(data){
	        	          alert(data);
	        	          window.opener.location.href="${pageContext.request.contextPath}/main/main";
	        	            self.close();
	        	      }
	               });
	
	
	            }
	         });
	      }
	   });
	}

</script>

</body>
</html>