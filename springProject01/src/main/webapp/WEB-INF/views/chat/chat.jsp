<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
	<title>chat</title>
	<style>
		*{
			margin:0;
			padding:0;
		}
		.container{
			width: 500px;
			margin: 0 auto;
			padding: 25px
		}
		.container h1{
			text-align: left;
			padding: 5px 5px 5px 15px;
			color: #FFBB00;
			border-left: 3px solid #FFBB00;
			margin-bottom: 20px;
		}
		.chat{
		border-style: solid;
		border-color:#b2b2b2;
			background-color: #b2b2b2;
			width: 500px;
			height: 500px;
			overflow: auto;
		}
		.chat .me{
		
			
			color: white;
			text-align: right;
			border-radius: 50%;
			background-color: #b2b2b2;
			
			
		}
		.chat .others{
			color: white;
			text-align: left;
		}
		input{
			width: 330px;
			height: 25px;
		}
		#yourMsg{
			display: none;
		}
		
		
	</style>
</head>

<script type="text/javascript">
	var ws;

	function wsOpen(){
		console.log("wsOpen  location.host: " + location.host);
        var wsUri  = "ws://" + location.host + "/springProject01/chatting";
 		ws = new WebSocket(wsUri); //웹소켓을 만들어줌
		wsEvt();
	}
		
	function wsEvt() {
		console.log("wsEvt  start... ");
		
		//소켓이 열리면 동작
		ws.onopen = function(data){
		//	alert("data->"+data)
			console.log("wsEvt  소켓이 열리면 초기화 세팅하기..");
			}
		
		//메시지를 받으면 동작
		ws.onmessage = function(data) {
			
			var msg = data.data;
		//	alert("ws.onmessage->"+msg)
			if(msg != null && msg.trim() != ''){
				var jsonMsg = JSON.parse(msg);
			//	var jsonQna = JSON.parse(Qna);
				// 파싱한 객체의 type값을 확인하여 getId값이면 초기 설정된 값이므로 채팅창에 값을 입력하는게 아니라
				// 추가한 태그 sessionId에 값을 세팅
				if(jsonMsg.type == "getId"){
					var sid = jsonMsg.sessionId != null ? jsonMsg.sessionId : "";
					if(sid != ''){
						$("#sessionId").val(sid); 
					}
				}else if(jsonMsg.type == "message"){
				// type이 message인 경우엔 채팅이 발생한 경우.
                // 상대방과 자신을 구분하기 위해 여기서 sessionId값을 사용
                // 최초 이름을 입력하고 연결되었을때, 발급받은 sessionId값을 비교하여 같다면 자기 자신이 발신한
                // 메시지이므로 오른쪽으로 정렬하는 클래스를 처리하고 메시지를 출력.     
                // 비교하여 같지 않다면 타인이 발신한 메시지이므로 왼쪽으로 정렬하는 클래스를 처리하고 메시지를 출력
					if(jsonMsg.sessionId == $("#sessionId").val()){
						$("#chat").append("<p class='me'>나 :" + jsonMsg.msg + "</p>");	
					}else{
						$("#chat").append("<p class='others'>" +"${sessionID}" + " :" + jsonMsg.msg + "</p>");
					}
						
				}else{
					console.warn("unknown type!")
				}
			}
		}

		document.addEventListener("keypress", function(e){
			if(e.keyCode == 13){ //enter press
				send();
			}
		});
	}

	function chatName(){
		//var jb = $( 'select#jbSelect' ).val();
		var userName = $("#userName").val("${sessionID }");
		console.log("chatName  userName: " + userName);
		/* if(userName == null || userName.trim() == ""){
			alert("사용자 이름을 입력해주세요.");
			$("#userName").focus();
		}else{ */
			wsOpen();
			$("#meName").append('나의이름:'+"${sessionID}"); 
			$("#yourName").hide();
			$("#yourMsg").show();
		//}
	}

	function send() {
		var option ={
			type: "message",
			sessionId : $("#sessionId").val(),
			userName : $("#userName").val("${sessionID }"),
			msg : $("#chatting").val(),
		//	Qna : "#jbSelect"
		 }
		ws.send(JSON.stringify(option))
		$('#chatting').val("");
	}
</script>
<body>
 <h1>chat View</h1>
 
	<div id="container" class="container">
		<h1>채팅</h1>
		<input type="hidden" id="sessionId" >
		<div id="meName"></div>
		<div id="chat" class="chat">
		</div>
		
		<div id="yourName">
			<table class="inputTable">
				<tr>
					<th><input type="hidden" name="userName" id="userName" ></th>
					<th>안녕하세요 ${sessionID } 님 반갑습니다. <p>문의유형을 선택해주세요 </th>
					<th>	
					
						<select id="jbSelect">
							<option value="1">[1.모임개설 문의]</option>
							<option value="2"  >[2.클래스개설 문의]</option>
							<option value="3" >[3.모임 참가문의]</option>
						</select> 
					</th> 
					<th><button onclick="chatName()" id="startBtn">채팅시작</button></th>
				</tr>
			</table>
		</div>
		<div id="yourMsg">
			<table class="inputTable">
				<tr>
					<th>메시지</th>
					<th><input id="chatting" placeholder="보내실 메시지를 입력하세요."></th>
					<th><button onclick="send()" id="sendBtn">보내기</button></th>
				</tr>
			</table>
		</div>
	</div>
	
</body>
</html>