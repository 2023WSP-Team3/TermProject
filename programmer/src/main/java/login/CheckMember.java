package login;

import login.GetMember;
import db.*;
import java.util.List;

public class CheckMember {
	UserDAO adao = new UserDAO();
	List<UserVO> userList = adao.getUserList();
	
	public int login(String id, String pw) {
		// 0 : id 오류, 1 : 패스워드 오류, 2 : 성공
		if(!(userList.get(8).equals(id)))
			return 0;	
		else{
			if(userList.get(3).equals(pw))
				return 2;
			else
				return 1;
		}
	}
}
