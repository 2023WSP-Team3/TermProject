package login;

import db.*;
import java.util.List;
import java.util.ArrayList;

public class CheckMember {

	public List<String> login(String id, String pw) {
		
		UserDAO adao = new UserDAO();
		List<UserVO> userList = adao.getUserList();
		List<String> handler = new ArrayList<>();
		
		for (UserVO vo : userList) {
			// 0 : id 오류, 1 : 패스워드 오류, 2 : 성공
			String loginId = vo.getLoginId();
			String password = vo.getPassword();
			String name = vo.getUserName();
			int userId = vo.getUserId();
			
			if(loginId.equals(id)) {
				if(password.equals(pw)) {
					handler.add(0, "2");
					handler.add(1, ""+userId);
					handler.add(2, name);
					break;
				}
				else {
					handler.add(0, "1");
					break;
				}
			}
			else
				handler.add(0, "0");
		}
		return handler;
	}
}
