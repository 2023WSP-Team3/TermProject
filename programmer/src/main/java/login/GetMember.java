package login;

public class GetMember {
	private String id;
	private String pw;
	private String name;
	
	public GetMember() {
		
	}
	
	public GetMember(String id, String pwd, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId() {
		this.id = id;
	}
	
	public void setPw() {
		this.pw = pw;
	}
	
	public void setName() {
		this.name = name;
	}
}
