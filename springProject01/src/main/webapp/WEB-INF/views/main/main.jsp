<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
	<main>
		<!-- main -->
		<div class="contennts_wrap">
			<div class="ex_section">
				<div class="ex_img"
					style="background-image: url('${pageContext.request.contextPath}/img/goya.jpg');">
					<a>모임을 하고싶으세요?</a>
				</div>
				<div class="ex_btn">
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/category?bt_num=1">참여하기</button>
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/register?bt_num=1">개설하기</button>
				</div>
			</div>
			<div class="ex_section">
				<div class="ex_img"
					style="background-image: url('${pageContext.request.contextPath}/img/goya.jpg');">
					<a>클래스를 통해 배우고 싶으세요?</a>	
				</div>
				<div class="ex_btn">
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/category?bt_num=2'">참여하기</button>
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/post/register?bt_num=2'">개설하기</button>
				</div>
			</div>
			<c:forEach items="${bestList1 }" var="post">
			<c:if test="${bt_num == 1}">
				<div class="ex_section">
                <div>All the Best 모임.ver</div>
                <div class=""></div>
                
	                <div class="class_wrap">
	                    <div class="class_item">
	                        <div class="class_img"><img src="img/people.jpg"></div>
	                        <div class="class_info">${post.p_title }</div>
	                    </div>
	                  
	                </div>
                
            	</div>
            </c:if>
            <c:if test="${bt_num == 2}">
			<div class="ex_section">
                <div>All the Best 클래스.ver</div>
                <div class=""></div>
                <div class="class_wrap">
                    <div class="class_item">1</div>
                    <div class="class_item">2</div>
                    <div class="class_item">3</div>
                    <div class="class_item">4</div>
                    <div class="class_item">5</div>    
                </div>
            </div>
            </c:if>
            </c:forEach>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/main/footer.jsp"%>
</body>
</html>