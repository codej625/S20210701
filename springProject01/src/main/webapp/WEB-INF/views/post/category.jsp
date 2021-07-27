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
		<div class="contents_wrap">
			<div class="fil_section">
				<div class="fil_title">상세검색기능<c:if test="${msg != null }">${msg }</c:if></div>
				<div class="fil_items">
					<div class="item">
						<select>
							<option>카테고리</option>
							<option value="">게임/만화/애니</option>
							<option>영화/음악/그림</option>
							<option>스포츠/레저</option>
							<option>반려동물</option>
							<option>패션/미용</option>
							<option>건강/다이어트</option>
							<option>가족/육아</option>
							<option>컴퓨터/통신</option>
							<option>외국어/인문/과학</option>
							<option>경제/금융/정치/사회</option>
							<option>문학/창작</option>
							<option>기타</option>
						</select>
					</div>
					<div class="item">지역</div>
					<div class="item">시간/비용</div>
					<div class="item">기간</div>
					<div class="item">검색어</div>
				</div>
			</div>
			<div class="con_section">
				<c:forEach var="post" items="${listPost }">
				<div class="con_item">
	                    <div class="con_img">
	                        <img src="${pageContext.request.contextPath}/img/goya.jpg">
	                    </div>
	                    <div class="con_itm">
							<input type="hidden" name="p_num" value="${post.p_num }">
							${post.p_title }
	                    </div>
	                    <div class="con_itm">
	                        <div class="con_contents">
	                            <c:choose>
	                            	<c:when test="${post.p_cstatus == 0 }">무료</c:when>
	                            	<c:when test="${post.p_cstatus == 1 }">유료</c:when>
	                            </c:choose>
	                        </div>
	                        <div class="con_subinfo">
	                            ${post.p_metstart }
	                        </div>
                    	</div>
                	</div>
				</c:forEach>
<!-- 				<div class="con_item">2</div> -->
<!-- 				<div class="con_item">3</div> -->
<!-- 				<div class="con_item">4</div> -->
<!-- 				<div class="con_item">5</div> -->
<!-- 				<div class="con_item">6</div> -->
<!-- 				<div class="con_item">7</div> -->
<!-- 				<div class="con_item">8</div> -->
<!-- 				<div class="con_item">9</div> -->
<!-- 				<div class="con_item">10</div> -->
<!-- 				<div class="con_item">11</div> -->
<!-- 				<div class="con_item">12</div> -->
<!-- 				<div class="con_item">13</div> -->
<!-- 				<div class="con_item">14</div> -->
<!-- 				<div class="con_item">15</div> -->
<!-- 				<div class="con_item">16</div> -->
<!-- 				<div class="con_item">17</div> -->
<!-- 				<div class="con_item">18</div> -->
<!-- 				<div class="con_item">19</div> -->
<!-- 				<div class="con_item">20</div> -->
				<div class="page_btn">
					<button>이전</button>
					<button>1</button>
					<button>다음</button>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>