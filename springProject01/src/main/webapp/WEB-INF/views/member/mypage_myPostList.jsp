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
	function allBtn() 
	{
	    all = $("#all").css("display");
	    class_ = $("#class_").css("display");
	    meeting = $("#meeting").css("display");
	    
	    if(all=="none") {
	    	$("#all").css("display", "");
	    	$("#class_").css("display", "none");
	    	$("#meeting").css("display", "none");
	    	
	    }
	    else			   	$("#all").css("display", "none");
	}
	
	function classBtn() 
	{
		all = $("#all").css("display");
	    class_ = $("#class_").css("display");
	    meeting = $("#meeting").css("display");
	    
	    if(class_=="none") {
	    	$("#class_").css("display", "");
	    	$("#all").css("display", "none");
	    	$("#meeting").css("display", "none");
	    }
	    else {
	    	$("#class_").css("display", "none");
	    	$("#all").css("display", "");
	    }
	    					
	}
	
	function meetingBtn() 
	{
		all = $("#all").css("display");
	    class_ = $("#class_").css("display");
	    meeting = $("#meeting").css("display");
	    
	    if(meeting=="none") {
	    	$("#meeting").css("display", "");
	    	$("#all").css("display", "none");
	    	$("#class_").css("display", "none");
	    }
	    else {
	    	$("#meeting").css("display", "none");
	    	$("#all").css("display", "");
	    }
	}

</script>

</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
	<main>
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
			
				<input type="button" value="all" onclick="allBtn()">
				<input type="button" value="class" onclick="classBtn()">
				<input type="button" value="meeting" onclick="meetingBtn()">
				
				
<!-- 				myPost 전부 보여주는거  -->
				<table class="myreginfo_table" border="1" id="all">
				<c:forEach var="lhj_MemberVO" items="${myPostList }">
					<tr>
							<td rowspan="2">
							<c:if test="${lhj_MemberVO.p_img == null}">
								<img src="${pageContext.request.contextPath}/img/goya.jpg" width="250px">
							</c:if>
							<c:if test="${lhj_MemberVO.p_img != null}">
								<img src="${pageContext.request.contextPath}/upload/${lhj_MemberVO.p_img }">
							</c:if>
							</td>
						<td>
							<c:if test="${lhj_MemberVO.p_cstatus == '0'}">
								무료
							</c:if>
							<c:if test="${lhj_MemberVO.p_cstatus == '1'}">
								유료
							</c:if>
						</td>						
					</tr>
					<tr>
						<td>
							${lhj_MemberVO.p_title }
						</td>
					</tr>
					<tr>
						<td>가격</td>
						<td rowspan="2">
							<form action="${pageContext.request.contextPath}/member/mypage_myPostMEmberList_">
								<input type="hidden" name="bt_num" value="${lhj_MemberVO.bt_num }">
								<input type="hidden" name="bc_num" value="${lhj_MemberVO.bc_num }">
								<input type="hidden" name="p_num" value="${lhj_MemberVO.p_num }">
								<a href="${pageContext.request.contextPath}/member/mypage_myPostMEmberList">
									<input type="submit" value="신청 인원 관리">
								</a>
							</form>
						</td>
					</tr>
					<tr>
						<td>${lhj_MemberVO.p_cost }</td>
					</tr>
				</c:forEach>	
				</table>
				
<!-- 				myPost -class 보여주는거  -->
				<table class="myreginfo_table" border="1" id="class_" style="display: none;">
				<c:forEach var="lhj_MemberVO" items="${myPostList_class }">
					<tr>
							<td rowspan="2">
							<c:if test="${lhj_MemberVO.p_img == null}">
								<img src="${pageContext.request.contextPath}/img/goya.jpg" width="250px">
							</c:if>
							<c:if test="${lhj_MemberVO.p_img != null}">
								<img src="${pageContext.request.contextPath}/upload/${lhj_MemberVO.p_img }">
							</c:if>
							</td>
						<td>
							<c:if test="${lhj_MemberVO.p_cstatus == '0'}">
								무료
							</c:if>
							<c:if test="${lhj_MemberVO.p_cstatus == '1'}">
								유료
							</c:if>
						</td>						
					</tr>
					<tr>
						<td>
							${lhj_MemberVO.p_title }
						</td>
					</tr>
					<tr>
						<td>가격</td>
						<td rowspan="2">
							<form action="${pageContext.request.contextPath}/member/mypage_myPostMEmberList_">
								<input type="hidden" name="bt_num" value="${lhj_MemberVO.bt_num }">
								<input type="hidden" name="bc_num" value="${lhj_MemberVO.bc_num }">
								<input type="hidden" name="p_num" value="${lhj_MemberVO.p_num }">
								
								<input type="submit" value="신청 인원 관리">
							</form>
						</td>
					</tr>
					<tr>
						<td>${lhj_MemberVO.p_cost }</td>
					</tr>
				</c:forEach>	
				</table>
				
<!-- 				myPost -meeting 보여주는거  -->
				<table class="myreginfo_table" border="1" id="meeting" style="display: none;">
				<c:forEach var="lhj_MemberVO" items="${myPostList_meeting }">
					<tr>
							<td rowspan="2">
							<c:if test="${lhj_MemberVO.p_img == null}">
								<img src="${pageContext.request.contextPath}/img/goya.jpg" width="250px">
							</c:if>
							<c:if test="${lhj_MemberVO.p_img != null}">
								<img src="${pageContext.request.contextPath}/upload/${lhj_MemberVO.p_img }">
							</c:if>
							</td>
						<td>
							<c:if test="${lhj_MemberVO.p_cstatus == '0'}">
								무료
							</c:if>
							<c:if test="${lhj_MemberVO.p_cstatus == '1'}">
								유료
							</c:if>
						</td>						
					</tr>
					<tr>
						<td>
							${lhj_MemberVO.p_title }
						</td>
					</tr>
					<tr>
						<td>가격</td>
						<td rowspan="2">
							<form action="${pageContext.request.contextPath}/member/mypage_myPostMEmberList_">
								<input type="hidden" name="bt_num" value="${lhj_MemberVO.bt_num }">
								<input type="hidden" name="bc_num" value="${lhj_MemberVO.bc_num }">
								<input type="hidden" name="p_num" value="${lhj_MemberVO.p_num }">
								
								<input type="submit" value="신청 인원 관리">
							</form>
						</td>
					</tr>
					<tr>
						<td>${lhj_MemberVO.p_cost }</td>
					</tr>
				</c:forEach>	
				</table>
				
				
				</div>
			<div class="res_section"></div>
		</div>
		</form>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>