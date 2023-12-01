package login;

import login.GetMember;
// import db.DB; db class 추가

public class CheckMember {
	private DB memberDb; // DB 클래스의 memberDb 인스턴스 생성
	
	public int login(String id, String pw) {
		GetMember getmember = memberDb.checkUser(id); // DB에서 탐색하는 checkDB. 탐색 성공시 id, pw, name 반환
		// 0 : id 오류, 1 : 패스워드 오류, 2 : 성공
		if(getmember == null) {
			return 0;
		}
		else {
			if(getmember.getPw().equals(pw))
				return 2;
			else
				return 1;
		}
	}
	
	public int nameCheck(String name) {
		boolean getname = memberDb.checkName(name); // name 중복검사 중복이면 true, 아니면 false를 반환
		if (getname) {
			return 0; // 중복
		}
		else {
			return 1;
		}
	}
}
