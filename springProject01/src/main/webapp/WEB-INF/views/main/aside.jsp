<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/main/script.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/aside.css" />
</head>
<body>
	<div class="aside_wrap">
		<div class="side_title">최근 본 모임/클래스</div>
		<c:if test="${sessionID == null}">
			<div class="side_info">
				<div class="info_img"><i class="fas fa-lock fa-5x"></i></div>
				<div class="info_item">로그인 후 이용 가능합니다.</div>
			</div>
		</c:if>
		<c:if test="${sessionID != null}">
			<c:if test="${size == null}">
				<div class="side_info">
					<div class="info_img"><i class="far fa-tired fa-5x"></i></div>
					<div class="info_item">최근 본 게시물이 없습니다.</div>
				</div>
			</c:if>
			<c:if test="${size != null}">
				<c:forEach var="RecentPost" items="${listRpost }">	
					<div class="side_info">
						<a href="${pageContext.request.contextPath}/post/postListDetail?bt_num=${RecentPost.bt_num}&bc_num=${RecentPost.bc_num}&p_num=${RecentPost.p_num}">
							<div class="info_img"><img src="${pageContext.request.contextPath}/img/people.jpg"></div>
							<div class="info_item"> ${RecentPost.p_title }</div>
						</a>
					</div>
				</c:forEach>
			</c:if>
		</c:if>
	</div>
</body>
</html>