package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

public class PostDAO {
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
	
	public void add(PostVO ab) {
		connect();
		String sql = "insert into post values (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ab.getPostId());
			pstmt.setInt(2,  ab.getUserId());
			pstmt.setString(3, ab.getTitle());
			pstmt.setString(4,  ab.getContent());
			pstmt.setDate(5,  (Date) ab.getPostDate());
			pstmt.setInt(6, ab.getCategoryId());
			pstmt.setInt(7, ab.getViews());
			pstmt.setInt(8, ab.getReport());
			pstmt.setString(9, ab.getLang());
			pstmt.setString(10, ab.getCodeContent());
			pstmt.setString(11, ab.getName());
			
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
				ab.setPostDate(rs.getDate("PossDate"));
				ab.setCategoryId(rs.getInt("CategoryID"));
				ab.setViews(rs.getInt("Views"));
				ab.setReport(rs.getInt("Report"));
				ab.setLang(rs.getString("Lang"));
				ab.setCodeContent(rs.getString("CodeContent"));
				ab.setName(rs.getString("Name"));
				
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
	
	public void update (String title, String content, Date postDate, String Lang, String CodeContent, int postId) {
		connect();
	    String sql = "UPDATE post SET Title = ?, Content = ?, PossDate = ?, Lang = ?, CodeContent = ? WHERE PostId = ?";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, title);
	        pstmt.setString(2, content);
	        pstmt.setDate(3, postDate);
	        pstmt.setString(4, Lang);
	        pstmt.setString(5, CodeContent);
	        pstmt.setInt(6, postId);
	        

	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	}
	
	public void delete(int postId) {
	    connect();

	    String sql = "DELETE FROM post WHERE PostID = ?";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, postId);

	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	}
	
	public void increaseReportCount(int postId) {
	    connect();

	    String sql = "UPDATE post SET Report = Report + 1 WHERE postID = ?";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, postId);

	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	}
	
}
