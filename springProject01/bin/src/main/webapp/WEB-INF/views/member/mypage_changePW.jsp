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
		<form action="${pageContext.request.contextPath}/member/mypage_changePW" method="post">
		<!-- main -->
		<div class="userinfo_wrap">
			<div class="title">${lhj_MemberVO.m_name }님의 마이페이지</div>
			<div class="info_nav_bar">
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage">마이페이지 홈</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_update">회원정보 수정</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_mycertification">인증</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_myPostList">내가 쓴 글</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_myreginfo">신청 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_mybookmark">관심 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_changePW">비밀번호 변경</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_deleteMyself">회원 탈퇴</a></div>
			</div>
			<div class="info_section">
				<div class="info_items">
					<div class="info_item">
						<div class="item_title">비밀번호</div>
						<div class="item_content">
							<input type="hidden" value="${lhj_MemberVO.m_id }" name="m_id">
							<input type="hidden" value="${lhj_MemberVO.m_name }">
							<input type="text" value="${lhj_MemberVO.m_pw }" name="m_pw">
						</div>
					</div>
				</div>	
				<div>
						<input type="submit" value="수정">
						<input type="reset" value="취소">
					</div>
			</div>
			<div class="res_section"></div>
		</div>
		</form>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>