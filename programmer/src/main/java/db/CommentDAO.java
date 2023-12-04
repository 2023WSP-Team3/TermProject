package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = 
"jdbc:mysql://localhost/webdata?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding="
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
	
	public void add(CommentVO ab) {
		connect();
		String sql = "insert into comment values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ab.getCommentId());
			pstmt.setInt(2, ab.getPostId());
			pstmt.setInt(3,  ab.getUserId());
			pstmt.setString(4,  ab.getCommentText());
			pstmt.setDate(5,  (Date) ab.getCommentDate());
			pstmt.setString(6, ab.getUserName());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public ArrayList<CommentVO> getCommentList(){
		connect();
		ArrayList<CommentVO> commentList = new ArrayList<CommentVO>();
		String sql = "select*from comment";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentVO ab = new CommentVO();
				ab.setCommentId(rs.getInt("CommentID"));
				ab.setPostId(rs.getInt("PostID"));
				ab.setUserId(rs.getInt("UserID"));
				ab.setCommentText(rs.getString("CommentText"));
				ab.setCommentDate(rs.getDate("CommentDate"));
				ab.setUserName(rs.getString("Username"));
				
				commentList.add(ab);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return commentList;
			
	}

}
