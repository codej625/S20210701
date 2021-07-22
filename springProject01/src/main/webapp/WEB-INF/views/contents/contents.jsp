<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/contents.css" />
</head>
<body>
	<%@include file = "/WEB-INF/views/header/header.jsp" %>
	<!-- **MAIN START** -->
	<main>
		<!-- main -->
		<div class="contents_wrap">
			<div>
				<div class="cont_info">
					<div class="offeror">
						<div class="con_img">
							<img src="img/goya.jpg">
						</div>
						<div class="offeror_info">
							<div class="offer_title">개설자정보</div>
							<div class="info_detail">
								<div class="offer_item">
									<div class="offer_img">
										<img src="img/01.jpg">
									</div>
									<h2>강전사</h2>
								</div>
								<div class="offer_item">
									<div class="item_title">이 메 일</div>
									<div class="item_detail">jampbook@naver.com</div>
								</div>
								<div class="offer_item">
									<div class="item_title">전화번호</div>
									<div class="item_detail">010-7167-4987</div>
								</div>
							</div>
							<div class="offer_option">*로그인 후 정보를 볼 수 있습니다.</div>
						</div>
					</div>
					<div class="a">
						<div class="con_tit">모임제목</div>
						<div class="con_sub">가나다라마바사</div>
						<div class="con_hash">
							<a>#스프링</a> <a>#뿌뿌</a>
						</div>
						<div class="meet_info">
							<div class="meet_title">모임기간</div>
							<div class="meet_detail">
								2021.7.11 (일) 08:50 ~ 12:00 <input type="hidden">
							</div>
						</div>
						<div class="meet_info">
							<div class="meet_title">모임장소</div>
							<div class="meet_detail">
								미정이거나 등록된 모임장소가 없습니다. <input type="hidden">
							</div>
						</div>
						<div class="btn_section">
							<button>신청하기</button>
							<button>신청완료</button>
							<button>찜</button>
						</div>
					</div>
				</div>
				<div class="con_detail">
					<div class="con_nav">
						<div class="det_nav">상세정보</div>
						<div class="det_nav">지도</div>
						<div class="det_nav">문의/기대평</div>
						<div class="det_nav">문의/리뷰</div>
						<div class="det_nav">참여/취소안내</div>
					</div>
					<div class="con_item">
						<div class="item_tit">상세정보</div>
						<div class="item_det">그래 그리 쉽지는 않겠지 나를 허락해준 세상이란 손쉽게 다가오는
							편하고도 감미로운 공간이 아냐 그래도 날아오를거야 작은 날개짓에 꿈을 담아 조금만 기다려봐 Oh my- 그래 그리
							쉽지는 않겠지 나를 허락해준 세상이란 손쉽게 다가오는 편하고도 감미로운 공간이 아냐 그래도 날아오를거야 작은 날개짓에
							꿈을 담아 조금만 기다려봐 Oh my love​ 나비처럼 날아가 볼까 일렁거리는 바람에 실려 이런 느낌을 언제나 느낄
							수 있을까 마음 속의 좁혀 오는 사소한 일은 신경쓰지마 지금 이대로 날아가 모두 잊으면 돼 어떻게 WOW WOW
							WOW WOW WOW 하늘 끝까지 닿을 수 있을까 이렇게 WOW WOW WOW WOW WOW 여린 날개가 힘을 낼 수
							있을까 그래 그리 쉽지는 않겠지 나를 허락해준 세상이란 손쉽게 다가오는 편하고도 감미로운 공간이 아냐 그래도
							날아오를거야 작은 날개 밑에 꿈을 담아 조금만 기다려봐 Oh my love</div>
					</div>
					<div class="con_item">
						<div class="item_tit">지도</div>
						<div class="item_det">
							<textarea>임시지도위치</textarea>
						</div>
					</div>
					<div class="con_item">
						<div class="item_tit">문의/기대평</div>
						<div class="item_det">
							<a class="photo"> <img src="img/01.jpg">
							</a>
							<textarea rows="5" cols="70"></textarea>
							<button>등록</button>
							<input type="checkbox">비공개
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
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@include file = "/WEB-INF/views/header/footer.jsp" %>
</body>
</html>