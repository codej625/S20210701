<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/main/script.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/loginStyle.css" />
<script type="text/javascript">
	
	function find_m_id(){
		var url="${pageContext.request.contextPath}/member/find_m_id";
		window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
	}
	function find_m_pw(){
		var url="${pageContext.request.contextPath}/member/find_m_pw";
		window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
	}

</script>
<!-- 카카오 로그인 --> 
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script> 
<script type="text/javascript"> 
	//초기화 시키기. 
	$(document).ready(function(){ Kakao.init('자바스크립트 앱키 입력'); 
	Kakao.isInitialized(); }); 
	
	function loginWithKakao() { 
		Kakao.Auth.authorize({ 
			redirectUri: 'http://localhost:8080/user/loginpage_kakao_callback' 
			}); 
		}
	
</script>

</head>
<body onload="bodyOnload()">
<!-- 	<form action="userLoginPro.do" method="post"> -->
	<form action="${pageContext.request.contextPath}/member/login" method="post">
		<div class="header_top">
			<div class="logo_section">
				<a href="${pageContext.request.contextPath}/main/main"><img src="${pageContext.request.contextPath}/img/logo.png"></a>
			</div>
			<div class="nav_bar">
				<div class="nav_header">
					<ul>
						<c:if test="${sessionID == null}">
							<li><a href="login">로그인</a></li>
							<li><a href="${pageContext.request.contextPath}/member/join">회원가입</a></li>
						</c:if>
						<c:if test="${sessionID != null }">
							<li>${sessionID }회원님</li>
<!-- 						<li><input type="submit" value="로그아웃"></li> -->
							<li><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
						</c:if>
						<li><a href="고객센터">고객센터</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="auth_page">
			<div class="login_section">
				<div class="auth_title">로그인</div>
				<div class="auth_input_section">
					<div class="input_item">
						<input type="text" name="m_id" placeholder="아이디" required="required">
					</div>
					<div class="input_item">
						<input type="password" name="m_pw" placeholder="비밀번호" required="required">
					</div>
					<div class="input_item2">
						<div class="save_id">
							<input type="checkbox" />아이디저장
						</div>
						<div class="search_info">
<%-- 							<a href="${pageContext.request.contextPath}/member/find_m_id">아이디 찾기</a>  --%>
							<a onclick="find_m_id()">아이디 찾기</a> 
<!-- 							<a href=findUserPwForm.do>비밀번호 찾기</a> -->
							<a onclick="find_m_pw()">비밀번호 찾기</a>
						</div>
					</div>
					<div class="input_item">
						<button class="default_bt login_bt" type="submit" id="">로그인</button>
					</div>
				</div>
			</div>
					<div style="padding-top: 10px">
						<img src="${pageContext.request.contextPath}/img/kakao_login_medium_wide.png" style="width: 450px", height="63px" onclick="loginWithKakao()">
					</div>
		</div>
	</form>
</html>