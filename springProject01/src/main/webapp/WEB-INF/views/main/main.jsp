<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
	<main>
		<!-- main -->
		<div class="contennts_wrap">
			<div class="ex_section">
				<div class="ex_img"
					style="background-image: url('${pageContext.request.contextPath}/img/KakaoTalk_20210815_022348582.png')">
					<h1>재테크?</h1>
                    <h2>부업?</h2>
                    <h3>교육?</h3>
                    <p>모임에 참여하고싶다면!</p>
				</div>
				<div class="ex_btn">
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/category?bt_num=1'">참여하기</button>
					<c:if test="${sessionID == null}">
						<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/member/login'">개설하기</button>
					</c:if>
					<c:if test="${sessionID != null}">
						<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/add?bt_num=1'">개설하기</button>
					</c:if>
				</div>
			</div>
			<div class="ex_section">
				<div class="ex_img"
					style="background-image: url('${pageContext.request.contextPath}/img/KakaoTalk_20210815_022412738.png')">
					<h1>공예</h1>
                    <h2>운동</h2>
                    <h3>취미</h3>
                    <p>클래스! 우리 함께 배워봐요!</p>
				</div>
				<div class="ex_btn">
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/category?bt_num=2'">참여하기</button>
					<c:if test="${sessionID == null}">
						<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/member/login'">개설하기</button>
					</c:if>
					<c:if test="${sessionID != null}">
						<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/add?bt_num=2'">개설하기</button>
					</c:if>
				</div>
			</div>
			
			<div class="ex_section">
                <div>All the Best 모임.ver</div>
	            <div class="class_wrap">
	                <c:forEach var="post1" items="${bestList1 }">
	                    <div class="class_item">
	                    	<a href="${pageContext.request.contextPath}/post/postListDetail?bt_num=${post1.bt_num }&bc_num=${post1.bc_num }&p_num=${post1.p_num}">
		                    	<div class="class_img"><img src="${pageContext.request.contextPath}/upload/${post1.p_img}"></div>
		                    	<div class="class_info">${post1.p_title }</div>
		                    </a>
	                    </div>
	                </c:forEach>
		    	</div>
			</div>
			
			<div class="ex_section">
                <div>All the Best 모임.ver</div>
	            <div class="class_wrap">
	           		<c:forEach var="post2" items="${bestList2 }">
		            	<div class="class_item">
			            	<a href="${pageContext.request.contextPath}/post/postListDetail?bt_num=${post2.bt_num }&bc_num=${post2.bc_num }&p_num=${post2.p_num}">
			            		<div class="class_img"><img src="${pageContext.request.contextPath}/upload/${post2.p_img}"></div>
			                	<div class="class_info">${post2.p_title }></div>
			            	</a>
		                </div>
	                </c:forEach>
	            </div>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/main/aside.jsp"%>
	</main>
	
	<%@ include file="/WEB-INF/views/main/footer.jsp"%>
</body>
</html>