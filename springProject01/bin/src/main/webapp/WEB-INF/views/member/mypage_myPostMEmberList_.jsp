<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/userInfo.css" />
<script>


</script>

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
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_mycertification">인증</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_myPostList">내가 쓴 글</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_myreginfo">신청 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_mybookmark">관심 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_changePW">비밀번호 변경</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_deleteMyself">회원 탈퇴</a></div>
			</div>
			<div class="info_section">
				<table class="myreginfo_table" border="1">
				<c:forEach var="lhj_MemberVO" items="${mypage_myPostMEmberList }">
					<tr>
						<td rowspan="2">
						<c:if test="${lhj_MemberVO.m_img == null}">
								<img src="${pageContext.request.contextPath}/img/goya.jpg" width="250px">
							
						</c:if>
						<c:if test="${lhj_MemberVO.m_img != null}">
								<img src="${pageContext.request.contextPath}/upload/${lhj_MemberVO.m_img }">
						</c:if>
						</td>
						<td>
							${lhj_MemberVO.m_name }
						</td>
						<td rowspan="2">
							<c:if test="${lhj_MemberVO.ri_pstatus == 'N'}">
								미결제
							</c:if>
							<c:if test="${lhj_MemberVO.ri_pstatus == 'Y'}">
								결제 완료
							</c:if>
							<form action="${pageContext.request.contextPath}/member/mypage_myreginfoDE">
								<input type="hidden" name="m_id" value="${lhj_MemberVO.m_id }">
								<input type="hidden" name="bt_num" value="${lhj_MemberVO.bt_num }">
								<input type="hidden" name="bc_num" value="${lhj_MemberVO.bc_num }">
								<input type="hidden" name="p_num" value="${lhj_MemberVO.p_num }">
								
								<input type="submit" value="신청 거절">
							</form>
						</td>
					</tr>
					<tr>
						<td>
							${lhj_MemberVO.m_tel }
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