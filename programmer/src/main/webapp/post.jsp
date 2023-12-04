<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*"%>
<!DOCTYPE html>
<jsp:useBean id="commentDAO" class="db.CommentDAO" scope="application"/>
<jsp:useBean id="postDAO" class="db.PostDAO" scope="application"/>
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
                	<%
                		if (Integer.parseInt(request.getParameter("category")) == 1) {
                	%>
                    <li><a href="question_list.jsp" style="text-decoration-line: none; color: #00C3B2;"><h2>질문게시판</h2></a></li>
                    <li><a href="general_list.jsp" style="text-decoration-line: none; color: inherit;"><h2>일반게시판</h2></a></li>
                    <li><a href="info_list.jsp" style="text-decoration-line: none; color: inherit;"><h2>정보게시판</h2></a></li>
                    <%
                		}
                		else if (Integer.parseInt(request.getParameter("category")) == 2) {
                    %>
                    <li><a href="question_list.jsp" style="text-decoration-line: none; color: inherit;"><h2>질문게시판</h2></a></li>
                    <li><a href="general_list.jsp" style="text-decoration-line: none; color: #00C3B2;"><h2>일반게시판</h2></a></li>
                    <li><a href="info_list.jsp" style="text-decoration-line: none; color: inherit;"><h2>정보게시판</h2></a></li>
                    <%
                		}
                		else if (Integer.parseInt(request.getParameter("category")) == 3) {
                    %>
                    <li><a href="question_list.jsp" style="text-decoration-line: none; color: inherit;"><h2>질문게시판</h2></a></li>
                    <li><a href="general_list.jsp" style="text-decoration-line: none; color: inherit;"><h2>일반게시판</h2></a></li>
                    <li><a href="info_list.jsp" style="text-decoration-line: none; color: #00C3B2;"><h2>정보게시판</h2></a></li>
                    <%
                		}
                    %>
                </ul>
            </div>
            <div class="list-form">
                <%					
	                for(PostVO pvo:postDAO.getPostList()) {
	                	if (pvo.getPostId() != Integer.parseInt(request.getParameter("postId")))
	                		continue;
	                	session.setAttribute("postTitle", pvo.getTitle().toString());
	                	session.setAttribute("postContent", pvo.getContent().toString());
	                	if (pvo.getCodeContent() != null)
	                		session.setAttribute("postCodeContent", pvo.getCodeContent().toString());
	                	else
	                		session.setAttribute("postCodeContent", "");
				%>
                <div style="display: flex;">
                    <h1 style="font-size: 40px; color: #00C3B2;margin-right: 10px;">Q.</h1>
                    <h1 style="font-size: 40px;"><%=pvo.getTitle()%></h1>
                </div>
                <div style="display: flex; align-items: center;">
                    <img src="https://media.discordapp.net/attachments/957541344832790609/1180447214741508116/image.png?ex=657d7423&is=656aff23&hm=71a44926ad410d3e32f629da48b635bf1241a14cd2ba598b4d7bd8940252b39e&=&format=webp&quality=lossless" style="max-width: 80px; height: auto">
                    <div style="margin-left: 10px;">
                        <div style="height: 50%; display: flex;">
                            <b style="margin-right: 5px"><%=pvo.getName()%></b>
                        </div>
                    </div>
                </div>
                <div style="display: flex">
                    <div style="flex: 1;"></div>
                	<%
                		if (session.getAttribute("userId") != null) {
                			if(Integer.parseInt(session.getAttribute("userId").toString()) == pvo.getUserId()) {
                	%>
                	<button class="small-btn" type="button" onclick="location.href='post_editor.jsp?isEdit=true'" style="margin-right: 10px;">수정</button>
                    <button class="small-btn" type="button" onclick="location.href='post_editor.jsp'" style="margin-right: 10px; background-color: #ff5252;">삭제</button>
                    <%
                			}
                		}
                    %>
                    <a href="question_list.html" style="text-align: center;">
                        <img src="https://media.discordapp.net/attachments/957541344832790609/1181286222413451374/image.png?ex=65808186&is=656e0c86&hm=acec74f87f33b3e7342f321ee15058c90db8d56b950067da544f4589436a53c5&=&format=webp&quality=lossless" style="max-width: 20px; height: auto">
                    </a>
                </div>
                <div style="font-size: 20px;">
                	<%=pvo.getContent()%>
                </div>
                <%
                	if (pvo.getCodeContent() != null) {
                %>
                <div class="code-block">
                	<%=pvo.getCodeContent()%>
                </div>
                <%
                	}
                %>
                <hr>
                <form name="comment" action="AddComment" method="post">
                    <h1 style="font-size: 30px; margin-right: 10px;">댓글 작성</h1>
                    <textarea name="cmt_content" class="text-field" type="text" style="width: 100%; height: 180px; vertical-align: top;"></textarea>
                    <button class="submit-btn" value="UPLOAD COMMENT" type="submit" style="width: auto;"><b>댓글 작성</b></button>
                </form>
                <hr>
                <div>
                <%
	                for(CommentVO cvo:commentDAO.getCommentList()) {
	                	if (cvo.getPostId() != pvo.getPostId())
	                		continue;
				%>
					<div style="display: flex; align-items: center;">
	                    <img src="https://media.discordapp.net/attachments/957541344832790609/1180447214741508116/image.png?ex=657d7423&is=656aff23&hm=71a44926ad410d3e32f629da48b635bf1241a14cd2ba598b4d7bd8940252b39e&=&format=webp&quality=lossless" style="max-width: 80px; height: auto">
	                    <div style="margin-left: 10px;">
	                        <div style="height: 50%; display: flex;">
	                            <b style="margin-right: 5px"><%=cvo.getUserName()%></b>
	                            <b style="margin-right: 5px"></b>
	                        </div>
	                    </div>
	                </div>
	                <div style="display: flex">
	                    <div style="flex: 1;"></div>
	                    <a href="question_list.html" style="text-align: center;">
	                        <img src="https://media.discordapp.net/attachments/957541344832790609/1181286222413451374/image.png?ex=65808186&is=656e0c86&hm=acec74f87f33b3e7342f321ee15058c90db8d56b950067da544f4589436a53c5&=&format=webp&quality=lossless" style="max-width: 20px; height: auto">
	                    </a>
	                </div>
	                <div style="font-size: 20px;">
	                	<%=cvo.getCommentText()%>
	                </div>
					<hr>
                <%
						}
	                }
				%>
                </div>
            </div>
        </div>
    </body>
</html>