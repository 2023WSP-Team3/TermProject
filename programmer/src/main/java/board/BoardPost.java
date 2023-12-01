package board;

public class BoardPost {
	private int postId;
    private String title;
    private String content;
    
    public BoardPost() {
    	
    }
    
    public BoardPost(int postId, String title, String content) {
    	this.postId = postId;
    	this.title = title;
    	this.content = content;
    }
    
    public String getTitle(String title) {
    	return title;
    }
    
    public int getPostId(int postId) {
    	return postId;
    }
    
    public String getContent(String content) {
    	return content;
    }
    
    public void setTitle() {
    	this.title = title;
    }
    
    public void setPostId() {
    	this.postId = postId;
    }
    
    public void setContent() {
    	this.content = content;
    }
}
