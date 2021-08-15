<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/main/script.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<script type="text/javascript">
	function innerHTMLTest(){
		var randValNode = document.getElementById("rand-val");
	    var input = document.getElementById("chkdate").value;
		randValNode.innerHTML = input;
	}
</script>
<body>
	<header>
		<!-- header_top -->
		<div class="header_top">
			<div class="logo_section">
				<a href="${pageContext.request.contextPath}/main/main"><img src="${pageContext.request.contextPath}/img/logo.png"></a>
			</div>
			<form action="${pageContext.request.contextPath}/post/category/search" method="get">
				<div class="search_section">
					<input type="text" id="keyword" name="keyword" placeholder="원하는 모임을 검색해보세요!" /><button>검색하기</button>
				</div>
			</form>
			<div class="nav_bar">
				<div class="nav_header">
					<ul>
						<c:if test="${sessionID == null}">
							<li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
							<li><a href="${pageContext.request.contextPath}/member/join">회원가입</a></li>
						</c:if>
						<c:if test="${sessionID != null}">
							<li><a href="${pageContext.request.contextPath}/member/mypage"><span style="color:#269F70;">${m_name}회원님</span></a></li>
							<li><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
						</c:if>
						<li><a href="${pageContext.request.contextPath}/chat/user">고객센터</a></li>
<%-- 						<li><a href="${pageContext.request.contextPath}/chat/chat">라이브톡</a></li>
 --%>					</ul>
				</div>
				<div class="nav_menu">
					<div class="nav_detail">
						<c:if test="${sessionID == null}">
							<a href="${pageContext.request.contextPath}/member/login"><i class="far fa-id-card fa-3x"></i><br />마이페이지</a>
						</c:if>
						<c:if test="${sessionID != null}">
							<a href="${pageContext.request.contextPath}/member/mypage"> <i class="far fa-id-card fa-3x"></i><br />마이페이지</a>
						</c:if>
					</div>
					<div class="nav_detail">
						<c:if test="${sessionID != null}">
							<c:if test="${lhj_MemberVO.m_meetingauth eq null and lhj_MemberVO.m_masterauth eq null}">
								<a href="${pageContext.request.contextPath}/member/mypage_mycertification"><i class="far fa-list-alt fa-3x"></i></a>
								<br>
								<a href="${pageContext.request.contextPath}/member/mypage_mycertification">모임개설</a>
							</c:if>
							<c:if test="${lhj_MemberVO.m_meetingauth eq 'Y' and lhj_MemberVO.m_masterauth eq 'Y'}">
								<a href="${pageContext.request.contextPath}/post/add"><i class="far fa-list-alt fa-3x"></i></a>
								<br>
								<a href="${pageContext.request.contextPath}/post/add">모임개설</a>
							</c:if>
						</c:if>
						<c:if test="${sessionID == null}">
							<a href="${pageContext.request.contextPath}/member/login"><i class="far fa-id-card fa-3x"></i><br />모임개설</a>
						</c:if>
					</div>
					<div class="nav_detail">
						<a href="${pageContext.request.contextPath}/chat/chat"><i class="far fa-comment-dots"></i></a><br /> <a
							href="${pageContext.request.contextPath}/chat/chat">라이브톡</a>
					</div>
					<div class="nav_detail">
						<c:if test="${sessionID == null}">
                        	<a href="${pageContext.request.contextPath}/member/login"><i class="far fa-calendar-check"></i><br/>출석체크</a>
                        </c:if>
						<c:if test="${sessionID != null}">
                        	<a onclick="chkValue()"><i class="far fa-calendar-check"></i><br/>출석체크</a>
                        	<div id="rand-val">Let's generate random Value</div>
    						<input type="text" id="chkdate" value="${sessionID }">
                        </c:if>
                    </div>
					<div class="nav_detail">
						<a><i class="far fa-bell fa-3x"></i><br />알림</a>
					</div>
				</div>
			</div>
		</div>
		<!-- header_bottom -->
		<div class="header_bottom">
			<div class="filter_blank"></div>
			<div class="filter_deco">
				<i class="fas fa-angle-right fa-2x"></i>
			</div>
			<div class="filter_item">
				<a href="${pageContext.request.contextPath}/post/category?bt_num=1">모임</a>
				<ul class="select_box">
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=1">게임/만화/애니</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=2">영화/음악/그림</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=3">스포츠/레저</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=4">반려동물</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=5">패션/미용</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=6">건강/다이어트</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=7">가족/육아</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=8">컴퓨터/통신</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=9">외국어/인문/과학</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=10">경제/금융/정치/사회</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=11">문학/창작</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=1&bc_num=12">기타</a></li>
				</ul>
			</div>
			<div class="filter_item">
				<a href="${pageContext.request.contextPath}/post/category?bt_num=2">클래스</a>
				<ul class="select_box">
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=1">게임/만화/애니</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=2">영화/음악/그림</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=3">스포츠/레저</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=4">반려동물</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=5">패션/미용</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=6">건강/다이어트</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=7">가족/육아</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=8">컴퓨터/통신</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=9">외국어/인문/과학</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=10">경제/금융/정치/사회</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=11">문학/창작</a></li>
					<li><a
						href="${pageContext.request.contextPath}/post/category?bt_num=2&bc_num=12">기타</a></li>
				</ul>
			</div>
		</div>
	</header>
</body>
</html>