<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/login_style.css">
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
                <div class=header-login><a href="login_category.html" style="text-decoration-line: none; color: inherit;">로그인</a></div>
            </header-login-container>
        </header>
        <hr style="margin: 0px;">
        <div class="login-form">
            <form method=post name=login action="/Login">
                <h1 class="programmar" style="font-size: 60px; text-align: center;"> PRO: GRAMMAR </h1>
                <input type="text" name="id" class="text-field" placeholder="아이디">
                <input type="password" name="password" class="text-field" placeholder="비밀번호">
                <input type="submit" value="SIGN IN" class="submit-btn">
                <div class="links">
                    <a href="signup.html">SIGN UP</a>
                </div>
            </form>
        </div>
        <div class="text-field" style="color : red">
        	<%
        		String err_msg = (String)session.getAttribute("err_msg");
        		if(err_msg==null) err_msg = "";
        		
        		session.invalidate();
        	%>
        	<%=err_msg %>
        </div>
    </body>
</html>