<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="avo" class="db.UserVO" />
<jsp:setProperty name="avo" property="*" />
<jsp:useBean id="adao" class="db.UserDAO" scope="application"/>
<%
	adao.add(avo);
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User add jsp</title>
</head>
<body>
	<div align=center>
	<H2>등록 내용</H2>
	유저ID : <jsp:getProperty property="userId" name="avo" /><P>
	유저이름 : <%=avo.getUserName() %><P>
	이메일 : <%=avo.getEmail() %><P>
	비밀번호 : <%=avo.getPassword() %><P>
	경험치 : <%=avo.getExperiencePoint() %><P>
	프로필 : <%=avo.getProfilePicture() %><P>
	등록날짜 : <%=avo.getRegistrationDate() %><P>
	유저상태 : <%=avo.getUserState() %><P>
	로그인ID : <%=avo.getLoginId() %>
	<HR>
	<a href="dbTest.jsp">목록 보기</a>
	</div>
</body>
</html>