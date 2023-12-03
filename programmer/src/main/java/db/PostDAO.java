package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = 
"jdbc:mysql://localhost/web?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding="
+ "utf8&useSSL=false&serverTimezone=UTC";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "passwd");
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
	
	public void add(PostVO ab) {
		connect();
		String sql = "insert into post values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ab.getPostId());
			pstmt.setInt(2,  ab.getUserId());
			pstmt.setString(3, ab.getTitle());
			pstmt.setString(4,  ab.getContent());
			pstmt.setDate(5,  (Date) ab.getPossDate());
			pstmt.setInt(6, ab.getCategoryId());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public ArrayList<PostVO> getPostList(){
		connect();
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		String sql = "select*from post";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostVO ab = new PostVO();
				ab.setPostId(rs.getInt("PostID"));
				ab.setUserId(rs.getInt("UserID"));
				ab.setTitle(rs.getString("Title"));
				ab.setContent(rs.getString("Content"));
				ab.setPossDate(rs.getDate("PossDate"));
				ab.setCategoryId(rs.getInt("CategoryID"));
				
				postList.add(ab);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return postList;
			
	}
}
