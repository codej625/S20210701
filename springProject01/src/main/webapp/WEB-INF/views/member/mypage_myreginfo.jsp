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
		<!-- main -->
		<div class="userinfo_wrap">
			<div class="title">${lhj_MemberVO.m_name }님의 마이페이지</div>
			<div class="info_nav_bar">
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage">마이페이지 홈</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_update">회원정보 수정</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_changePW">비밀번호 변경</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_myreginfo">신청 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_mybookmark">관심 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_deleteMyself">회원 탈퇴</a></div>
			</div>
			<div class="info_section">
				<table class="myreginfo_table">
				<c:forEach var="lhj_MemberVO" items="${myRegInfoList }">
					<tr>
						<c:if test="${lhj_MemberVO.p_img == null}">
							<td>
								<img src="${pageContext.request.contextPath}/img/goya.jpg" width="250px">
							</td>
						</c:if>
						<c:if test="${lhj_MemberVO.p_img != null}">
							<td>
								${lhj_MemberVO.p_img }
							</td>
						</c:if>
						<td>${lhj_MemberVO.p_title }</td>
						<td id="myreginfo_table_td2">${lhj_MemberVO.p_cstatus }</td>
						<c:if test="${lhj_MemberVO.ri_pstatus == 'N'}">
							<td>결제 하기 버튼</td>
						</c:if>
						<c:if test="${lhj_MemberVO.ri_pstatus == 'Y'}">
							<td>결제 취소 버튼</td>
						</c:if>
						<td>
						<form action="${pageContext.request.contextPath}/member/mypage_myreginfoDE">
							<input type="hidden" name="m_id" value="${lhj_MemberVO.m_id }">
							<input type="hidden" name="bt_num" value="${lhj_MemberVO.bt_num }">
							<input type="hidden" name="bc_num" value="${lhj_MemberVO.bc_num }">
							<input type="hidden" name="p_num" value="${lhj_MemberVO.p_num }">
							
							<input type="submit" value="신청 취소">
						
						</form>
						</td>
					</tr>
				</c:forEach>	
				</table>
			</div>
			<div class="res_section"></div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>