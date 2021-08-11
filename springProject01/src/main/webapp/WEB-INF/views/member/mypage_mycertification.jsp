<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%
	String context = request.getContextPath();
%>
<head>
<meta charset="utf-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userInfo.css" />

<script type="text/javascript">
	function in() {
		console.log("아작스 호출")
		console.log("아이디 입력 값 : " +form.m_id.value)
		$.ajax({
			url :"$<%=context%>/admin/mailTransport", 
			data : {"m_id" : form.m_id.value},
			dataType : "text",
			success : function(data){	
				if(data=="1"){
					alert("성공");
				}else{	
					alert("실패");
				}
			},
			error : function(){
				alert("대실패");
			}
		});
	}

</script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
		<!-- main -->
		<main>
			<div class="userinfo_wrap">
				<div class="title">${lhj_MemberVO.m_name }님의 마이페이지</div>
					<div class="info_nav_bar"><div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage">마이페이지 홈</a></div>
						<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_update">회원정보 수정</a></div>
						<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_mycertification">인증</a></div>
						<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_myPostList">내가 쓴 글</a></div>
						<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_myreginfo">신청 내역</a></div>
						<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_mybookmark">관심 내역</a></div>
						<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_changePW">비밀번호 변경</a></div>
						<div class="info_nav_menu"><a href="${pageContext.request.contextPath}/member/mypage_deleteMyself">회원 탈퇴</a></div></div>
					<div class="info_section">
				 <c:choose>
				     <c:when test="${lhj_MemberVO.m_meetingauth eq 'N' and lhj_MemberVO.m_masterauth eq 'N'}"> 
						<form method="post" action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data" name="form">
							<input type="hidden" value="${lhj_MemberVO.m_id }" name="m_id">
							<div class="info_img">
								<div id="image_container">
									<table width="100%" cellpadding="5" cellspacing="0">
										<tbody>
											<tr>
												<td valign="TOP" width="15" align="RIGHT">1.</td>
												<td colspan="2"><font color="blue">&lt;인증 받을 권한을 선택&gt;</font></td>
											<tr>
												<td></td>
												<td colspan="2">
													<input type="checkbox" name="m_meetingauth" value="Y">&nbsp;모임&nbsp;&nbsp;
													<input type="checkbox" name="m_masterauth" value="Y">&nbsp;클래스
												</td>
											</tr>
											<tr>
												<td valign="TOP" width="15" align="RIGHT">2.</td>
												<td colspan="2"><font color="blue">&lt;인증 받으려는 이유를 선택&gt;</font></td>
											</tr>
											<tr>
												<td colspan="3" align="center">
													<select>
														<option value="1">정보 공유</option>
														<option value="2">상업적인 목적</option>
														<option value="3">취미 활동</option>
														<option value="4">기타</option>
													</select>
												</td>
											</tr>
											<tr>
												<td valign="TOP" width="15" align="RIGHT">3.</td>
												<td width="37%"><font color="blue">&lt;메일 인증&gt;</font></td>
											</tr>
											<tr>
												<td></td>
												<td colspan="1"><input type="text" placeholder="${lhj_MemberVO.m_id}" readonly></td>
											</tr>
											<tr>
												<td></td>
												<td colspan="1"><input type="text"></td>
												<td colspan="1">
												<input type="button" onclick="in()" value="확인">
												
<%-- 												<button onclick='location.href="${pageContext.request.contextPath}/admin/mailTransport?m_id=${lhj_MemberVO.m_id}"'>메인 인증</button></td> --%>
											</tr>
											<tr>
												<td colspan="3" align="right"><input type="submit" value="개설자 인증받기"></td>
												<td></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</form>
					</c:when>
					<c:when test="${lhj_MemberVO.m_meetingauth eq 'Y' and lhj_MemberVO.m_masterauth eq 'N'}"> 
					<form method="post" action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data">
						<div class="info_img">
							<div id="image_container">
								<table>
									<tr>
										<td>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</form>
					</c:when>
					<c:when test="${lhj_MemberVO.m_meetingauth eq 'N' and lhj_MemberVO.m_masterauth eq 'Y'}">
					<form method="post" action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data">
						<div class="info_img">
							<div id="image_container">
								<table>
									<tr>
										<td>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</form>
					</c:when>
					<c:otherwise>
					<form method="post" action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data">
						<div class="info_img">
							<div id="image_container">
								<table>
									<tr>
										<td>
										</td>
									</tr>
								</table>
							</div>
						</div>
				  	</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</main>
<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>