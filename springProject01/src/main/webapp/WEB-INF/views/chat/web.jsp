<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영상통화</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/web.css" />
</head>
<body>
   <h1>양방향 영상통화</h1>

  <video id="localVideo" autoplay playsinline></video>
  <video id="remoteVideo" autoplay playsinline></video>

  <div>
    <button id="startButton">화면 열기</button>
    <button id="callButton">전화 걸기</button>
    <button id="hangupButton">전화 끊기</button>
   
  </div>

  <script src="https://webrtc.github.io/adapter/adapter-latest.js"></script>
   <script src="${pageContext.request.contextPath}/js/web.js"></script>
   
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
</body>
</html>