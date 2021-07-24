<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userInfo.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
	<main>
		<!-- main -->
		<div class="userinfo_wrap">
			<div class="title">마이페이지</div>
			<div class="info_nav_bar">
				<div class="info_nav_menu">마이페이지 홈</div>
				<div class="info_nav_menu">회원 정보 수정</div>
				<div class="info_nav_menu">비밀번호 변경</div>
				<div class="info_nav_menu">신청내역</div>
				<div class="info_nav_menu">관심내역</div>
			</div>
			<div class="info_section">
				<div class="info_img" style="background-image: url('/img/01.jpg');"></div>
				<div class="info_items">
					<div class="info_item">
						<div class="item_title">이름</div>
						<div class="item_content">
							<input type="text" value="최혜은" readonly>
						</div>
					</div>
					<div class="info_item">
						<div class="item_title">이메일</div>
						<div class="item_content">
							<input type="text" value="jampbook@naver.com" readonly>
						</div>
					</div>
					<div class="info_item">
						<div class="item_title">번호</div>
						<div class="item_content">
							<input type="text" value="010-7167-4987" readonly>
						</div>
					</div>
					<div class="info_item">
						<div class="item_title">가입일</div>
						<div class="item_content">
							<input type="text" value="1994-02-25" readonly>
						</div>
					</div>
				</div>
			</div>
			<div class="res_section"></div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>