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
		<form action="${pageContext.request.contextPath}/member/mypage_mybookmark" method="post">
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
							<c:if test="${lhj_MemberVO.b_reg == 'N'}">
								신청하기 버튼
							</c:if>
						</td>
					</tr>
				</c:forEach>
				</table>	
			</div>
			<div class="res_section"></div>
		</div>
		</form>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>