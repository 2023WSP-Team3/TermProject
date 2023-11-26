package login;

public class GetMember {
	private String id;
	private String pw;
	
	public GetMember() {
		
	}
	
	public GetMember(String id, String pwd, String name) {
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setId() {
		this.id = id;
	}
	
	public void setPw() {
		this.pw = pw;
	}
}
