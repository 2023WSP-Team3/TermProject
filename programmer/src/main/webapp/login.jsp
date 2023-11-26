<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/login_style.css">
        <link href="https://fonts.googleleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Koulen' rel='stylesheet'>
        <title>PRO:GRAMMAR 로그인</title>
    </head>
    <body>
        <header>
            <a href="test.jsp" class="programmar" style="font-size: 30px;">PRO: GRAMMAR</a>
            <div style="width: 80%"></div>
            <header-login-container>
                <div class=header-login><a href="login.jsp" style="text-decoration-line: none; color: inherit;">로그인</a></div>
            </header-login-container>
        </header>
        <hr>
        <div class="login-form">
            <form method=post name=login action="">
                <h1 class="programmar" style="font-size: 60px; text-align: center;"> PRO: GRAMMAR </h1>
                <input type="text" name="id" class="text-field" placeholder="아이디">
                <input type="password" name="password" class="text-field" placeholder="비밀번호">
                <input type="submit" value="SIGN IN" class="submit-btn">
                <div class="links">
                    <a href="#">SIGN UP</a>
                </div>
            </form>
        </div>
    </body>
</html>