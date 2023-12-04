package db;

import java.util.Date;

public class PostVO {
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostDate() {
		return possDate;
	}
	public void setPostDate(Date possDate) {
		this.possDate = possDate;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getCodeContent() {
		return codeContent;
	}
	public void setCodeContent(String codeContent) {
		this.codeContent = codeContent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int postId;
	private int userId;
	private String title;
	private String content;
	private Date possDate;
	private int categoryId;
	private int views;
	private int report;
	private String lang;
	private String codeContent;
	private String name;
}
