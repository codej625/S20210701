<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
<title>Report</title>
<%
	String context = request.getContextPath();
%>
<script type="text/javascript">
function mail(){
    $.ajax({
       url :"${pageContext.request.contextPath}/admin/report", 
       data : {'m_id' : resultform.m_id.value, 'r_content' : resultform.r_content.value},
       type :"POST",
       success : function(data){   
          alert("신고가 접수 되었습니다");
          window.close();
       },
       error : function(){
          alert("ajax error");
       }
    });
 }
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/report" method="post" name="resultform" onsubmit="return validate();">
		<table>
			<tr>
				<td>신고 사유를 적어주세요 <textarea name="r_content" style="width: 537px; height: 320px" placeholder="간략한 내용을 기재해주세요"></textarea>
				<td></td>
				<td><input type="hidden" name="m_id" value="${report.m_id}"></td>
			</tr>
		</table>
		<input type="button" value="신고하기" onclick="mail()" style="float: right; margin-right: 2px;" class="btn btn-outline-secondary" >
	</form>
</body>
</html>