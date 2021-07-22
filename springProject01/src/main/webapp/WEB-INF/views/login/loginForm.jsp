<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumSquare@1.0/nanumsquare.css">
<link href="../css/loginStyle.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="header_top">
            <div class="logo_section"><img src="../img/logo.png"></div>
            <div class="nav_bar">
                <div class="nav_header">
                    <ul>
                        <li>로그인</li>
                        <li>회원가입</li>
                        <li>회원님</li>
                        <li>로그아웃</li>
                        <li>고객센터</li>
                    </ul>
                </div>
            </div>
        </div>
		<div class="auth_page">
			<div class="login_section">
				<div class="auth_title">로그인</div>
				<div class="auth_input_section">
					<div class="input_item">
						<input type="text" name="user_id" placeholder="아이디" required="required">
					</div>
					<div class="input_item">
						<input type="password" name="user_pw" placeholder="비밀번호" required="required">
					</div>
					<div class="input_item2">
						<div class="save_id"><input type="checkbox"/>아이디저장</div>
						<div class="search_info">
							<a href="findUserIdForm.do">아이디 찾기</a>
							<a href=findUserPwForm.do>비밀번호 찾기</a>
						</div>
					</div>
					<div class="input_item">
						<button class="default_bt login_bt" type="submit">로그인</button>
					</div>
				</div>
			</div>
		</div>

</body>
</html>