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
        <link rel="stylesheet" href="css/login_style.css">
        <link rel="stylesheet" href="css/public_style.css">
        <link href="https://fonts.googleleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Koulen' rel='stylesheet'>
        <title>PRO:GRAMMAR</title>
    </head>
    <body>
        <header>
            <a href="main.html" class="programmar" style="font-size: 30px; flex: 160px;">PRO: GRAMMAR</a>
            <div style="flex: 1"></div>
            <header-login-container>
                <div class=header-login>
	                <a href="login.jsp" style="text-decoration-line: none; color: inherit;">
	                	로그인
	                </a>
                </div>
            </header-login-container>
        </header>
        <hr style="margin: 0px;">
        <div style="margin: 10%; display: flex;">
            <a href="signup_mentee.jsp" style="flex: 1; text-align: center;">
                <img src="https://media.discordapp.net/attachments/957541344832790609/1180424652011614319/image.png?ex=657d5f20&is=656aea20&hm=30c3a6ddefd68489caef797492d08792a769cb5a9d23798127ed75f7e0e793d6&=&format=webp&quality=lossless&width=476&height=676" style="max-width: 70%; height: auto">
            </a>
            <a href="signup_mentor.jsp" style="flex: 1; text-align: center;">
                <img src="https://media.discordapp.net/attachments/957541344832790609/1180424630339637338/image.png?ex=657d5f1b&is=656aea1b&hm=528d79feecd195e6d59ca1ff0af9f0004d73196f84db34423159ec3093c17202&=&format=webp&quality=lossless&width=476&height=676" style="max-width: 70%; height: auto">
            </a>
            <a href="signup_company.jsp" style="flex: 1; text-align: center;">
                <img src="https://media.discordapp.net/attachments/957541344832790609/1180424593496879225/image.png?ex=657d5f12&is=656aea12&hm=3e4c5680c1133abbf32daed93e718be430f7e0c4234e68815bf5fe1169d10992&=&format=webp&quality=lossless&width=476&height=676" style="max-width: 70%; height: auto">
            </a>
        </div>
    </body>
</html>