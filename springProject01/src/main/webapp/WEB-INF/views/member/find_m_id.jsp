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
<script type="text/javascript">
		function closethewindow(){
			self.close();
		}
</script>
</head>
<body onload="bodyOnload()">
<form action="find_m_id" name="findform" method="post" >
		<div class="form-label-group">
			<input type="text" id="m_name" name="m_name" class="form-control"/>
			<label for="m_name">m_name</label>
		</div>
		
		<div class="form-label-group">
			<input type="text" id="m_tel" name="m_tel" class="form-control"/>
			<label for="m_tel">m_tel</label>
		</div>

		<div class="form-label-group">
			<input class="btn btn-lg btn-secondary btn-block text-uppercase"
				type="submit" value="check">
		</div>

		<!--일치하지 않을 때-->
		<c:if test="${check == 1}">
			<script>
				opener.document.findform.m_name.value = "";
				opener.document.findform.m_tel.value = "";
			</script>
			<label>일치하는 정보가 존재하지 않습니다.</label>
		</c:if>

		<!--일치 할 때 -->
		<c:if test="${check == 0 }">
		<label>찾으시는 아이디는' ${m_id}' 입니다.</label>
		<div class="form-label-group">
				<input class="btn btn-lg btn-secondary btn-block text-uppercase"
					type="button" value="OK" onclick="closethewindow()">
			</div>
		</c:if>
	</form>
 </body>