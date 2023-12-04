<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" %>
<!DOCTYPE html>
<jsp:useBean id="postDAO" class="db.PostDAO" scope="application"/>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/list_style.css">
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
        <div class="main-form">
            <div class="sidebar-form">
                <h1 style="font-size: 40px">사이드바</h1>
                <ul>
                    <li><a href="question_list.jsp" style="text-decoration-line: none; color: inherit;"><h2>질문게시판</h2></a></li>
                    <li><a href="general_list.jsp" style="text-decoration-line: none; color: #00C3B2;"><h2>일반게시판</h2></a></li>
                    <li><a href="info_list.jsp" style="text-decoration-line: none; color: inherit;"><h2>정보게시판</h2></a></li>
                </ul>
            </div>
            <div class="list-form">
                <h1 style="margin-bottom: 0%;">일반게시판</h1>
                <b style="margin-top: 0%; color: #888888;"><br></b>
                <div style="display: flex;">
                    <form action="general_list.jsp?" mehtod="GET" style="flex: 1;">
                        <input type="text" name="search" style="vertical-align: middle;">
                    </form>
                    <button class="small-btn" type="button" onclick="location.href='post_editor.jsp'">게시글 작성</button>
                </div>
                <button></button>
                <hr style="margin: 20px 0px;">
                <div style="display: flex;">
                    <div style="flex: 2;"></div>
                    <b style="flex: 10; text-align: center; color: #666666;">제목</b>
                    <b style="flex: 2; text-align: center; color: #666666">언어</b>
                    <b style="flex: 2; text-align: center; color: #666666">작성자</b>
                    <b style="flex: 2; text-align: center; color: #666666">작성일</b>
                    <b style="flex: 2; text-align: center; color: #666666">조회</b>
                </div>
                <%					
	                for(PostVO vo:postDAO.getPostList()) {
				%>
						<hr>
		                <div style="display: flex;">
		                    <div style="flex: 2;"></div>
		                    <b style="flex: 10; text-align: center; color: #666666;"><%=vo.getTitle()%></b>
		                    <b style="flex: 2; text-align: center; color: #666666">언어</b>
		                    <b style="flex: 2; text-align: center; color: #666666"><%=vo.getUserId()%></b>
		                    <b style="flex: 2; text-align: center; color: #666666"><%=vo.getPostDate()%></b>
		                    <b style="flex: 2; text-align: center; color: #666666">조회수</b>
		                </div>
                <%
					}
				%>
            </div>
        </div>
    </body>
</html>