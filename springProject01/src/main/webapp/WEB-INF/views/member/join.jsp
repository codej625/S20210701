<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/5b4294bd03.js" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@700&family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumSquare@1.0/nanumsquare.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/joinStyle.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/foot.css"/>
</head>
<body onload="bodyOnload()">
	<form action="${pageContext.request.contextPath}/members/join" method="post">
        <div class="header_top">
            <div class="logo_section">
            	<a href="${pageContext.request.contextPath}/main/main"><img src="${pageContext.request.contextPath}/img/logo.png"></a></div>
            <div class="nav_bar">
                <div class="nav_header">
                    <ul>					
						<c:if test="${sessionID == null}">
							<li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
							<li><a href="${pageContext.request.contextPath}/member/join">회원가입</a></li>
						</c:if>
						<c:if test="${sessionID != null }">
							<li>${sessionID }회원님</li>
								<li><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
						</c:if>
						<li><a href="고객센터">고객센터</a></li>
                </div>
            </div>
        </div>
		<div class="login_page">
			<div class="login_section">
				<div class="login_title">회원가입</div>
				<div class="login_input_section">
					<div class="input_title">필수정보</div>
					<div class="input_item">
						<input type="text" name="m_id" placeholder="아이디" required="required">
					</div>
					<div class="input_item">
						<input type="password" name="m_pw" placeholder="비밀번호" required="required">
					</div>
<!-- 					<div class="input_item"> -->
<!-- 						<input type="password" name="m_pw" placeholder="비밀번호확인" required="required"> -->
<!-- 					</div> -->
					<div class="input_item">
						<input type="password" name="m_name" placeholder="이름" required="required">
					</div>
					<div class="input_item">
						<input type="text" name="m_tel" placeholder="휴대폰 번호" required="required">
					</div>
					<div class="input_title">관심정보</div>
					<div class="input_item">
						<input type="text" name="m_area" placeholder="지역" required="required">
					</div>
					<div class="input_item">
						<input type="text" name="m_field" placeholder="분야" required="required">
					</div>
					<div class="input_title">약관동의</div>
					<div class="agree_form">
						<p>
							약관동의 블라블라<br/>
							가입완료시 동의한 것으로 간주<br/>
						</p>
					</div>
					<div class="input_item">
						<button class="default_bt join_bt" type="submit"> 가입 </button>
					</div>
				</div>
			</div>
		</div>
		 <!-- **FOOTER START** -->
    <footer>
        <div class=footer>
            <div class="company_info">
                <ul>
                    <li>(주)모꼬지(대표이사:중앙정보처리)</li>
                    <li>주소 : 서울특별시 어쩌고 저쩌고</li>
                    <li>대표번호 : 02-1234-5678</li>
                    <li>고객센터 : abcd@efg.com</li>
                </ul>
            </div>
            <div class="ft_copyright">Copyright@Moggogi co., Ltd. All rights reserved</div>
        </div>
    </footer>
	</form>