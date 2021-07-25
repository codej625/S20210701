<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/open.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
	<main>
		<!-- main -->
		<div class="oepn_wrap">
			<div class="page_title">개설하기</div>
			<div class="info_section">
				<div class="class_img"
					style="background-image: url('${pageContext.request.contextPath}/img/01.jpg');">
					<input type="button" value="사진첨부">
				</div>
				<div class="class_info">
					<div class="section_tit">기본정보</div>
					<div class="section_con">
						<div class="item_title">카테고리</div>
						<div class="item_content">
							<select>
								<option>카테고리</option>
								<option>게임/만화/애니</option>
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
							</select> <input type="text">
						</div>
						<div class="section_con">
							<div class="item_title">문의연락처</div>
							<div class="item_content">
								<a>담당자명</a> <input type="text" placeholder="이름을 입력하세요.">
								<a>전화번호</a> <input type="text" placeholder="전화번호를 입력하세요.">
								<a>이메일</a> <input type="text" placeholder="이메일을 입력하세요.">
							</div>
						</div>
						<div class="section_con">
							<div class="item_title">간단소개</div>
							<div class="item_content">
								<input type="text" placeholder="100자 이내">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="info_section">
				<div class="section_tit">상세정보</div>
				<div class="section_con">
					<textarea name="ir1" id="ir1" rows="10" cols="100"></textarea>
					<script type="text/javascript">
						var oEditors = [];
						nhn.husky.EZCreator.createInIFrame({
							oAppRef : oEditors,
							elPlaceHolder : "ir1",
							sSkinURI : "smarteditor2/SmartEditor2Skin.html",
							fCreator : "createSEditor2"
						});
					</script>
				</div>
			</div>
			<div class="info_section">
				<div class="section_tit">그룹정보</div>
				<div class="section_con">
					<div class="group_info">
						<div class="info">
							<input type="text" placeholder="그룹명을 입력하세요."> <input
								type="text" placeholder="정원을 입력하세요.">
							<button>무료</button>
							<button>유료</button>
							<input type="text">
						</div>
						<div class="info">
							<div class="title">모임기간</div>
							<input type="text">
						</div>
						<div class="info">
							<div class="title">신청기간</div>
							<input type="text">
						</div>
						<div class="info">
							<input type="checkbox">장소없음 <input type="text">
							<button>검색</button>
							<input type="text">
							<textarea>임시지도위치</textarea>
						</div>
					</div>
					<div class="group_option">
						<div class="sel_method"></div>
						<div class="over_pre"></div>
					</div>
				</div>
			</div>
			<div class="info_section">
				<div class="section_tit">결제방식</div>
				<div class="section_con"></div>
			</div>
			<div class="info_section">
				<div class="section_tit">알리기</div>
				<div class="section_con">
					<div class="title">태그입력</div>
					<input type="text">
				</div>
			</div>
			<div class="btn_section">
				<button>다시작성</button>
				<button>개설하기</button>
				<button>취소</button>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>