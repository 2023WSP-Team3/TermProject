package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResumeDAO {
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
	
	public void add(ResumeVO ab) {
		connect();
		String sql = "insert into resume values(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ab.getResumeId());
			pstmt.setInt(2,  ab.getUserId());
			pstmt.setString(3, ab.getWorkExperience());
			pstmt.setString(4, ab.getEducation());
			pstmt.setString(5, ab.getSkills());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public ArrayList<ResumeVO> getResumeList(){
		connect();
		ArrayList<ResumeVO> resumeList = new ArrayList<ResumeVO>();
		String sql = "select*from category";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ResumeVO ab = new ResumeVO();
				ab.setResumeId(rs.getInt("ResumeID"));
				ab.setUserId(rs.getInt("UserID"));
				ab.setWorkExperience(rs.getString("WorkExperience"));
				ab.setEducation(rs.getString("Education"));
				ab.setSkills(rs.getString("Skills"));
				
				resumeList.add(ab);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return resumeList;
			
	}
}
