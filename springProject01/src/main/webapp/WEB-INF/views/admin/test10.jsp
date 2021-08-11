<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach var="kkk" items="${check}">
			<tr>
				<td>게시판번호 : ${kkk.f_num}</td>
			</tr>
			<tr>
				<td>아이디 : ${kkk.m_id}</td>
			</tr>
			<tr>
				<td>이미지 : <img alt="f_orgname" src="${pageContext.request.contextPath}/${kkk.f_orgname}" height="240" width="320"></td>
			</tr>
			<tr>
				<td>업로드시간 : ${kkk.f_regdate}</td>
			</tr>
			<tr>
				<td>======================================================</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>