<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/open.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/smarteditor211/js/HuskyEZCreator.js" charset="utf-8"></script>
<!-- calendar를 위한 라이브러리들 지우면 안됨 -->
<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<!-- <script src='https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/moment.min.js'></script> -->
<!-- <link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.css'rel='stylesheet'/> -->
<!-- <link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.print.css' rel='stylesheet' media='print'/> -->
<!-- <script src='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.js'></script> -->

<link href="${pageContext.request.contextPath}/summernote/summernote-lite.css" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<!-- <script src="https://code.jquery.coms/jquery-3.5.1.min.js"></script>  -->
<%-- <script src="${pageContext.request.contextPath}/summernote/summernote-lite.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/summernote/lang/summernote-ko-KR.js"></script> --%>
<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script> -->
<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script> -->
<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script> -->
<!-- <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" /> -->

<script type="text/javascript">
function inputNumberFormat(obj) {


// 	alert(JSON.stringify(obj));
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
			<form action="${pageContext.request.contextPath}/post/insert" method="post" enctype="multipart/form-data">
				<input type="hidden" name="p_num" value="${p_num }">
				<div class="page_title">개설하기</div>
				<div class="info_section">
					<div class="class_img">
<!-- 						<div id="image_container" ></div>  -->
<!-- 						<input type="file" name="p_img" onchange="setThumbnail(event);"> -->
						<input type="file" name="p_img" id="file" accept="image/*">
						<div id="preview"></div>
						<div class="file-edit-icon">
					    	<a href="#" class="preview-edit">수정</a>
					    	<a href="#" class="preview-de">삭제</a>
						</div>
<!-- 						이미지 미리보는 스크립트 -->
						<script type="text/javascript">
						function handleFileSelect(event) {
						    var input = this;
						    console.log(input.files)
						    if (input.files && input.files.length) {
						        var reader = new FileReader();
						        this.enabled = false
						        reader.onload = (function (e) {
						        console.log(e)
						            $("#preview").html(['<img class="thumb" src="', e.target.result, '" title="', escape(e.name), '"/>'].join(''))
						        });
						        reader.readAsDataURL(input.files[0]);
						    }
						}
						$('#file').change(handleFileSelect);
						$('.file-edit-icon').on('click', '.preview-de', function () {
						    $("#preview").empty()
						    $("#file").val("");
						});
						$('.preview-edit').click( function() {
						  $("#file").click();
						} );
						</script>
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
									<option value="1">게임/만화/애니</option>
									<option value="2">영화/음악/그림</option>
									<option value="3">스포츠/레저</option>
									<option value="4">반려동물</option>
									<option value="5">패션/미용</option>
									<option value="6">건강/다이어트</option>
									<option value="7">가족/육아</option>
									<option value="8">컴퓨터/통신</option>
									<option value="9">외국어/인문/과학</option>
									<option value="10">경제/금융/정치/사회</option>
									<option value="11">문학/창작</option>
									<option value="12">기타</option>
								</select>
								<input type="text" name="p_title" placeholder="모임명을 입력해주세요">
							</div>
							<div class="section_con">
								<div class="item_title">문의연락처</div>
<!-- 								이부분은 로그인부분과 연결시켜서 sessionId값을 불러와서 넣어줘야된다 -->
<%-- 								이런식으로	<input type="text" name="m_name" value="${m_name }"> --%>
								<div class="item_content">
									<a>담당자아이디</a> <input type="text" name="m_id" value="${sessionID }" readonly="readonly" >
									<a>담당자이름</a> <input type="text" value="${post.m_name }" readonly="readonly" >
									<a>담당자번호</a> <input type="tel" value="${post.m_tel }" readonly="readonly" >
								</div>
							</div>
							<div class="section_con">
								<div class="item_title">간단소개</div>
								<div class="item_content">
									<input type="text" name="p_intro" placeholder="100자 이내" style="width: 600px; height: 50px;">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="info_section">
					<div class="section_tit">상세정보</div>
					<div class="section_con">
						  <textarea id="summernote" name="p_info"></textarea>
						  <script>
						  $(document).ready(function() {

								var toolbar = [
									    // 글꼴 설정
									    ['fontname', ['fontname']],
									    // 글자 크기 설정
									    ['fontsize', ['fontsize']],
									    // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
									    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
									    // 글자색
									    ['color', ['forecolor','color']],
									    // 표만들기
									    ['table', ['table']],
									    // 글머리 기호, 번호매기기, 문단정렬
									    ['para', ['ul', 'ol', 'paragraph']],
									    // 줄간격
									    ['height', ['height']],
									    // 그림첨부, 링크만들기, 동영상첨부
									    ['insert',['picture','link','video']],
									    // 코드보기, 확대해서보기, 도움말
									    ['view', ['codeview','fullscreen', 'help']]
									  ];

								var setting = {
							            height : 300,
							            minHeight : null,
							            maxHeight : null,
							            focus : true,
							            lang : 'ko-KR'
// 							            callbacks : { //여기 부분이 이미지를 첨부하는 부분
// 							            onImageUpload : function(files, editor,
// 							            welEditable) {
// 							            for (var i = files.length - 1; i >= 0; i--) {
// 							            uploadSummernoteImageFile(files[i],
// 							            this);
// 							            		}
// 							            	}
// 							            }
							         };

							        $('#summernote').summernote(setting);
							        });
						  
								  function uploadSummernoteImageFile(file, el) {
										data = new FormData();
										data.append("file", file);
										$.ajax({
											data : data,
											type : "POST",
											url : "uploadSummernoteImageFile",
											contentType : false,
											enctype : 'multipart/form-data',
											processData : false,
											success : function(data) {
												$(el).summernote('editor.insertImage', data.url);
											}
										});
									}
						  </script>
						
<!-- 						<textarea name="p_info" id="ir1" rows="10" cols="100">에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면 됩니다.</textarea> -->
<!-- <!-- 					textarea부분 script --> -->
<!-- 						<script type="text/javascript"> -->
<!-- // 							var oEditors = []; -->
<!-- // 							nhn.husky.EZCreator.createInIFrame({ -->
<!-- // 								oAppRef : oEditors, -->
<!-- // 								elPlaceHolder : "ir1", -->
<%-- // 								sSkinURI : "${pageContext.request.contextPath}/smarteditor211/SmartEditor2Skin.html", --%>
<!-- // 								fCreator : "createSEditor2", -->
<!-- // 								htParams : {  -->
<!-- // 									// 툴바 사용 여부 (true:사용/ false:사용하지 않음)  -->
<!-- // 									bUseToolbar : true,  -->
<!-- // 									// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)  -->
<!-- // 									bUseVerticalResizer : false,  -->
<!-- // 									// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)  -->
<!-- // 									bUseModeChanger : false  -->
<!-- // 								} -->
<!-- // 							}); -->
<!-- // 							$(function() {  -->
<!-- // 								$("#savebutton").click(function() {  -->
<!-- // 									oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);  -->
<!-- // 									//textarea의 id를 적어줍니다.  -->
									
<!-- // 									var selcatd = $("#selcatd > option:selected").val();  -->
<!-- // 									var title = $("#title").val();  -->
<!-- // 									var content = document.getElementById("smartEditor").value;;  -->
									
<!-- // 									if (selcatd == "") {  -->
<!-- // 										alert("카테고리를 선택해주세요.");  -->
<!-- // 										return;  -->
<!-- // 									}  -->
<!-- // 									if (title == null || title == "") {  -->
<!-- // 										alert("제목을 입력해주세요.");  -->
<!-- // 										$("#title").focus();  -->
<!-- // 										return;  -->
<!-- // 									}  -->
<!-- // 									if(content == "" || content == null || content == '&nbsp;' ||  -->
<!-- // 													content == '<br>' || content == '<br/>' || content == '<p>&nbsp;</p>'){  -->
<!-- // 										alert("본문을 작성해주세요.");  -->
<!-- // 										oEditors.getById["smartEditor"].exec("FOCUS"); //포커싱  -->
<!-- // 										return;  -->
<!-- // 									} //이 부분은 스마트에디터 유효성 검사 부분이니 참고하시길 바랍니다.  -->
<!-- // 									var result = confirm("발행 하시겠습니까?");  -->
<!-- // 									if(result){  -->
<!-- // 										alert("발행 완료!");  -->
<!-- // 										$("#noticeWriteForm").submit();  -->
<!-- // 									}else{  -->
<!-- // 										return;  -->
<!-- // 									}  -->
<!-- // 								});  -->
<!-- // 							}) -->
<!-- 						</script> -->
					</div>
				</div>
				<div class="info_section">
					<div class="section_tit">그룹정보</div>
					<div class="section_con">
						<div class="group_info">
							<div class="info">
								<input type="text" name="p_gname" placeholder="그룹명을 입력하세요.">
								정원을 입력하세요
								<input type="number" id="wr_2" name="p_capa" min="1" max="30" style="width: 100px;" placeholder="최대 30명">
								<script type="text/javascript">
									$('#wr_2').on('keyup', function() {
										if (this.value > 30 || this.value <= 0) {
											this.value = 30;
											alert('1~30까지만 가능합니다.');
									  	}
									});
								</script>
								<select name="p_cstatus" onchange="dis()">
									<option value="0">무료</option>
									<option value="1">유료</option>
								</select>
								<div id="price" style="display: none;">
								<input type="text" onkeyup="inputNumberFormat(this)" name="p_cost" placeholder="비용">
								<select name="p_bankname">
									<option value="">없음</option>
									<option value="신한은행">신한은행</option>
									<option value="국민은행">국민은행</option>
									<option value="우리은행">우리은행</option>
									<option value="SC제일은행">SC제일은행</option>
									<option value="KEB하나은행">KEB하나은행</option>
									<option value="외한은행">외한은행</option>
									<option value="기업은행">기업은행</option>
									<option value="농협은행">농협은행</option>
									<option value="부산은행">부산은행</option>
								</select>
								<input type="text" name="p_accountnumber" placeholder="예시)111-2222-2222">
								</div>
								<script type="text/javascript">
							        function dis(){
							            if($('#price').css('display') == 'none'){
							            $('#price').show();
								        }else{
								            $('#price').hide();
								        }
							        }
							    </script>
							</div>
							<div class="info">
								<div class="title">신청기간</div>
								<div class="container calendar-container">
									<div id="calendar" style="max-width:900px; margin:40px auto;">
										<p>Date :
										<input type="text" id="metStartDate" name="p_metstart" placeholder="모임시작일">
										<input type="text" id="metEndDate" name="p_metend" placeholder="모임종료일">
										<p>Time :
										<input type="time" name="p_starttime" placeholder="모임시작시간">
										<input type="time" name="p_endtime" placeholder="모임종료시간">
									</div>
								</div>
							</div>
							<div class="info">
								<div class="title">신청기간</div>
								<div class="container calendar-container">
									<div id="calendar" style="max-width:900px; margin:40px auto;">
										<p>Date :
										<input type="text" id="appStartDate" name="p_appstart" placeholder="신청시작일">
										<input type="text" id="appEndDate" name="p_append" placeholder="신청종료일">
<!-- 										날짜 관리해주는 스크립트 -->
										<script>
								            $(function() {
								                //오늘 날짜를 출력
								                $("#appEndDate").text(new Date().toLocaleDateString());
								                //datepicker 한국어로 사용하기 위한 언어설정
								                $.datepicker.setDefaults($.datepicker.regional['ko']); 
								                
								              //모든 datepicker에 대한 공통 옵션 설정
									            $.datepicker.setDefaults({
									                dateFormat: 'yy-mm-dd' //Input Display Format 변경
									                ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
									                ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
									                ,changeYear: true //콤보박스에서 년 선택 가능
									                ,changeMonth: true //콤보박스에서 월 선택 가능                
									                ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
									                ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
									                ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
									                ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
									                ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
									                ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
									                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
									                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
									                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
									                ,minDate: "today" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
									                ,maxDate: "+1Y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                    
									            });
								                
								                // 시작일(fromDate)은 종료일(toDate) 이후 날짜 선택 불가
								                // 종료일(toDate)은 시작일(fromDate) 이전 날짜 선택 불가
								                
								                //시작일.
								                $('#metStartDate').datepicker({
								                    onClose: function( selectedDate ) {    
								                        // 시작일(fromDate) datepicker가 닫힐때
								                        // 종료일(toDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
								                        $("#metEndDate").datepicker( "option", "minDate", selectedDate );
								                        $("#appStartDate").datepicker( "option", "maxDate", selectedDate );
								                        $("#appEndDate").datepicker( "option", "maxDate", selectedDate );
								                    }                
								                });
								
								                //종료일
								                $('#metEndDate').datepicker({
								                    onClose: function( selectedDate ) {
								                        // 종료일(toDate) datepicker가 닫힐때
								                        // 시작일(fromDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
								                        $("#metStartDate").datepicker( "option", "maxDate", selectedDate );
								                    }                
								                });
								                
								                //시작일.
								                $('#appStartDate').datepicker({
								                    onClose: function( selectedDate ) {    
								                        // 시작일(fromDate) datepicker가 닫힐때
								                        // 종료일(toDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
								                        $("#appEndDate").datepicker( "option", "minDate", selectedDate );
								                    }                
								                });
								
								                //종료일
								                $('#appEndDate').datepicker({
								                    onClose: function( selectedDate ) {
								                        // 종료일(toDate) datepicker가 닫힐때
								                        // 시작일(fromDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
								                        $("#appStartDate").datepicker( "option", "maxDate", selectedDate );
								                    }                
								                });
								            });
								        </script> 
									</div>
								</div>
							</div>
							<div class="info">
<!-- 								<input type="checkbox">장소없음 <input type="text" name="p_loc" placeholder="장소"> -->
								
								<input type="text" id="sample5_address" name="p_loc" placeholder="주소">
								<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
								<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
								
								<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
								<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6fdc4b499f6102a4487b9dceb7cce1ba&libraries=services"></script>
								<script>
								    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
								        mapOption = {
								            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
								            level: 4 // 지도의 확대 레벨
								        };
								
								    //지도를 미리 생성
								    var map = new daum.maps.Map(mapContainer, mapOption);
								    //주소-좌표 변환 객체를 생성
								    var geocoder = new daum.maps.services.Geocoder();
								    //마커를 미리 생성
								    var marker = new daum.maps.Marker({
								        position: new daum.maps.LatLng(37.537187, 127.005476),
								        map: map
								    });
								
								    function sample5_execDaumPostcode() {
								        new daum.Postcode({
								            oncomplete: function(data) {
								                var addr = data.address; // 최종 주소 변수
								
								                // 주소 정보를 해당 필드에 넣는다.
								                document.getElementById("sample5_address").value = addr;
								                // 주소로 상세 정보를 검색
								                geocoder.addressSearch(data.address, function(results, status) {
								                    // 정상적으로 검색이 완료됐으면
								                    if (status === daum.maps.services.Status.OK) {
								
								                        var result = results[0]; //첫번째 결과의 값을 활용
								
								                        // 해당 주소에 대한 좌표를 받아서
								                        var coords = new daum.maps.LatLng(result.y, result.x);
								                        // 지도를 보여준다.
								                        mapContainer.style.display = "block";
								                        map.relayout();
								                        // 지도 중심을 변경한다.
								                        map.setCenter(coords);
								                        // 마커를 결과값으로 받은 위치로 옮긴다.
								                        marker.setPosition(coords)
								                    }
								                });
								            }
								        }).open();
								    }
								</script>
								
								
<!-- 								<div id="map" style="width:500px;height:400px;"> -->
<!-- 								</div> -->
<!-- 								<script src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=6fdc4b499f6102a4487b9dceb7cce1ba"></script> -->
<!-- 								<script> -->
<!-- // 									var mapContainer = document.getElementById("map"), // 지도를 표시할 div  -->
<!-- // 									    mapOption = { -->
<!-- // 									        center: new kakao.maps.LatLng(37.55654, 126.94508), // 지도의 중심좌표 -->
<!-- // 									        level: 5, // 지도의 확대 레벨 -->
<!-- // 									        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류 -->
<!-- // 									    };  -->
							
<!-- // 									// 지도를 생성한다  -->
<!-- // 									var map = new kakao.maps.Map(mapContainer, mapOption);  -->
							
<!-- // 									// 지도에 마커를 생성하고 표시한다 -->
<!-- // 									var marker = new kakao.maps.Marker({ -->
<!-- // 									    position: new kakao.maps.LatLng(37.55654, 126.94508), // 마커의 좌표 -->
<!-- // 									    map: map // 마커를 표시할 지도 객체 -->
<!-- // 									}); -->

<!-- // 									// 마커 위에 표시할 인포윈도우를 생성한다 -->
<!-- // 									var infowindow = new kakao.maps.InfoWindow({ -->
<!-- // 									    content : '<div style="padding:5px;">중앙정보처리학원</div>' // 인포윈도우에 표시할 내용 -->
<!-- // 									}); -->

<!-- // 									// 인포윈도우를 지도에 표시한다 -->
<!-- // 									infowindow.open(map, marker); -->
									
<!-- // 									// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다 -->
<!-- // 									var zoomControl = new kakao.maps.ZoomControl(); -->
<!-- // 									map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT); -->
							
<!-- 								</script> -->
<!-- 								<button>검색</button> -->
<!-- 								<textarea>임시지도위치</textarea> -->
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
<!-- 						<input type="text" id="price" onkeyup="inputNumberFormat(this)" name="p_cost" value="0" placeholder="비용"> -->
					</div>
				</div>
				<div class="info_section">
					<div class="section_tit">태그</div>
					<div class="section_con">
						<div class="title">
							<p>한개 이상 선택하세요</p>
							<input type="checkbox" name="p_tag" value="게임/만화/애니" checked="checked">게임/만화/애니
							<input type="checkbox" name="p_tag" value="영화/음악/그림">영화/음악/그림
							<input type="checkbox" name="p_tag" value="스포츠/레저">스포츠/레저
							<input type="checkbox" name="p_tag" value="반려동물">반려동물
							<input type="checkbox" name="p_tag" value="패션/미용">패션/미용
							<input type="checkbox" name="p_tag" value="건강/다이어트">건강/다이어트
							<input type="checkbox" name="p_tag" value="가족/육아">가족/육아
							<input type="checkbox" name="p_tag" value="컴퓨터/통신">컴퓨터/통신
							<input type="checkbox" name="p_tag" value="외국어/인문/과학">외국어/인문/과학
							<input type="checkbox" name="p_tag" value="경제/금융/정치/사회">경제/금융/정치/사회
							<input type="checkbox" name="p_tag" value="문학/창작">문학/창작
							<input type="checkbox" name="p_tag" value="기타">기타
						</div>
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