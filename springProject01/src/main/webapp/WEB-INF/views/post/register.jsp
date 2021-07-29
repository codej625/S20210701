<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/open.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/smarteditor2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
function inputNumberFormat(obj) {
    obj.value = comma(uncomma(obj.value));
}

function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}

</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
	<main>
		<!-- main -->
		<div class="oepn_wrap">
			<form action="${pageContext.request.contextPath}/post/insert" method="post">
				${pageNum }
				<input type="hidden" name="p_num" value="${p_num }">
				<div class="page_title">개설하기</div>
				<div class="info_section">
					<div class="class_img"
						style="background-image: url('${pageContext.request.contextPath}/img/01.jpg');">
<!-- 						<input type="file" name="p_img" value="사진첨부"> -->
					</div>
					<div class="class_info">
						<div class="section_tit">기본정보</div>
						<div class="section_con">
							모임/클래스
							<c:choose>
								<c:when test="${bt_num == 1 }">
									<div class="item_title">
										<input type="hidden" name="bt_num" value="${bt_num }">
										<input type="text" value="모임" readonly="readonly">
									</div>
								</c:when>
								<c:when test="${bt_num == 2 }">
									<div class="item_title">
										<input type="hidden" name="bt_num" value="${bt_num }">
										<input type="text" value="클래스" readonly="readonly">
									</div>
								</c:when>
							</c:choose>
							<div class="item_title">카테고리</div>
							<div class="item_content">
								<select name="bc_num">
									<option value="1">카테고리</option>
									<option value="2">게임/만화/애니</option>
									<option value="3">영화/음악/그림</option>
									<option value="4">스포츠/레저</option>
									<option value="5">반려동물</option>
									<option value="6">패션/미용</option>
									<option value="7">건강/다이어트</option>
									<option value="8">가족/육아</option>
									<option value="9">컴퓨터/통신</option>
									<option value="10">외국어/인문/과학</option>
									<option value="11">경제/금융/정치/사회</option>
									<option value="12">문학/창작</option>
									<option value="13">기타</option>
								</select>
								<input type="text" name="p_title" placeholder="모임명을 입력해주세요">
							</div>
							<div class="section_con">
								<div class="item_title">문의연락처</div>
<!-- 								이부분은 로그인부분과 연결시켜서 sessionId값을 불러와서 넣어줘야된다 -->
<%-- 								이런식으로	<input type="text" name="m_name" value="${m_name }"> --%>
								<div class="item_content">
<%-- 									<a>담당자명</a> <input type="text" name="m_name" value="${m_name }" placeholder="이름입력"> --%>
<%-- 									<a>담당자명</a> <input type="tel" name="m_tel" value="${m_tel }" placeholder="번호입력"> --%>
<%-- 									<a>담당자명</a> <input type="text" name="m_id" value="${m_id }" placeholder="id입력"> --%>
								</div>
							</div>
							<div class="section_con">
								<div class="item_title">간단소개</div>
								<div class="item_content">
									<input type="text" name="p_intro" placeholder="100자 이내">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="info_section">
					<div class="section_tit">상세정보</div>
					<div class="section_con">
						<textarea name="p_info" id="ir1" rows="10" cols="100">에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면 됩니다.</textarea>
<!-- 					textarea부분 script -->
						<script type="text/javascript">
							var oEditors = [];
							nhn.husky.EZCreator.createInIFrame({
								oAppRef : oEditors,
								elPlaceHolder : "ir1",
								sSkinURI : "${pageContext.request.contextPath}/smarteditor2/SmartEditor2Skin.html",
								fCreator : "createSEditor2"
							});
							$(function() { 
								$("#savebutton").click(function() { 
									oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []); 
									//textarea의 id를 적어줍니다. 
									
									var selcatd = $("#selcatd > option:selected").val(); 
									var title = $("#title").val(); 
									var content = document.getElementById("smartEditor").value;; 
									
									if (selcatd == "") { 
										alert("카테고리를 선택해주세요."); 
										return; 
									} 
									if (title == null || title == "") { 
										alert("제목을 입력해주세요."); 
										$("#title").focus(); 
										return; 
									} 
									if(content == "" || content == null || content == '&nbsp;' || 
													content == '<br>' || content == '<br/>' || content == '<p>&nbsp;</p>'){ 
										alert("본문을 작성해주세요."); 
										oEditors.getById["smartEditor"].exec("FOCUS"); //포커싱 
										return; 
									} //이 부분은 스마트에디터 유효성 검사 부분이니 참고하시길 바랍니다. 
									var result = confirm("발행 하시겠습니까?"); 
									if(result){ 
										alert("발행 완료!"); 
										$("#noticeWriteForm").submit(); 
									}else{ 
										return; 
									} 
								}); 
							})
						</script>
					</div>
				</div>
				<div class="info_section">
					<div class="section_tit">그룹정보</div>
					<div class="section_con">
						<div class="group_info">
							<div class="info">
								<input type="text" name="p_gname" placeholder="그룹명을 입력하세요.">
								<input type="number" name="p_capa" placeholder="정원을 입력하세요.">
								<select name="p_cstatus">
									<option value="0">무료</option>
									<option value="1">유료</option>
								</select>
							</div>
							<div class="info">
								<div class="title">모임기간</div>
								<input type="date" name="p_metstart" placeholder="모임시작일">
								<input type="date" name="p_metend" placeholder="모임종료일">
							</div>
							<div class="info">
								<div class="title">신청기간</div>
<!-- 								<input type="date" name="p_appstart" placeholder="신청시작일"> -->
<!-- 								<input type="date" name="p_append" placeholder="신청종료일"> -->
							</div>
							<div class="info">
								<input type="checkbox">장소없음 <input type="text" name="p_loc" placeholder="장소">
								<button>검색</button>
								<textarea>임시지도위치</textarea>
							</div>
						</div>
						<div class="group_option">
							<div class="sel_method"></div>
							<div class="over_pre"></div>
						</div>
					</div>
				</div>
				<div class="info_section">
					<div class="section_tit">결제방식</div>
					<div class="section_con">
						<input type="text" id="price" onkeyup="inputNumberFormat(this)" name="p_cost" value="0" placeholder="비용">
						<input type="time" name="p_starttime" placeholder="시작시간">
						<input type="time" name="p_endtime" placeholder="종료시간">
					</div>
				</div>
				<div class="info_section">
					<div class="section_tit">알리기</div>
					<div class="section_con">
						<div class="title">태그입력</div>
					</div>
				</div>
				<div class="btn_section">
					<button>다시작성</button>
					<button type="submit">개설하기</button>
					<button>취소</button>
				</div>
			</form>
		</div>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>