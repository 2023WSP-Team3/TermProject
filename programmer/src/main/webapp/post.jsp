<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/list_style.css">
        <link rel="stylesheet" href="css/public_style.css">
        <link rel="stylesheet" href="css/post_style.css">
        <link href="https://fonts.googleleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Koulen' rel='stylesheet'>
        <title>PRO:GRAMMAR 로그인</title>
    </head>
    <body>
        <header>
            <a href="main.jsp" class="programmar" style="font-size: 30px; flex: 160px;">PRO: GRAMMAR</a>
            <div style="flex: 1"></div>
            <header-login-container>
                <div class=header-login>
	                <a href="login.jsp" style="text-decoration-line: none; color: inherit;">
	                	<%
							if (session.getAttribute("loginId") == null)
								out.println("로그인");
							else
								out.println("로그아웃");
						%>
	                </a>
                </div>
            </header-login-container>
        </header>
        <hr style="margin: 0px;">
        <div class="main-form">
            <div class="sidebar-form">
                <h1 style="font-size: 40px">사이드바</h1>
                <ul>
                    <li><a href="question_list.jsp" style="text-decoration-line: none; color: #00C3B2;"><h2>질문게시판</h2></a></li>
                    <li><a href="general_list.jsp" style="text-decoration-line: none; color: inherit;"><h2>일반게시판</h2></a></li>
                    <li><a href="info_list.jsp" style="text-decoration-line: none; color: inherit;"><h2>정보게시판</h2></a></li>
                </ul>
            </div>
            <div class="list-form">
                <div style="display: flex;">
                    <h1 style="font-size: 40px; color: #00C3B2;margin-right: 10px;">Q.</h1>
                    <h1 style="font-size: 40px;">f.write(f"{word}: {mean}\n") 대신 print문</h1>
                </div>
                <div style="display: flex;">
                    <img src="https://media.discordapp.net/attachments/957541344832790609/1180447214741508116/image.png?ex=657d7423&is=656aff23&hm=71a44926ad410d3e32f629da48b635bf1241a14cd2ba598b4d7bd8940252b39e&=&format=webp&quality=lossless" style="max-width: 80px; height: auto">
                    <div style="margin-left: 10px;">
                        <div style="height: 50%; align-items: center; display: flex;">
                            <b style="margin-right: 5px">글쓴이</b>
                            <b style="margin-right: 5px">닉네임</b>
                            <b style="margin-right: 5px">뱃지</b>
                        </div>
                        <div style="height: 50%; align-items: center;">
                            별 개수
                        </div>
                    </div>
                </div>
                <hr>
                <div style="font-size: 20px;">
                    안녕하세요<br>
                    김얍몽입니다<br>
                </div>
                <div class="code-block">
                    awqerba<br>
                    awergb<br>
                </div>
                <hr>
                <form name="comment" action="AddComment.java" method="post">
                    <h1 style="font-size: 30px; margin-right: 10px;">댓글</h1>
                    <textarea class="text-field" type="text" style="width: 100%; height: 180px; vertical-align: top;"></textarea>
                    <button class="submit-btn" value="UPLOAD COMMENT" type="submit" style="width: auto;"><b>작성</b></button>
                </form>
                <hr>
                <div>

                </div>
            </div>
        </div>
    </body>
</html>