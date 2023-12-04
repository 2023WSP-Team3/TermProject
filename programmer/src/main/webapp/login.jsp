
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <div class=header-login><a href="login.jsp" style="text-decoration-line: none; color: inherit;">로그인</a></div>
            </header-login-container>
        </header>
        <hr style="margin: 0px;">
        <div class="login-form">
            <form method=post name=login action="Login"> PRO: GRAMMAR </h1>
                <input type="text" name="id" class="text-field" placeholder="아이디">
                <input type="password" name="password" class="text-field" placeholder="비밀번호">
                <input type="submit" value="SIGN IN" class="submit-btn">
                <div class="links">
                    <a href="signup_category.html">SIGN UP</a>
                </div>
            </form>
            <%
        		String err_msg = (String)session.getAttribute("err_msg");
        		if(err_msg==null) err_msg = "";
        		
        		session.invalidate();
        	%>
        	<div id="err_msg" class="text-fielr" style="color : red">
        		<%=err_msg %>
        	</div>
        </div>
    </body>
</html>