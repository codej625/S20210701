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
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/board/category?bt_num=1">참여하기</button>
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/board/register?bt_num=1'">개설하기</button>
				</div>
			</div>
			<div class="ex_section">
				<div class="ex_img"
					style="background-image: url('${pageContext.request.contextPath}/img/goya.jpg');">
					<a>클래스를 통해 배우고 싶으세요?</a>	
				</div>
				<div class="ex_btn">
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/board/category?bt_num=2'">참여하기</button>
					<button class="default_bt" onclick="location.href='${pageContext.request.contextPath}/board/register?bt_num=2'">개설하기</button>
				</div>
			</div>
			<div class="ex_section">
				<div>All the Best 모임.ver</div>
				<div class=""></div>
				<div class=""></div>
				
			</div>
			<div class="ex_section">
				<div>All the Best 클래스.ver</div>
				<div class=""></div>
				<div class=""></div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/main/footer.jsp"%>
</body>
</html>