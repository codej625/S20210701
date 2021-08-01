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
		<form action="${pageContext.request.contextPath}/member/mypage">
		<!-- main -->
		<div class="userinfo_wrap">
			<div class="title">${lhj_MemberVO.m_name }님의 마이페이지</div>
			<div class="info_nav_bar">
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage">마이페이지 홈</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_update">회원정보 수정</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_changePW">비밀번호 변경</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_myreginfo">신청 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_mybookmark">관심 내역</a></div>
			</div>
			<div class="info_section">
				<div class="info_img"
					style="background-image: url('${pageContext.request.contextPath}/img/01.jpg');">
<%-- 					나중에 여기에 프로필 이미지 넣을 거임 저장경로 + ${lhj_MemberVO.m_proimg } 이런식 --%>
				</div>
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
					<div>
						<input type="submit" value="확인">
						<input type="reset" value="취소">
					</div>
				</div>
			</div>
			<div class="info_section">
				여기에 캘린더 api가 들어갈 예정
			</div>
			<div class="res_section"></div>
		</div>
		</form>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>