<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	String context = request.getContextPath();
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/userInfo.css" />
<script type="text/javascript">

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
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_changePW">비밀번호 변경</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_myreginfo">신청 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_mybookmark">관심 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_deleteMyself">회원 탈퇴</a></div>
			</div>
			<div class="info_section">
				<table class="myreginfo_table">
				<c:forEach var="lhj_MemberVO" items="${myBookMarkList }">
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
						<td>
							<input type="hidden" value="${lhj_MemberVO.m_id }" name="m_id">
							${lhj_MemberVO.p_title }</td>
						<td>
							<c:if test="${lhj_MemberVO.p_cstatus == '0'}">
								무료
							</c:if>
							<c:if test="${lhj_MemberVO.p_cstatus == '1'}">
								유료
							</c:if>
						</td>
						<td>
				<form action="${pageContext.request.contextPath}/member/mypage_mybookmarkNO" method="post">
							<input type="hidden" name="m_id" value="${lhj_MemberVO.m_id }">
							<input type="hidden" name="bt_num" value="${lhj_MemberVO.bt_num }">
							<input type="hidden" name="bc_num" value="${lhj_MemberVO.bc_num }">
							<input type="hidden" name="p_num" value="${lhj_MemberVO.p_num }">
							
							<input type="submit" id="NoBMBtn" value="북마크 취소">
				</form>
				<form action="${pageContext.request.contextPath}/member/mypage_mybookmarkSin" method="post">
							<input type="hidden" name="m_id" value="${lhj_MemberVO.m_id }">
							<input type="hidden" name="bt_num" value="${lhj_MemberVO.bt_num }">
							<input type="hidden" name="bc_num" value="${lhj_MemberVO.bc_num }">
							<input type="hidden" name="p_num" value="${lhj_MemberVO.p_num }">
							
							<c:if test="${lhj_MemberVO.b_reg == 'N'}">
								<input type="submit" id="BMtoRGBtn" value="신청">
							</c:if>
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