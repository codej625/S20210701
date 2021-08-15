<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data">
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
	
<form method="post" action="${pageContext.request.contextPath}/member/certification" enctype="multipart/form-data" name="resultform">
	<div class="info_img">
		<div id="image_container">
			<table>
				<tbody>
					<tr>
						<td>1.</td>
						<td colspan="2"><font color="blue">&lt;인증 받을 권한을 선택&gt;</font></td>
					<tr>
						<td>
							<input type="checkbox" name="m_meetingauth" value="M">&nbsp;모임&nbsp;
							<input type="checkbox" name="m_masterauth" value="M">&nbsp;클래스
						</td>
					</tr>
					<tr>
						<td>2.</td>
						<td><font color="blue">&lt;인증 받으려는 이유를 선택&gt;</font></td>
					</tr>
					<tr>
						<td>
							<select name="m_certification">
								<option value="정보 공유">정보 공유</option>
								<option value="상업적인 목적">상업적인 목적</option>
								<option value="취미 활동">취미 활동</option>
								<option value="기타">기타</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>3.</td>
						<td><font color="blue">&lt;메일 인증&gt;</font></td>
					</tr>
					<tr>
						<td><input type="text" placeholder="${lhj_MemberVO.m_id}" readonly></td>
						<td><input type="button" onclick="mail()" value="인증번호 받기"></td>
					</tr>
					<tr>
						<td><input type="hidden" name="m_id" value="${lhj_MemberVO.m_id}"></td>
						<td><input type="text" name="m_mail" placeholder="인증번호를 입력하세요"></td>
					</tr>
					<tr>
						<td>4.</td>
						<td><font color="blue">&lt;첨부 파일&gt;</font></td>
						<td><input multiple="multiple" type="file" name="files"></td>
					<tr>
						<td><input type="submit" value="개설자 인증받기"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</form>
</body>
</html>