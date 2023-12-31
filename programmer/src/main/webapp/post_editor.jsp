<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/editor_style.css">
        <link rel="stylesheet" href="css/public_style.css">
        <link href="https://fonts.googleleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Koulen' rel='stylesheet'>
        <title>PRO:GRAMMAR 로그인</title>
    </head>
    <body>
        <header>
            <a href="main.jsp" class="programmar" style="font-size: 30px; flex: 160px;">PRO: GRAMMAR</a>
            <div style="flex: 1"></div>
            <header-login-container>
                <div class=header-login><a href="login.jsp" style="text-decoration-line: none; color: inherit;">로그인</a></div>
            </header-login-container>
        </header>
        <hr style="margin: 0px;">
        <%
			if (request.getParameter("isEdit").compareTo("true") == 0) {
		%>
        <form class="editor-form" name="post" action="RetuchPost" method="post">
		<%
			}
			else {
		%>
        <form class="editor-form" name="post" action="AddPost" method="post">
		<%
			}
		%>
            <div>
                <h1>포스트 제목</h1>
                	<%
						if (request.getParameter("isEdit").compareTo("true") == 0) {
					%>
					<input class="text-field" name="title" type="text" placeholder="제목을 입력해주세요." value="<%=session.getAttribute("postTitle")%>"></br>
					<%
						}
						else {
					%>
					<input class="text-field" name="title" type="text" placeholder="제목을 입력해주세요."></br>
					<%
						}
					%>
                <div style="display: flex">
                    <div style="flex: 1">
                        <h1>게시판 선택</h1>
                        <select name="category" size="1" class="option-style">
                            <option value="normal">일반 게시판</option>
                            <option value="question">질문 게시판</option>
                            <option value="information">정보 게시판</option>
                        </select>
                    </div>
                    <div style="flex: 1">
                        <h1>언어 태그 선택</h1>
                        <select name="lang_tag" size="1" class="option-style">
                            <option value="c">C</option>
                            <option value="c++">C++</option>
                            <option value="java">JAVA</option>
                        </select>
                    </div>
                </div>
                <h1>포스트 내용</h1>
                	<%
						if (request.getParameter("isEdit").compareTo("true") == 0) {
					%>
                	<textarea class="text-field" name="content" placeholder="본문 내용을 입력해주세요." style="height: 400px"><%=session.getAttribute("postContent")%></textarea>
					<%
						}
						else {
					%>
					<textarea class="text-field" name="content" placeholder="본문 내용을 입력해주세요." style="height: 400px"></textarea>
					<%
						}
					%>
                <h1>코드</h1>
                	<%
						if (request.getParameter("isEdit").compareTo("true") == 0 && session.getAttribute("postCodeContent") != "") {
					%>
                	<textarea class="text-field" name="code_content" placeholder="본문 내용을 입력해주세요." style="height: 200px"><%=session.getAttribute("postCodeContent")%></textarea>
					<%
						}
						else {
					%>
					<textarea class="text-field" name="code_content" placeholder="본문 내용을 입력해주세요." style="height: 200px"></textarea>
					<%
						}
					%>
                <button class="submit-btn" value="UPLOAD POST" type="submit"><b>포스트 업로드</b></button>
            </div>
        </form>
    </body>
</html>