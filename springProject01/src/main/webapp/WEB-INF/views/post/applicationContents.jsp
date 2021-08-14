<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/contents.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<!-- **MAIN START** -->
	<main>
		<!-- main -->
		<div class="contents_wrap">
			<div>
				<div class="cont_info">
					<div class="offeror">
					<h2>신청정보</h2> <hr>
						<div class="con_img">
							<img src="${pageContext.request.contextPath}/upload/${post.p_img}" >
						</div>
					</div>
					<div class="a">
						<div class="con_tit">${post.p_title }</div>
						<div class="meet_info">
							<div class="meet_title">모임기간</div>
							<div class="meet_detail">
								2021.7.11 (일) 08:50 ~ 12:00 <input type="hidden">
							</div>
						</div>
						<div class="meet_info">
							<div class="meet_title">모임장소</div>
							<div class="meet_detail">
								${post.p_loc } <input type="hidden">
							</div>
						</div>
						<c:if test="${post.p_cstatus == 1 }">
							<div class="meet_info">
								<div class="meet_title">결제하기</div>
								<div class="meet_detail">
									<button type="button" onclick="dis()">무통장입금</button>
									<div id="price" style="display: none;">
									<table border="1">
										<tr>
											<th>은행</th>
											<td>${post.p_bankname }</td>
										</tr>
										<tr>
											<th>계좌번호</th>
											<td>${post.p_accountnumber }</td>
										</tr>
									</table>
									<button type="button"
									onclick="location.href='${pageContext.request.contextPath}/post/postRegInfoInsert?bt_num=${post.bt_num }&bc_num=${post.bc_num }&p_num=${post.p_num}&p_cstatus=${post.p_cstatus }'">신청하기</button>
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
									${post.p_cost }원
									<button id="check_module" type="button">결제하기</button>
<!-- 								결제 api      -->
									<script type="text/javascript">
										$("#check_module").click(function () {
											var IMP = window.IMP; // 생략가능
											IMP.init('imp24851080');
											// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
											// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
											IMP.request_pay({
												pg: 'kakao', // version 1.1.0부터 지원.
												/*
												'kakao':카카오페이,
												html5_inicis':이니시스(웹표준결제)
												'nice':나이스페이
												'jtnet':제이티넷
												'uplus':LG유플러스
												'danal':다날
												'payco':페이코
												'syrup':시럽페이
												'paypal':페이팔
												*/
												pay_method: 'card',
												/*
												'samsung':삼성페이,
												'card':신용카드,
												'trans':실시간계좌이체,
												'vbank':가상계좌,
												'phone':휴대폰소액결제
												*/
												merchant_uid: 'merchant_' + new Date().getTime(),
												/*
												merchant_uid에 경우
												// https://docs.iamport.kr/implementation/payment
												위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
												참고하세요.
												나중에 포스팅 해볼게요.
												*/
												name: '${post.p_gname}',
												//결제창에서 보여질 이름
												amount: ${post.p_cost},
												//가격
												buyer_email: '${member.m_id}',
												buyer_name: '${member.m_name}',
												buyer_tel: '${member.m_tel}',
												buyer_addr: '${post.p_loc}',
												buyer_postcode: '123-456',
												// m_redirect_url: 'https://www.yourdomain.com/payments/complete'
												/*
												모바일 결제시,
												결제가 끝나고 랜딩되는 URL을 지정
												(카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
												*/
												}, function(rsp) {
												    if ( rsp.success ) {
												    	console.log("hhh");
											            $.ajax({
											                type : "POST",            // HTTP method type(GET, POST) 형식이다.
											                url : "${pageContext.request.contextPath}/post/payments/complete",      // 컨트롤러에서 대기중인 URL 주소이다.
											                data : {'imp_uid' : rsp.imp_uid},            // Json 형식의 데이터이다.
											                success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
											                    // 응답코드 > 0000
											                    console.log(res);
											                    alert("결제 완료!! 신청되었습니다.");
											                    location.href='${pageContext.request.contextPath}/post/postRegInfoInsert?bt_num=${post.bt_num }&bc_num=${post.bc_num }&p_num=${post.p_num}&p_cstatus=${post.p_cstatus }';
											                },
											                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
											                    alert("통신 실패.");
											                }
											            });
												    	
												        
												    } else {
												        msg = '결제에 실패하였습니다.!!';
												        msg += '에러내용 : ' + rsp.error_msg;
												        //실패시 이동할 페이지
												        location.href="${pageContext.request.contextPath}/post/postRegInfoApplication?bt_num=${post.bt_num }&bc_num=${post.bc_num }&p_num=${post.p_num}";
												        alert(msg);
												    }
												});
										});
									</script>
								</div>
							</div>
						</c:if>
					</div>
				</div>
				<div class="con_detail">
					<div class="con_item">
						<div class="item_tit">신청자 정보</div>
						<div class="item_det">
							<table border="1">
								<tr>
									<th>이름</th>
									<td>${member.m_name }</td>
									<th>이메일</th>
									<td>${member.m_id }</td>
									<th>번호</th>
									<td>${member.m_tel }</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="con_item">
						<div class="item_tit">참여/취소안내</div>
						<div class="item_det">
							<div class="can_detail">
								* 모임의 신청/취소/변경/환불은 참여신청 기간 내에만 가능합니다.<br /> * 결제한 유료모임은 환불 시 결제
								수단과 환불 시점에 따라 수수료가 부과될 수 있습니다. 자세한 사항은 <a>취소/환불약관</a>을 확인해주세요.<br />
								* 결제, 환불, 참여신청 수정/취소, 참여상태 확인, 참여내역 확인은 마이페이지에서 할 수 있습니다.<br />
								* 모임 또는 그룹의 설정, 모집정원 초과 여부에 따라 대기자로 선정될 수 있습니다. <a
									href="open.html">자세히보기</a><br /> * 온오프믹스 결제서비스를 이용하는 모임은 개설자의
								사업자 여부에 따라 결제증빙 발행이 가능합니다. <a>자세히보기</a><br /> * 개설자 선정방식 또는 개설자
								통장입금 방식의 모임 참여/결제 확인은 개설자에게 문의 바랍니다.<br /> * 온오프믹스는 참여신청 및 참가비
								결제 기능을 제공하는 회사로 모임개설자(주최측)가 아닙니다. 모임 내용과 관련한 사항은 모임 개설자에게 문의
								바랍니다.
							</div>
							<c:if test="${post.p_cstatus == 0 }">
								<button type="button"
									onclick="location.href='${pageContext.request.contextPath}/post/postRegInfoInsert?bt_num=${post.bt_num }&bc_num=${post.bc_num }&p_num=${post.p_num}&p_cstatus=${post.p_cstatus }'">신청하기</button>
							</c:if>
							<button type="button" 
								onclick="location.href='${pageContext.request.contextPath}/post/postListDetail?bt_num=${post.bt_num }&bc_num=${post.bc_num }&p_num=${post.p_num}'">돌아가기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/main/footer.jsp"%></body>
</html>