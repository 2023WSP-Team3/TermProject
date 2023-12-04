package signup;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.*;

@WebServlet("/Singup_company")
public class Singup_company extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public Singup_company() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;char=UTF-8");
		
		UserVO avo = new UserVO();
		UserDAO adao = new UserDAO();
		List<UserVO> userList = adao.getUserList();
		int size = userList.size();
		int userid = 0;
		for (int i=0; i<size; i++) {
			if (i == size-1) {
				UserVO vo = userList.get(i);
				userid = vo.getUserId() + 1;
			}
		}
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		avo.setUserId(userid);
        avo.setUserName(request.getParameter("name"));
        avo.setEmail(request.getParameter("company_name"));
        avo.setPassword(request.getParameter("password"));
        avo.setExperiencePoint(100);
        avo.setProfilePicture("company.jpg");
        avo.setRegistrationDate(currentDate);
        avo.setUserState("일반유저");
        avo.setLoginId(request.getParameter("id"));
        
        adao.add(avo);
        
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		view.forward(request,  response);
	}

}
