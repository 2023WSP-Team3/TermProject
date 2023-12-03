package signup;

import java.io.IOException;
import java.util.Date;

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
		
		avo.setUserId(1);
        avo.setUserName(request.getParameter("name"));
        avo.setEmail(request.getParameter("company_name"));
        avo.setPassword(request.getParameter("password"));
        avo.setExperiencePoint(1);
        avo.setProfilePicture("dd");
        avo.setRegistrationDate(new Date());
        avo.setUserState(request.getParameter("company"));
        avo.setLoginId(request.getParameter("id"));

        UserDAO adao = new UserDAO();
        adao.add(avo);
        
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		view.forward(request,  response);
	}

}
