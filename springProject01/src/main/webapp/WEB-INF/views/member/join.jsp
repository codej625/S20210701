<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/5b4294bd03.js" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@700&family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumSquare@1.0/nanumsquare.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/joinStyle.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/foot.css"/>
<%
	String context = request.getContextPath();
%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
	/* 자바 스크립트 함수 선언(비밀번호 확인) */
	function passConfirm() {
	/* 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치, 그렇지 않으면 불일치 라는 텍스트 출력.*/
	/* document : 현재 문서를 의미함. 작성되고 있는 문서를 뜻함. */
	/* getElementByID('아이디') : 아이디에 적힌 값을 가진 id의 value를 get을 해서 password 변수 넣기 */
		var password = document.getElementById('m_pw');					//비밀번호 
		var passwordConfirm = document.getElementById('m_re_pw');	//비밀번호 확인 값
		var confrimMsg = document.getElementById('confirmMsg');				//확인 메세지
		var correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
		var wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
		
		if(password.value == passwordConfirm.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
			confirmMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
			confirmMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
		}else{
			confirmMsg.style.color = wrongColor;
			confirmMsg.innerHTML ="비밀번호 불일치";
		}
	}
	
	
	function idOverlap(){
		console.log("idOverlap 호출")
		console.log("아이디 입력 값 : "+joinForm.m_id.value)
	$.ajax({
		type :"post",/* 전송 방식 */
		url :"${pageContext.request.contextPath}/idOverlap", /* 컨트롤러 사용할 때. 내가 보낼 데이터의 주소. */
		data : {"m_id" : joinForm.m_id.value},
		/* JSON형식 안에 JSON 형식으로 표현한 데이터. 
        "파라미터 이름" : 폼태그에 적은 NAME 값.ID입력창의 NAME값.value 여러 개도 가능
		data :{	"id" : joinForm.id.value, 
		"id1" : joinForm.password.value}, 이렇게도 사용 가능.					
		*/
		dataType : "text",	/* text, xml, html, script, json, jsonp 가능 */
        //정상적인 통신을 했다면 function은 백엔드 단에서 데이터를 처리.
		success : function(data){	
			if(data=="1"){
				alert("이 아이디는 사용 가능합니다.");
			}else{	//ajax가 제대로 안됐을 때 .
				alert("이미 사용중인 아이디 입니다.");
			}
		},
		error : function(){
			alert("아이디 중복 확인 ajax 실행 실패");
		}
	});
	
}
		
	function telOverlap(){
		console.log("telOverlap 호출")
		console.log("휴대폰 번호 입력 값 : "+joinForm.m_tel.value)
	$.ajax({
		type :"post",/* 전송 방식 */
		url :"${pageContext.request.contextPath}/telOverlap", /* 컨트롤러 사용할 때. 내가 보낼 데이터의 주소. */
		data : {"m_tel" : joinForm.m_tel.value},
		/* JSON형식 안에 JSON 형식으로 표현한 데이터. 
        "파라미터 이름" : 폼태그에 적은 NAME 값.ID입력창의 NAME값.value 여러 개도 가능
		data :{	"id" : joinForm.id.value, 
		"id1" : joinForm.password.value}, 이렇게도 사용 가능.					
		*/
		dataType : "text",	/* text, xml, html, script, json, jsonp 가능 */
        //정상적인 통신을 했다면 function은 백엔드 단에서 데이터를 처리.
		success : function(data){	
			if(data=="1"){
				alert("이 휴대번호는 사용 가능합니다.");
			}else{	//ajax가 제대로 안됐을 때 .
				alert("이미 등록된 번호 입니다.");
			}
		},
		error : function(){
			alert("휴대번호 중복 확인 ajax 실행 실패");
		}
	});
	
}
	
</script>
</head>
<body onload="bodyOnload()">
        <form action="${pageContext.request.contextPath}/members/join" method="post" name="joinForm">
        <div class="header_top">
            <div class="logo_section">
            	<a href="${pageContext.request.contextPath}/main/main"><img src="${pageContext.request.contextPath}/img/logo.png"></a></div>
            <div class="nav_bar">
                <div class="nav_header">
                    <ul>					
						<c:if test="${sessionID == null}">
							<li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
							<li><a href="${pageContext.request.contextPath}/member/join">회원가입</a></li>
						</c:if>
						<c:if test="${sessionID != null }">
							<li>${sessionID }회원님</li>
								<li><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
						</c:if>
						<li><a href="고객센터">고객센터</a></li>
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
						<input type="button" onclick="idOverlap()" value="중복확인"/>
					</div>
					<div class="input_item">
						<input type="password" id="m_pw" name="m_pw" placeholder="비밀번호" required="required">
					</div>
					<div class="input_item">
						<input type="password" id="m_re_pw" placeholder="비밀번호확인" required="required" onkeyup="passConfirm()">
						<span id ="confirmMsg"></span>
					</div>
					<div class="input_item">
						<input type="password" name="m_name" placeholder="이름" required="required">
					</div>
					<div class="input_item">
						<input type="text" name="m_tel" placeholder="휴대폰 번호" required="required">
						<input type="button" onclick="telOverlap()" value="중복확인"/>
					</div>
					<div class="input_title">관심정보</div>
					<div class="input_item">
						<input type="text" id="m_area" name="m_area" placeholder="지역" required="required">
					</div>
					
					<div class="input_title">관심 분야</div>
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
					
					<div class="input_title">약관동의</div>
					<div class="agree_form">
						<p>
							약관동의<br/>
							가입완료시 동의한 것으로 간주<br/>
						</p>
						<input type="checkbox" id="join_chk">
					</div>
					<div class="input_item">
						<button class="default_bt join_bt" type="submit" onclick="go_save()"> 가입 </button>
					</div>
				</div>
			</div>
		</form>
		</div>
		 <!-- **FOOTER START** -->
    <footer>
        <div class=footer>
            <div class="company_info">
                <ul>
                    <li>(주)모꼬지(대표이사:중앙정보처리)</li>
                    <li>주소 : 서울특별시 어쩌고 저쩌고</li>
                    <li>대표번호 : 02-1234-5678</li>
                    <li>고객센터 : abcd@efg.com</li>
                </ul>
            </div>
            <div class="ft_copyright">Copyright@Moggogi co., Ltd. All rights reserved</div>
        </div>
    </footer>
</body>