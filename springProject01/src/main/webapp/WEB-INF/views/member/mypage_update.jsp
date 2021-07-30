<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/userInfo.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
	<main>
		<form action="${pageContext.request.contextPath}/member/mypage_update">
		<!-- main -->
		<div class="userinfo_wrap">
			<div class="title">${sessionID }님의 마이페이지</div>
			<div class="info_nav_bar">
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage">마이페이지 홈</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_update">회원정보 수정</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage">비밀번호 변경</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage">신청 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage">관심 내역</a></div>
			</div>
			<div class="info_section">
				<div class="info_img"
					style="background-image: url('${pageContext.request.contextPath}/img/01.jpg');"></div>
				<div class="info_items">
					<div class="info_item">
						<div class="item_title">이름</div>
						<div class="item_content">
							<input type="text" value="${lhj_MemberVO.m_name }" readonly>
						</div>
					</div>
					<div class="info_item">
						<div class="item_title">이메일</div>
						<div class="item_content">
							<input type="text" value="${lhj_MemberVO.m_id }" readonly>
						</div>
					</div>
					<div class="info_item">
						<div class="item_title">번호</div>
						<div class="item_content">
							<input type="text" value="${lhj_MemberVO.m_tel }" readonly>
						</div>
					</div>
					<div class="info_item">
						<div class="item_title">가입일</div>
						<div class="item_content">
							<input type="text" value="${lhj_MemberVO.m_regdate }" readonly>
						</div>
					</div>
				</div>
			</div>
			<div class="res_section"></div>
		</div>
		</form>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>