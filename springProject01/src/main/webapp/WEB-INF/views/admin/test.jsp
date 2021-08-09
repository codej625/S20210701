<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post"
		action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data">
		<table>
			<tr>
				<td><input type="text" name="m_id"></td>
			</tr>
			<tr>
				<td><input multiple="multiple" type="file" name="files"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>