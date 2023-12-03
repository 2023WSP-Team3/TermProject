package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO {
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
	
	public void add(CategoryVO ab) {
		connect();
		String sql = "insert into category values(?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ab.getCategoryId());
			pstmt.setString(2,  ab.getCategoryName());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public ArrayList<CategoryVO> getCategoryList(){
		connect();
		ArrayList<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		String sql = "select*from category";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CategoryVO ab = new CategoryVO();
				ab.setCategoryId(rs.getInt("CategoryID"));
				ab.setCategoryName(rs.getString("CategoryName"));
				
				categoryList.add(ab);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return categoryList;
			
	}
}
