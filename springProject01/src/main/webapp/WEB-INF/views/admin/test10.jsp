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
				<td>${kkk.f_num}</td>
				<td>${kkk.m_id}</td>
				<td><img alt="f_orgname" src="${kkk.f_orgname}">${kkk.f_orgname}</td>
				<td><img alt="f_newname" src="${kkk.f_newname}">${kkk.f_newname}</td>
				<td>${kkk.f_regdate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>