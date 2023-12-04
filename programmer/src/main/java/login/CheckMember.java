package login;

import db.*;
import java.util.List;

public class CheckMember {

	public int login(String id, String pw) {
		int handler = 0;
		UserDAO adao = new UserDAO();
		List<UserVO> userList = adao.getUserList();
		for (UserVO vo : userList) {
			// 0 : id 오류, 1 : 패스워드 오류, 2 : 성공
			String loginId = vo.getLoginId();
			String password = vo.getPassword();
			
			if(loginId.equals(id)) {
				if(password.equals(pw)) {
					handler = 2;
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
