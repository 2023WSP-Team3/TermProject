<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" %>
<!DOCTYPE html>
<jsp:useBean id="postDAO" class="db.PostDAO" scope="application"/>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/list_style.css">
        <link rel="stylesheet" href="css/public_style.css">
        <link rel="stylesheet" href="css/question_style.css">
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