<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, db.UserVO, db.UserDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User List JSP</title>
</head>
<body>
    <div align="center">
        <h2>User List</h2>
        <hr>
        <a href="userTest_from.html">Add User</a><p>
        <table border="1" width="500">
            <tr>
                <td>ID</td>
                <td>User Name</td>
                <td>Email</td>
                <td>Password</td>
                <td>Experience Point</td>
                <td>Profile Picture</td>
                <td>Registration Date</td>
                <td>User State</td>
                <td>Login ID</td>
            </tr>
            <%
                UserDAO adao = new UserDAO(); // UserDAO 객체 생성
                List<UserVO> userList = adao.getUserList(); // User 목록 가져오기

                for (UserVO vo : userList) {
            %>
                <tr>
                    <td><%=vo.getUserId() %></td>
                    <td><%=vo.getUserName() %></td>
                    <td><%=vo.getEmail() %></td>
                    <td><%=vo.getPassword() %></td>
                    <td><%=vo.getExperiencePoint() %></td>
                    <td><%=vo.getProfilePicture() %></td>
                    <td><%=vo.getRegistrationDate() %></td>
                    <td><%=vo.getUserState()%></td>
                    <td><%=vo.getLoginId() %></td>
                </tr>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>