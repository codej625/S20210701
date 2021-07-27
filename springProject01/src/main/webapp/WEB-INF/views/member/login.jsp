<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/main/script.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/loginStyle.css" />
</head>
<body onload="bodyOnload()">
	<form action="${pageContext.request.contextPath}/member/login" method="post">
		<div class="header_top">
			<div class="logo_section">
				<a href="${pageContext.request.contextPath}/main/main"><img src="${pageContext.request.contextPath}/img/logo.png"></a>
			</div>
			<div class="nav_bar">
				<div class="nav_header">
					<ul>
						<li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
						<li><a href="${pageContext.request.contextPath}/member/join">회원가입</a></li>
						<li>고객센터</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="auth_page">
			<div class="login_section">
				<div class="auth_title">로그인</div>
				<div class="auth_input_section">
					<div class="input_item">
						<input type="text" name="m_id" placeholder="아이디"
							required="required">
					</div>
					<div class="input_item">
						<input type="password" name="m_pw" placeholder="비밀번호"
							required="required">
					</div>
					<div class="input_item2">
						<div class="save_id">
							<input type="checkbox" />아이디저장
						</div>
						<div class="search_info">
							<a href="findUserIdForm.do">아이디 찾기</a> <a href=findUserPwForm.do>비밀번호
								찾기</a>
						</div>
					</div>
					<div class="input_item">
						<button class="default_bt login_bt" type="submit">로그인</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</html>