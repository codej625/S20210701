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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userInfo.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function mail(){
		$.ajax({
			url :"${pageContext.request.contextPath}/admin/mailTransport", 
			data : {'m_id' : resultform.m_id.value},
			type :"POST",
			success : function(data){	
				alert("인증번호를 보냈습니다.");
			},
			error : function(){
				alert("ajax error");
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
						<form method="post" action="${pageContext.request.contextPath}/member/certification" enctype="multipart/form-data" name="resultform">
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
													<input type="checkbox" name="m_meetingauth" value="M">&nbsp;모임&nbsp;&nbsp;
													<input type="checkbox" name="_masterauth" value="M">&nbsp;클래스
												</td>
											</tr>
											<tr>
												<td valign="TOP" width="15" align="RIGHT">2.</td>
												<td colspan="2"><font color="blue">&lt;인증 받으려는 이유를 선택&gt;</font></td>
											</tr>
											<tr>
												<td></td>
												<td colspan="3" align="center">
													<select name="m_certification">
														<option value="정보 공유">정보 공유</option>
														<option value="상업적인 목적">상업적인 목적</option>
														<option value="취미 활동">취미 활동</option>
														<option value="기타">기타</option>
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
												<td colspan="1"><input type="button" onclick="mail()" value="인증번호 받기"></td>
											</tr>
											<tr>
												<td colspan="1"><input type="hidden" name="m_id" value="${lhj_MemberVO.m_id}"></td>
												<td colspan="1"><input type="text" name="m_mail" placeholder="인증번호를 입력하세요"></td>
												<td></td>
											</tr>
											<tr>
												<td valign="TOP" width="15" align="RIGHT">4.</td>
												<td width="37%"><font color="blue">&lt;첨부 파일&gt;</font></td>
												<td><input multiple="multiple" type="file" name="files"></td>
											<tr>
												<td></td>
												<td></td>
												<td colspan="3" align="left"><input type="submit" value="개설자 인증받기"></td>
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
										<td>Y/N</td>
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
										<td>N/Y</td>
									</tr>
								</table>
							</div>
						</div>
					</form>
					</c:when>
					<c:when test="${lhj_MemberVO.m_meetingauth eq 'M' and lhj_MemberVO.m_masterauth eq 'Y'}">
						<form method="post" action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data">
							<div class="info_img">
								<div id="image_container">
									<table>
										<tr>
											<td>M/Y</td>
										</tr>
									</table>
								</div>
							</div>
					  	</form>
					</c:when>
					<c:when test="${lhj_MemberVO.m_meetingauth eq 'Y' and lhj_MemberVO.m_masterauth eq 'M'}">
						<form method="post" action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data">
							<div class="info_img">
								<div id="image_container">
									<table>
										<tr>
											<td>Y/M</td>
										</tr>
									</table>
								</div>
							</div>
					  	</form>
					</c:when>
					<c:when test="${lhj_MemberVO.m_meetingauth eq 'M' and lhj_MemberVO.m_masterauth eq 'M'}">
						<form method="post" action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data">
							<div class="info_img">
								<div id="image_container">
									<table>
										<tr>
											<td>M/M</td>
										</tr>
									</table>
								</div>
							</div>
					  	</form>
					</c:when>
					<c:when test="${lhj_MemberVO.m_meetingauth eq 'N' and lhj_MemberVO.m_masterauth eq 'M'}">
						<form method="post" action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data">
							<div class="info_img">
								<div id="image_container">
									<table>
										<tr>
											<td>N/M</td>
										</tr>
									</table>
								</div>
							</div>
					  	</form>
					</c:when>
					<c:when test="${lhj_MemberVO.m_meetingauth eq 'M' and lhj_MemberVO.m_masterauth eq 'N'}">
						<form method="post" action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data">
							<div class="info_img">
								<div id="image_container">
									<table>
										<tr>
											<td>M/N</td>
										</tr>
									</table>
								</div>
							</div>
					  	</form>
					</c:when>
				</c:choose>
			</div>
		</div>
	</main>
<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>