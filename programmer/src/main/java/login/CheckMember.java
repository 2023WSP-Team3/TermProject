package login;

import db.*;
import java.util.List;

public class CheckMember {
	UserDAO adao = new UserDAO();
	List<UserVO> userList = adao.getUserList();
	
	public int login(String id, String pw) {
		int handler = 0;
		for (UserVO vo : userList) {
			// 0 : id 오류, 1 : 패스워드 오류, 2 : 성공
			String loginId = vo.getLoginId();
			String password = vo.getPassword();
			
			if(loginId == id) {
				if(password == pw) {
					handler = 0;
					break;
				}
				else {
					handler = 1;
					break;
				}
			}
			else
				handler = 0;
		}
		return handler;
	}
}
