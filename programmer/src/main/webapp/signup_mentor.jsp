<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	if (session.getAttribute("loginId") != null) {
		session.removeAttribute("loginId");
		session.removeAttribute("userId");
		response.sendRedirect("main.jsp");
	}
%>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/signup_style.css">
        <link rel="stylesheet" href="css/editor_style.css">
        <link rel="stylesheet" href="css/public_style.css">
        <link href="https://fonts.googleleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Koulen' rel='stylesheet'>
        <title>PRO:GRAMMAR 로그인</title>
    </head>
    <body>
        <header>
            <a href="main.html" class="programmar" style="font-size: 30px; flex: 160px;">PRO: GRAMMAR</a>
            <div style="flex: 1"></div>
            <header-login-container>
                <div class=header-login><a href="login.jsp" style="text-decoration-line: none; color: inherit;">로그인</a></div>
            </header-login-container>
        </header>
        <hr style="margin: 0px;">
        <form class="editor-form" name="registration" action="Singup_mentor" method="post">
            <h1>MENTOR로 회원가입 합니다.</h1>
            <div>
                <h3 style="color: #666666">* ID</h3>
                <input class="info-field" name="id" type="text" placeholder="아이디를 입력해주세요."></br>
                <h3 style="color: #666666">* Password</h3>
                <input class="info-field" name="password" type="password" placeholder="비밀번호를 입력해주세요."></br>
                <h3 style="color: #666666">* Name</h3>
                <input class="info-field" name="name" type="text" placeholder="이름을 입력해주세요."></br>
                <h3 style="color: #666666">* GitHub ID</h3>
                <input class="info-field" name="github_id" type="text" placeholder="GitHub ID를 입력해주세요."></br>
                <h3 style="color: #666666">* Portfolio</h3>
                <input class="info-field" name="portfolio" type="text" placeholder="추가 포트폴리오 URL을 입력해주세요."></br>
                <input style="accent-color: #00C3B2" name="info_check" type="checkbox">멘토자격을 확인하기 위해 입력하신 정보를 열람할 수 있음을 동의합니다.
                <button class="submit-btn" value="SIGN UP" type="submit" style="margin-top: 50px;"><b>회원가입</b></button>
            </div>
        </form>
    </body>
</html>