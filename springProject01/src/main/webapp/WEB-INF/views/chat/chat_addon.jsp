<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <title>Testing websockets</title>

</head>
<body>
<%@ include file="/WEB-INF/views/main/header.jsp"%>
<div id="_chatbox" style="display: none" >
    <fieldset>
        <textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
        <br/>
        <!--  sessionNAME값 -->
        <input type="text" id="name" value="${m_name} ">
        <input id="inputMessage" type="text"/>
        <input type="submit" value="send" onclick="send()" />
    </fieldset>
    </div>
    <img class="chat" src="${pageContext.request.contextPath}/img/chat.png" />
<%@ include file="/WEB-INF/views//main/footer.jsp"%>

</body>
<script>
$(".chat").on({
	"click" : function() {
		if ($(this).attr("src") == "${pageContext.request.contextPath}/img/chat.png") {
            $(".chat").attr("src", "${pageContext.request.contextPath}/img/chathide.png");
            $("#_chatbox").css("display", "block");
        } else if ($(this).attr("src") == "${pageContext.request.contextPath}/img/chathide.png") {
            $(".chat").attr("src", "${pageContext.request.contextPath}/img/chat.png");
            $("#_chatbox").css("display", "none");
        }
		
	}
	
	
})

</script>

    <script type="text/javascript">
        var textarea = document.getElementById("messageWindow");
        var webSocket = new WebSocket('ws://localhost:8181/springProject01/broadcasting');
        var inputMessage = document.getElementById('inputMessage');
        var name = document.getElementById('name');
    webSocket.onerror = function(event) {
      onError(event)
    };
    webSocket.onopen = function(event) {
      onOpen(event)
    };
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
    //상대방
    function onMessage(event) {
        textarea.value += document.getElementById("name").value +" : " + event.data + "\n";
    }
    function onOpen(event) {
        textarea.value += "연결 성공\n";
        
    }
    function onError(event) {
      alert(event.data);
    }
    function send() {
    	//나
        textarea.value += document.getElementById("name").value + " :" + inputMessage.value + "\n";
        webSocket.send(inputMessage.value);
        inputMessage.value = "";
    }
  </script>