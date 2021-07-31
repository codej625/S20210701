<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/cate.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
	<main>
		<!-- main -->
		<div class="contents_wrap">
			<div class="fil_section">
				<div class="fil_title">상세검색기능</div>
				<div class="fil_items">
					<div class="item">
						<select>카테고리
							<ul>
								<li>유료</li>
								<li>무료</li>
							</ul>
						</select>
					</div>
					<div class="item">지역</div>
					<div class="item">시간/비용</div>
					<div class="item">기간</div>
					<div class="item">검색어</div>
				</div>
			</div>
			<div class="con_section">
				<div class="con_item">
					1
					<div class="con_img"></div>
					<div class="con_contents"></div>
					<div class="con_subinfo"></div>
				</div>
				<div class="con_item">2</div>
				<div class="con_item">3</div>
				<div class="con_item">4</div>
				<div class="con_item">5</div>
				<div class="con_item">6</div>
				<div class="con_item">7</div>
				<div class="con_item">8</div>
				<div class="con_item">9</div>
				<div class="con_item">10</div>
				<div class="con_item">11</div>
				<div class="con_item">12</div>
				<div class="con_item">13</div>
				<div class="con_item">14</div>
				<div class="con_item">15</div>
				<div class="con_item">16</div>
				<div class="con_item">17</div>
				<div class="con_item">18</div>
				<div class="con_item">19</div>
				<div class="con_item">20</div>
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