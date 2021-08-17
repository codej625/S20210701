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
<link href="${pageContext.request.contextPath}/summernote/summernote-lite.css" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
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
			<form action="${pageContext.request.contextPath}/post/postListUpdate" method="post" enctype="multipart/form-data">
				<input type="hidden" name="p_num" value="${post.p_num }">
				<div class="page_title">개설하기</div>
				<div class="info_section">
					<div class="class_img">
						<img src="${pageContext.request.contextPath}/upload/${post.p_img}">
						<input type="hidden" name="old_p_img" value="${post.p_img}">
						<input type="file" name="p_img" id="file" accept="image/*">
<!-- 						<input type="file" name="p_img" value="사진첨부"> -->
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
								<c:when test="${post.bt_num == 1 }">
									<div class="item_title">
										<input type="hidden" name="bt_num" value="${post.bt_num }" >
										<input type="text" value="모임" readonly="readonly" >
									</div>
								</c:when>
								<c:when test="${post.bt_num == 2 }">
									<div class="item_title">
										<input type="hidden" name="bt_num" value="${post.bt_num }" >
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
						<textarea id="summernote" name="p_info">${post.p_info }</textarea>
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
					</div>
				</div>
				<div class="info_section">
					<div class="section_tit">그룹정보</div>
					<div class="section_con">
						<div class="group_info">
							<div class="info">
								<input type="text" name="p_gname" value="${post.p_gname }">
								정원을 입력하세요
								<input type="number" id="wr_2" name="p_capa" value="${post.p_capa }" min="1" max="30" style="width: 100px;" placeholder="최대 30명">
								<script type="text/javascript">
									$('#wr_2').on('keyup', function() {
										if (this.value > 30 || this.value <= 0) {
											this.value = 30;
											alert('1~30까지만 가능합니다.');
									  	}
									});
								</script>
								<select name="p_cstatus" onchange="dis()">
									<option value="${post.p_cstatus }">
										<c:choose>
											<c:when test="${post.p_cstatus == 0 }">무료</c:when>
											<c:when test="${post.p_cstatus == 1 }">유료</c:when>
										</c:choose>
									</option>
									<option value="0">무료</option>
									<option value="1">유료</option>
								</select>
								<div id="price" style="display: none;">
								<input type="text" onkeyup="inputNumberFormat(this)" value="${post.p_cost }" name="p_cost" placeholder="비용">
								<select name="p_bankname">
									<option value="${post.p_bankname }">${post.p_bankname }</option>
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
								<input type="text" name="p_accountnumber" value="${post.p_accountnumber }" placeholder="예시)111-2222-2222">
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
								<div class="title">모임기간</div>
								<div class="container calendar-container">
									<div id="calendar" style="max-width:900px; margin:40px auto;">
										<p>Date :
										<input type="text" id="metStartDate" name="p_metstart" value="${post.p_metstart }" placeholder="모임시작일">
										<input type="text" id="metEndDate" name="p_metend" value="${post.p_metend }" placeholder="모임종료일">
										<p>Time :
										<input type="time" name="p_starttime" value="${post.p_starttime }" placeholder="모임시작시간">
										<input type="time" name="p_endtime" value="${post.p_endtime }" placeholder="모임종료시간">
									</div>
								</div>
							</div>
							<div class="info">
								<div class="title">신청기간</div>
								<div class="container calendar-container">
									<div id="calendar" style="max-width:900px; margin:40px auto;">
										<p>Date :
										<input type="text" id="appStartDate" name="p_appstart" value="${post.p_appstart }" placeholder="신청시작일">
										<input type="text" id="appEndDate" name="p_append" value="${post.p_append }" placeholder="신청종료일">
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
								<input type="text" id="sample5_address" name="p_loc" value="${post.p_loc }" placeholder="주소">
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