package login;

import db.*;
import java.util.List;
import java.util.ArrayList;

public class CheckMember {

	public List<Integer> login(String id, String pw) {
		
		UserDAO adao = new UserDAO();
		List<UserVO> userList = adao.getUserList();
		List<Integer> handler = new ArrayList<>();
		
		for (UserVO vo : userList) {
			// 0 : id 오류, 1 : 패스워드 오류, 2 : 성공
			String loginId = vo.getLoginId();
			String password = vo.getPassword();
			int userId = vo.getUserId();
			
			if(loginId.equals(id)) {
				if(password.equals(pw)) {
					handler.add(0, 2);
					handler.add(1, userId);
					break;
				}
				else {
					handler.add(0, 1);
					break;
				}
			}
			else
				handler.add(0, 0);
		}
		return handler;
	}
}
