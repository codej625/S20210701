<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/main/script.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/joinStyle.css"/>
</head>
<body onload="bodyOnload()">
	<form action="${pageContext.request.contextPath}/members/join" method="post">
        <div class="header_top">
            <div class="logo_section">
            	<a href="${pageContext.request.contextPath}/main/main"><img src="${pageContext.request.contextPath}/img/logo.png"></a>
            </div>
            <div class="nav_bar">
                <div class="nav_header">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
                        <li><a href="${pageContext.request.contextPath}/member/join">회원가입</a></li>
                        <li>고객센터</li>
                    </ul>
                </div>
            </div>
        </div>
		<div class="login_page">
			<div class="login_section">
				<div class="login_title">회원가입</div>
				<div class="login_input_section">
					<div class="input_title">필수정보</div>
					<div class="input_item">
						<input type="text" name="m_id" placeholder="아이디" required="required">
					</div>
					<div class="input_item">
						<input type="password" name="m_pw" placeholder="비밀번호" required="required">
					</div>
					<div class="input_item">
						<input type="password" name="m_pw" placeholder="비밀번호확인" required="required">
					</div>
					<div class="input_item">
						<input type="text" name="m_name" placeholder="이름" required="required">
					</div>
					<div class="input_item">
						<input type="text" name="m_tel" placeholder="번호" required="required">
					</div>
					<div class="input_title">관심정보</div>
					<div class="input_item">
						<input type="text" name="m_tel" placeholder="지역">
					</div>
					<div class="input_item">
						<input type="text" name="m_field" placeholder="분야">
					</div>
					<div class="input_item">
						<input type="text" name="m_regdate">
					</div>
					<div class="input_title">약관동의</div>
					<div class="agree_form">
						<p>
							약관동의 블라블라<br/>
							가입완료시 동의한 것으로 간주<br/>
						</p>
					</div>
					<div class="input_item">
						<button class="default_bt join_bt" type="submit">가입하기</button>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/main/footer.jsp"%>
	</form>
</body>