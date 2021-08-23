<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cate.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
	<main>
		<!-- main -->
		<c:if test="${lhj_MemberVO.m_meetingauth eq null and lhj_MemberVO.m_masterauth eq null}">
			<div class="contents_wrap">
            	<a href="${pageContext.request.contextPath}/post/register?bt_num=1" style="margin-left: 530px;">
            		모임 개설하기
            	</a>
            	<a href="${pageContext.request.contextPath}/post/register?bt_num=2" style="margin-left: 30px;">
            		클래스 개설하기
            	</a>
			</div>						
		</c:if>
		
		<c:if test="${lhj_MemberVO.m_meetingauth eq 'Y' and lhj_MemberVO.m_masterauth eq 'N'}">
			<div class="contents_wrap">
				<a href="${pageContext.request.contextPath}/post/register?bt_num=1" style="margin-left: 530px;">
            		모임 개설하기
            	</a>
			</div>				
		</c:if>
		
		<c:if test="${lhj_MemberVO.m_meetingauth eq 'Y' and lhj_MemberVO.m_masterauth eq null}">
			<div class="contents_wrap">
				<a href="${pageContext.request.contextPath}/post/register?bt_num=1" style="margin-left: 530px;">
            		모임 개설하기
            	</a>
			</div>				
		</c:if>
		
		<c:if test="${lhj_MemberVO.m_meetingauth eq 'N' and lhj_MemberVO.m_masterauth eq 'Y'}">
			<div class="contents_wrap">
            	<a href="${pageContext.request.contextPath}/post/register?bt_num=2" style="margin-left: 30px;">
            		클래스 개설하기
            	</a>
			</div>					
		</c:if>
		
		<c:if test="${lhj_MemberVO.m_meetingauth eq null and lhj_MemberVO.m_masterauth eq 'Y'}">
			<div class="contents_wrap">
            	<a href="${pageContext.request.contextPath}/post/register?bt_num=2" style="margin-left: 30px;">
            		클래스 개설하기
            	</a>
			</div>
		</c:if>
		
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>