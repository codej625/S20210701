<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/main/script.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
</head>
<body>
	<header>
		<!-- header_top -->
		<div class="header_top">
			<div class="logo_section">
				<img src="${pageContext.request.contextPath}/img/logo.png">
			</div>
			<div class="search_section">
				<input type="text" placeholder="원하는 모임을 검색해보세요!" /> <i
					class="fas fa-search fa-2x"></i>
			</div>
			<div class="nav_bar">
				<div class="nav_header">
					<ul>
						<li>로그인</li>
						<li>회원가입</li>
						<li>회원님</li>
						<li>로그아웃</li>
						<li>고객센터</li>
					</ul>
				</div>
				<div class="nav_menu">
					<div class="nav_detail">
						<i class="far fa-id-card fa-3x"></i><br /> <a>마이페이지</a>
					</div>
					<div class="nav_detail">
						<i class="far fa-list-alt fa-3x"></i><br /> <a>모임개설</a>
					</div>
					<div class="nav_detail">
						<i class="far fa-bell fa-3x"></i><br /> <a>알림</a>
					</div>
				</div>
			</div>
		</div>
		<!-- header_bottom -->
		<div class="header_bottom">
			<div class="filter_blank"></div>
			<div class="filter_deco">
				<i class="fas fa-angle-right fa-2x"></i>
			</div>
			<div class="filter_item">
				모임
				<ul class="select_box">
					<li>게임/만화/애니</li>
					<li>영화/음악/그림</li>
					<li>스포츠/레저</li>
					<li>반려동물</li>
					<li>패션/미용</li>
					<li>건강/다이어트</li>
					<li>가족/육아</li>
					<li>컴퓨터/통신</li>
					<li>외국어/인문/과학</li>
					<li>경제/금융/정치/사회</li>
					<li>문학/창작</li>
					<li>기타</li>
				</ul>
			</div>
			<div class="filter_item">
				클래스
				<ul class="select_box">
					<li>게임/만화/애니</li>
					<li>영화/음악/그림</li>
					<li>스포츠/레저</li>
					<li>반려동물</li>
					<li>패션/미용</li>
					<li>건강/다이어트</li>
					<li>가족/육아</li>
					<li>컴퓨터/통신</li>
					<li>외국어/인문/과학</li>
					<li>경제/금융/정치/사회</li>
					<li>문학/창작</li>
					<li>기타</li>
				</ul>
			</div>
		</div>
	</header>
</body>
</html>