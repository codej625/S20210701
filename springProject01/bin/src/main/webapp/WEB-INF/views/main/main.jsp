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
					style="background-image: url('${pageContext.request.contextPath}/img/goya.jpg')">
					<a>모임을 하고싶으세요?</a>
				</div>
				<div class="ex_btn">
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/category?bt_num=1">참여하기</button>
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/register?bt_num=1">개설하기</button>
				</div>
			</div>
			<div class="ex_section">
				<div class="ex_img"
					style="background-image: url('${pageContext.request.contextPath}/img/goya.jpg')">
					<a>클래스를 통해 배우고 싶으세요?</a>	
				</div>
				<div class="ex_btn">
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/category?bt_num=2'">참여하기</button>
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/register?bt_num=2'">개설하기</button>
				</div>
			</div>
			
			<div class="ex_section">
                <div>All the Best 모임.ver</div>
	            <div class="class_wrap">
	                <c:forEach var="post1" items="${bestList1 }">
	                    <div class="class_item">
	                    	<a href="${pageContext.request.contextPath}/post/postListDetail?bt_num=${post1.bt_num }&bc_num=${post1.bc_num }&p_num=${post1.p_num}">
		                    	<div class="class_img"><img src="${pageContext.request.contextPath}/img/people.jpg"></div>
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
			            		<div class="class_img"><img src="img/people.jpg"></div>
			                	<div class="class_info">${post2.p_title }</div>
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