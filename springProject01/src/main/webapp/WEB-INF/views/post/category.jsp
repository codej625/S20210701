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
				<div class="fil_title">
				
				상세검색기능<c:if test="${msg != null }">${msg }</c:if></div>
				<div class="fil_items">
					<div class="item">
						<select onchange="if(this.value) location.href=(this.value);">
							<option>
								<c:choose>
									<c:when test="${bc_num == 1 }">게임/만화/애니</c:when>
									<c:when test="${bc_num == 2 }">영화/음악/그림</c:when>
									<c:when test="${bc_num == 3 }">스포츠/레저</c:when>
									<c:when test="${bc_num == 4 }">반려동물</c:when>
									<c:when test="${bc_num == 5 }">패션/미용</c:when>
									<c:when test="${bc_num == 6 }">건강/다이어트</c:when>
									<c:when test="${bc_num == 7 }">가족/육아</c:when>
									<c:when test="${bc_num == 8 }">컴퓨터/통신</c:when>
									<c:when test="${bc_num == 9 }">외국어/인문/과학</c:when>
									<c:when test="${bc_num == 10 }">경제/금융/정치/사회</c:when>
									<c:when test="${bc_num == 11 }">문학/창작</c:when>
									<c:when test="${bc_num == 12 }">기타</c:when>
								</c:choose>
							</option>
							<c:if test="${bt_num == 1 }">
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=1">게임/만화/애니</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=2">영화/음악/그림</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=3">스포츠/레저</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=4">반려동물</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=5">패션/미용</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=6">건강/다이어트</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=7">가족/육아</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=8">컴퓨터/통신</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=9">외국어/인문/과학</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=10">경제/금융/정치/사회</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=11">문학/창작</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=12">기타</option>
							</c:if>
							<c:if test="${bt_num == 2 }">
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=1">게임/만화/애니</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=2">영화/음악/그림</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=3">스포츠/레저</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=4">반려동물</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=5">패션/미용</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=6">건강/다이어트</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=7">가족/육아</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=8">컴퓨터/통신</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=9">외국어/인문/과학</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=10">경제/금융/정치/사회</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=11">문학/창작</option>
								<option value="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=12">기타</option>
							</c:if>
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
					<div class="con_item" style="cursor: pointer;" 
						onclick="location.href='${pageContext.request.contextPath}/post/postListDetail?bt_num=${post.bt_num }&bc_num=${post.bc_num }&p_num=${post.p_num}'">
	                    <div class="con_img">
	                        <img src="${pageContext.request.contextPath}/upload/${post.p_img}">
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
								조회수 ${post.p_hit }
	                        </div>
                    	</div>
                	</div>
				</c:forEach>
<!-- 				<div class="con_item">2</div> -->
				<div class="page_btn">
					<c:if test="${pg.startPage > pg.pageBlock }">
						<a href="${pageContext.request.contextPath}/post/category?bt_num=${bt_num }&bc_num=${bc_num }&currentPage=${pg.startPage-pg.pageBlock }">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
						<a href="${pageContext.request.contextPath}/post/category?bt_num=${bt_num }&bc_num=${bc_num }&currentPage=${i }">[${i }]</a>
					</c:forEach>
					<c:if test="${pg.endPage < pg.totalPage }">
						<a href="${pageContext.request.contextPath}/post/category?bt_num=${bt_num }&bc_num=${bc_num }&currentPage=${pg.startPage+pg.pageBlock }">[다음]</a>
					</c:if>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>