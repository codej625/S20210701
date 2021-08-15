<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@include file="/WEB-INF/views/main/script.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>네이버 로그인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 카카오 로그인 --> 
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<meta name="viewport" content="width=device-width,initial-scale=1">
<style>
</style>
</head>
<body>

<input type="button" onclick="kakaoLogin" value="dddd">

<script type="text/javascript">

// 	Kakao.init("5d25b14933932d1f0479d57932869cd7");

// 	function kakaoLogin() {
//         window.Kakao.Auth.login({
//            scope: '   profile, account_email, gender, birthday',
//            success: function(authObj) {
//               console.log(authObj);
//               window.Kakao.API.request({
//                  url: '/v2/user/me',
//                  success: res => {
//                     const Kakao_account = res.kakao_account;
//                     console.log('authObj-->', authObj);
//                     console.log('Kakao_account-->', Kakao_account);
//                     console.log('Kakao_account-->', Kakao_account.birthday);

//                     var m_id = Kakao_account.email;
//                     var m_pass = Kakao_account;
//                     var m_birth = Kakao_account.birthday;
//                     var m_email = Kakao_account.email;
//                     var m_gender = Kakao_account.gender;

//                     $.ajax({
//                        url: "${pageContext.request.contextPath}/",
//                        data: { m_id: m_id, m_gender: m_gender, m_email: m_email },
//                        dataType: 'text',
//                        success: function(data) {
//                           alert("로그인 되었습니다.");
//                           location.href = "${pageContext.request.contextPath}/main.do";
//                        }
//                     });


//                  }
//               });
//            }
//         });
//      }
	
</script>


</body>
</html>