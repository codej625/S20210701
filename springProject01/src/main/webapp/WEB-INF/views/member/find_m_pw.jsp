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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/foot.css"/>
<%
	String context = request.getContextPath();
%>
<script type="text/javascript">
		function closethewindow(){
			self.close();
		}
</script>
</head>
<body onload="bodyOnload()">
<form action="find_m_pw" name="findform" method="post" >
		
		<div class="find_div2">
			<label for="m_name" id="labels" >이름</label>
			<input type="text" id="m_name" name="m_name" class="find_text"/>
			<br>
			<label for="m_id" id="labels_2" >아이디</label>
			<input type="text" id="m_id" name="m_id" class="find_text"/>
			<br>
			<label for="m_tel">전화번호</label>
			<input type="text" id="m_tel" name="m_tel" class="find_text"/>
		
			<input class="sub_btn" type="submit" value="찾기">
	
			<!--일치하지 않을 때-->
			<c:if test="${check == 1}">
				<script>
					opener.document.findform.m_name.value = "";
					opener.document.findform.m_id.value = "";
					opener.document.findform.m_tel.value = "";
				</script>
				<label class="text_label2">일치하는 정보가 존재하지 않습니다.</label>
			</c:if>
	
			<!--일치 할 때 -->
			<c:if test="${check == 0 }">
			<label class="text_label2">찾으시는 비밀번호는' ${m_pw}' 입니다.</label>
			<div>
				<input class="chk_btn2"
					type="button" value="확인" onclick="closethewindow()">
			</div>
			</c:if>
		</div>
	</form>
 </body>