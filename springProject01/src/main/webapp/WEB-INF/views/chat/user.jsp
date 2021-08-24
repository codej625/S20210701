<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Web Socket Example</title>
<style type="text/css">
/* 전체 */
.container {
	width: 500px;
	margin: 0 auto;
	padding: 25px
}
/* 채팅입력창 */
#textSend {
	width: 500px;
	height:35px;
	padding : 0px;
	border-style: solid;
	border-radius: 30px;
	border-color: #e4dfd9;
}
/* 채팅입력창 */
#textMessage {
position:relative; bottom:20px;
	width: 430px;
	height: 25px;
	margin: 0px;
}

#sendButton {
	width: 500px;
	margin: 0 auto;
}
/* 버튼이미지 */
#buttonimg {
	margin : 5px 0px 5px 0px;
	width: 20px;
	height: 30px;
	object-fit: cover;
}
	

/* 채팅창 */
.messageTextArea {
	text-align: center;
	display: inline-block;
	border-style: solid;
	border-radius: 30px;
	border-color: #e4dfd9;
	background-color: #fff8ed;
	width: 500px;
	height: 500px;
	overflow: auto;
}
/* 본인 text */
.messageTextArea .me {
	 position: relative;
	color: black;
	text-align: right;
	
}
/* 상대방 text */
.messageTextArea .others {
	color: black;
	text-align: left;
}
</style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>


	<div id="container" class="container">
		<!-- 채팅 영역 -->
		<!-- 서버와 메시지를 주고 받는 콘솔 텍스트 영역 -->
		<div id="messageTextArea" class="messageTextArea"></div>
		<br />

		<form id="textSend">
			<!-- 텍스트 박스에 채팅의 내용을 작성한다. -->
			&nbsp;<input id="textMessage" type="text" onkeydown="return enter()"
				style="border: 0px;">&nbsp;&nbsp;&nbsp;
			<!-- 서버로 메시지를 전송하는 버튼 -->
			
			<input id="buttonimg" onclick="sendMessage();return false;"  type="image" src="${pageContext.request.contextPath}/img/sendbutton.png">
			
		</form>
	</div>
	<%@ include file="/WEB-INF/views//main/footer.jsp"%>
</body>
<script type="text/javascript">
	// 서버의 broadsocket의 서블릿으로 웹 소켓을 한다.
	var webSocket = new WebSocket(
			"ws://localhost:8181/springProject01/broadsocket");
	// 콘솔 텍스트 영역
	var messageTextArea = document.getElementById("messageTextArea");

	webSocket.onopen = function(message) {

		$("#messageTextArea").append("안녕하세요 모꼬지입니다! 무엇을 도와드릴까요?</p>");
	};

	webSocket.onerror = function(message) {

		messageTextArea.value += "error...\n";
	};

	webSocket.onmessage = function(message) {

		$("#messageTextArea").append(
				"<p class='others'>(모꼬지) => " + message.data + "</p>");
	};

	function sendMessage() {

		let message = document.getElementById("textMessage");

		$("#messageTextArea").append(
				"<p class='me'>(나) => " + message.value + "</p>");

		webSocket.send(message.value);

		$("#messageTextArea").append(message.value = "");
	}

	function enter() {
		if (event.keyCode === 13) {

			sendMessage();

			return false;
		}
		return true;
	}
</script>


<!-- 
<script type="text/javascript">
// 서버의 broadsocket의 서블릿으로 웹 소켓을 한다.
var webSocket = new WebSocket("ws://localhost:8282/springProject01/broadsocket");
// 콘솔 텍스트 영역
var messageTextArea = document.getElementById("messageTextArea");
// 접속이 완료되면
webSocket.onopen = function(message) {
// 콘솔에 메시지를 남긴다.
messageTextArea.value += "안녕하세요 모꼬지입니다! 무엇을 도와드릴까요?\n";
};
// 접속이 끝기는 경우는 브라우저를 닫는 경우이기 떄문에 이 이벤트는 의미가 없음.
webSocket.onclose = function(message) { };
// 에러가 발생하면
webSocket.onerror = function(message) {
// 콘솔에 메시지를 남긴다.
messageTextArea.value += "error...\n";
};
// 서버로부터 메시지가 도착하면 콘솔 화면에 메시지를 남긴다.
webSocket.onmessage = function(message) {

	messageTextArea.value += "(모꼬지) => " + message.data + "\n";
};
// 서버로 메시지를 발송하는 함수
// Send 버튼을 누르거나 텍스트 박스에서 엔터를 치면 실행
function sendMessage() {
// 텍스트 박스의 객체를 가져옴
let message = document.getElementById("textMessage");
// 콘솔에 메세지를 남긴다.

//messageTextArea.value += "(나) => " + message.value + "\n";
// 소켓으로 보낸다.
webSocket.send(message.value);
// 텍스트 박스 추기화
message.value = "";
}
// 텍스트 박스에서 엔터를 누르면
function enter() {
// keyCode 13은 엔터이다.
if(event.keyCode === 13) {
// 서버로 메시지 전송
sendMessage();
// form에 의해 자동 submit을 막는다.
return false;
}
return true;
}
</script> -->

</html>

