<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<form action="${pageContext.request.contextPath}/member/mypage">
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
				<div class="info_img">
					<c:if test="${lhj_MemberVO.m_img == null}">
						<img src="${pageContext.request.contextPath}/img/흰둥이.jpg" class="img_size">				
					</c:if>
					<c:if test="${lhj_MemberVO.m_img != null}">
						<img src="${pageContext.request.contextPath}/upload/${lhj_MemberVO.m_img}" class="img_size">				
					</c:if>
				</div>
				<div>
					<table class="myreginfo_table">
						<tr><th>이름</th><td>${lhj_MemberVO.m_name }</td></tr>
						<tr><th>칭호</th>
							<td>
								<c:if test="${lhj_MemberVO.nt_name == null}">
									칭호가 없습니다.
								</c:if>
								<c:if test="${lhj_MemberVO.nt_name != null}">
									${lhj_MemberVO.nt_name }
								</c:if>
							</td>
						</tr>
						<tr><th>이메일</th><td>${lhj_MemberVO.m_id }</td></tr>
						<tr><th>번호</th><td>${lhj_MemberVO.m_tel }</td></tr>
						<tr><th>분야</th><td>${lhj_MemberVO.m_field }</td></tr>
						<tr><th>가입일</th><td>${lhj_MemberVO.m_regdate }</td></tr>
						<tr>
							<th>모임인증</th>
							<td>
								<c:if test="${lhj_MemberVO.m_meetingauth == null}">
										미인증
								</c:if>
								<c:if test="${lhj_MemberVO.m_meetingauth == 'N'}">
										인증 신청 중
								</c:if>
								<c:if test="${lhj_MemberVO.m_meetingauth == 'Y' }">
										인증 완료
								</c:if>
							</td>
						</tr>
						<tr>
							<th>고수인증</th>
							<td>
								<c:if test="${lhj_MemberVO.m_masterauth == null }">
										미인증
								</c:if>
								<c:if test="${lhj_MemberVO.m_masterauth == 'N'}">
										인증 신청 중
								</c:if>
								<c:if test="${lhj_MemberVO.m_masterauth == 'Y' }">
										인증 완료
								</c:if>
							</td>
						</tr>						
					</table>
				</div>
				
				
<!-- 				<div class="info_items"> -->
<!-- 					<div class="info_item"> -->
<!-- 						<div class="item_title">이름</div> -->
<!-- 						<div class="item_content"> -->
<%-- 							<input type="text" value="${lhj_MemberVO.m_name }" readonly> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="info_item"> -->
<!-- 						<div class="item_title">이메일</div> -->
<!-- 						<div class="item_content"> -->
<%-- 							<input type="text" value="${lhj_MemberVO.m_id }" readonly> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="info_item"> -->
<!-- 						<div class="item_title">번호</div> -->
<!-- 						<div class="item_content"> -->
<%-- 							<input type="text" value="${lhj_MemberVO.m_tel }" readonly> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="info_item"> -->
<!-- 						<div class="item_title">분야</div> -->
<!-- 						<div class="item_content"> -->
<%-- 							<input type="text" value="${lhj_MemberVO.m_field }" readonly> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="info_item"> -->
<!-- 						<div class="item_title">가입일</div> -->
<!-- 						<div class="item_content"> -->
<%-- 							<input type="text" value="${lhj_MemberVO.m_regdate }" readonly> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
		</div>
		</form>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>