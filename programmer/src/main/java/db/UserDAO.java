package db;
import java.sql.*;
import java.sql.Date;
import java.util.*;
public class UserDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = 
"jdbc:mysql://localhost/web?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding="
+ "utf8&useSSL=false&serverTimezone=UTC";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "7280plem");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void add(UserVO ab) {
		connect();
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ab.getUserId());
			pstmt.setString(2,  ab.getUserName());
			pstmt.setString(3, ab.getEmail());
			pstmt.setString(4, ab.getPassword());
			pstmt.setInt(5,  ab.getExperiencePoint());
			pstmt.setString(6,  ab.getProfilePicture());
			pstmt.setDate(7, (Date) ab.getRegistrationDate());
			pstmt.setString(8, ab.getUserState());
			pstmt.setString(9, ab.getLoginId());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public ArrayList<UserVO> getUserList(){
		connect();
		ArrayList<UserVO> userList = new ArrayList<UserVO>();
		String sql = "select*from user";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserVO ab = new UserVO();
				ab.setUserId(rs.getInt("UserID"));
				ab.setUserName(rs.getString("Username"));
				ab.setEmail(rs.getString("Email"));
				ab.setPassword(rs.getString("Password"));
				ab.setExperiencePoint(rs.getInt("ExperiencePoint"));
				ab.setProfilePicture(rs.getString("RegistrationDate"));
				ab.setRegistrationDate(rs.getDate("RegistrationDate"));
				ab.setUserState(rs.getString("UserState"));
				ab.setLoginId(rs.getString("LoginID"));
				
				userList.add(ab);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return userList;
		
	}
	
	

}
