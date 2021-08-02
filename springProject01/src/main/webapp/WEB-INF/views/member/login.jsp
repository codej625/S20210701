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
</head>
<body onload="bodyOnload()">
<!-- 	<form action="userLoginPro.do" method="post"> -->
	<form action="${pageContext.request.contextPath}/member/login" method="post">
		<div class="header_top">
			<div class="logo_section">
				<img src="${pageContext.request.contextPath}/img/logo.png">
			</div>
			<div class="nav_bar">
				<div class="nav_header">
					<ul>
						<c:if test="${sessionID == null}">
							<li><a href="login">로그인</a></li>
							<li><a href="${pageContext.request.contextPath}/member/join">회원가입</a></li>
						</c:if>
						<li>${sessionID }회원님</li>
						<c:if test="${sessionID != null }">
<!-- 							<li><input type="submit" value="로그아웃"></li> -->
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
							<a href="findUserIdForm.do">아이디 찾기</a> <a href=findUserPwForm.do>비밀번호 찾기</a>
						</div>
					</div>
					<div class="input_item">
						<button class="default_bt login_bt" type="submit" id="">로그인</button>
					</div>
				</div>
			</div>
					<div style="padding-top: 10px">
						<img src="${pageContext.request.contextPath}/img/kakao_login_medium_wide.png" style="width: 450px", height="63px">
					</div>
		</div>
	</form>
</html>