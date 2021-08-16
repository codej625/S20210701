<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/userInfo.css" />
<script>
	//프로필 이미지 업로드 할때 사진 보여주는거
	function setThumbnail(event) {
		var reader = new FileReader(); 
     	reader.onload = function(event) {
	        var img = document.createElement("img"); 
	        img.setAttribute("src", event.target.result); 
	        document.querySelector("div#image_container").appendChild(img); 
     	}; 
  		reader.readAsDataURL(event.target.files[0]); 
  	} 
</script>

</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
	<main>
		<form action="${pageContext.request.contextPath}/member/mypage_update" method="post" enctype="multipart/form-data">
		<!-- main -->
		<div class="userinfo_wrap">
			<div class="title">${lhj_MemberVO.m_name }님의 마이페이지</div>
			<div class="info_nav_bar">
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage">마이페이지 홈</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_update">회원정보 수정</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_mycertification">인증</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_myPostList">내가 쓴 글</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_myreginfo">신청 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_mybookmark">관심 내역</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_changePW">비밀번호 변경</a></div>
				<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_deleteMyself">회원 탈퇴</a></div>
			</div>
			<div class="info_section">
				<input type="hidden" value="${lhj_MemberVO.m_id }" name="m_id">
				<input type="hidden" value="${lhj_MemberVO.m_pw }">
				<input type="hidden" value="${lhj_MemberVO.m_regdate }">
				<input type="hidden" value="${lhj_MemberVO.m_rate }">
				<input type="hidden" value="${lhj_MemberVO.m_withdrawal }">
				<div class="info_img">
					<div id="image_container"></div>
					<input type="file" name="m_img" onchange="setThumbnail(event);"/>
				</div>
				<div class="info_items">
					<div class="info_item">
						<div class="item_title">이름</div>
						<div class="item_content">
							<input type="text" value="${lhj_MemberVO.m_name }" name="m_name">
						</div>
					</div>
					<div class="info_item">
						<div class="item_title">번호</div>
						<div class="item_content">
							<input type="text" value="${lhj_MemberVO.m_tel }" name="m_tel" >
						</div>
					</div>
					<div class="info_item">
						<div class="item_title">지역</div>
						<div class="item_content">
							<input type="text" value="${lhj_MemberVO.m_area }" name="m_area">
						</div>
					</div>
					<div class="info_item">
						<div class="item_title">분야</div>
						<div class="input_item">
						<select id="m_field" name="m_field">
							<option value="게임/만화/애니">게임/만화/애니</option>
							<option value="영화/음악/그림">영화/음악/그림</option>
							<option value="스포츠/레저">스포츠/레저</option>
							<option value="반려동물">반려동물</option>
							<option value="패션/미용">패션/미용</option>
							<option value="건강/다이어트">건강/다이어트</option>
							<option value="가족/육아">가족/육아</option>
							<option value="컴퓨터/통신">컴퓨터/통신</option>
							<option value="외국어/인문/과학">외국어/인문/과학</option>
							<option value="경제/금융/정치/사회">경제/금융/정치/사회</option>
							<option value="문학/창작">문학/창작</option>
							<option value="기타">기타</option>
						</select>
					</div>
					</div>
					<div>
						<input type="submit" value="수정">
						<input type="reset" value="취소">
					</div>
				</div>
			</div>
			<div class="res_section"></div>
		</div>
		</form>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>