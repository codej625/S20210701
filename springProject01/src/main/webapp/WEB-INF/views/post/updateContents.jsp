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
			<form action="${pageContext.request.contextPath}/post/postListUpdate" method="post">
				<input type="hidden" name="p_num" value="${post.p_num }">
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
								<c:when test="${post.bt_num == 1 }">
									<div class="item_title">
										<input type="hidden" name="bt_num" value="${post.bt_num }" >
										<input type="text" value="모임" readonly="readonly" >
									</div>
								</c:when>
								<c:when test="${post.bt_num == 2 }">
									<div class="item_title">
										<input type="text" name="bt_num" value="${post.bt_num }" >
										<input type="text" value="클래스" readonly="readonly" >
									</div>
								</c:when>
							</c:choose>
							<div class="item_title">카테고리</div>
							<div class="item_content">
								<input type="hidden" name="bc_num" value="${post.bc_num }" readonly="readonly">
								<c:choose>
									<c:when test="${post.bc_num == 1 }"><input type="text" value="게임/만화/애니" readonly="readonly" ></c:when>
									<c:when test="${post.bc_num == 2 }"><input type="text" value="영화/음악/그림" readonly="readonly" ></c:when>
									<c:when test="${post.bc_num == 3 }"><input type="text" value="스포츠/레저" readonly="readonly" ></c:when>
									<c:when test="${post.bc_num == 4 }"><input type="text" value="반려동물" readonly="readonly" ></c:when>
									<c:when test="${post.bc_num == 5 }"><input type="text" value="패션/미용" readonly="readonly" ></c:when>
									<c:when test="${post.bc_num == 6 }"><input type="text" value="건강/다이어트" readonly="readonly" ></c:when>
									<c:when test="${post.bc_num == 7 }"><input type="text" value="가족/육아" readonly="readonly" >가족/육아</c:when>
									<c:when test="${post.bc_num == 8 }"><input type="text" value="컴퓨터/통신" readonly="readonly" >컴퓨터/통신</c:when>
									<c:when test="${post.bc_num == 9 }"><input type="text" value="외국어/인문/과학" readonly="readonly" >외국어/인문/과학</c:when>
									<c:when test="${post.bc_num == 10 }"><input type="text" value="경제/금융/정치/사회" readonly="readonly" >경제/금융/정치/사회</c:when>
									<c:when test="${post.bc_num == 11 }"><input type="text" value="문학/창작" readonly="readonly" >문학/창작</c:when>
									<c:when test="${post.bc_num == 12 }"><input type="text" value="기타" readonly="readonly" >기타</c:when>
								</c:choose>
								<p>모임명
								<p><input type="text" name="p_title" value="${post.p_title }">
							</div>
							<div class="section_con">
								<div class="item_title">문의연락처</div>
								<div class="item_content">
									<a>담당자명</a> <input type="text" name="m_name" value="${post.m_name }" readonly="readonly">
									<a>휴대번호</a> <input type="tel" name="m_tel" value="${post.m_tel }" readonly="readonly">
									<a>담당자아이디</a> <input type="text" name="m_id" value="${post.m_id }" readonly="readonly">
								</div>
							</div>
							<div class="section_con">
								<div class="item_title">간단소개</div>
								<div class="item_content">
									<input type="text" name="p_intro" value="${post.p_intro }">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="info_section">
					<div class="section_tit">상세정보</div>
					<div class="section_con">
						<textarea name="p_info" id="ir1" rows="10" cols="100">${post.p_info }</textarea>
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
								<input type="text" name="p_gname" value="${post.p_gname }">
								<input type="number" name="p_capa" value="${post.p_capa }">
								<select name="p_cstatus" >
									<option value="${post.p_cstatus }">
										<c:choose>
											<c:when test="${post.p_cstatus == 0 }">무료</c:when>
											<c:when test="${post.p_cstatus == 1 }">유료</c:when>
										</c:choose>
									</option>
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
								<input type="checkbox">장소없음 <input type="text" name="p_loc" value="${post.p_loc }">
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
						<input type="text" id="price" onkeyup="inputNumberFormat(this)" name="p_cost" value="${post.p_cost }">
						<input type="time" name="p_starttime" value="${post.p_starttime }">
						<input type="time" name="p_endtime" value="${post.p_endtime }">
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
					<input type="submit" value="수정완료">
<!-- 					<button type="submit">수정완료</button> -->
					<button>취소</button>
				</div>
			</form>
		</div>
	</main>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
</html>