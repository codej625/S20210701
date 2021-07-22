<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
/springProject

</head>
<body>
	<%@ include file="../header/header.jsp" %>
    <!-- **MAIN START** -->
    <main>
        <!-- main -->
        <div class="contennts_wrap">
            <div class="ex_section">
                <div class="ex_img" style="background-image: url('${pageContext.request.contextPath}/img/goya.jpg');"></div>
                <div class="ex_btn">
                    <button>기능1</button>
                    <button>기능2</button>
                </div>
            </div>
            <div class="ex_section">
                <div class="ex_img" style="background-image: url('/img/goya.jpg');"></div>
                <div class="ex_btn">
                    <button>기능1</button>
                    <button>기능2</button>
                </div>
            </div>
            <div class="ex_section">
                <div>All the Best 모임.ver</div>
                <div class=""></div>
                <div class=""></div>
            </div>
            <div class="ex_section">
                <div>All the Best 클래스.ver</div>
                <div class=""></div>
                <div class=""></div>
            </div>
        </div>
    </main>
	<%@ include file="../header/footer.jsp" %>
</body>
</html>