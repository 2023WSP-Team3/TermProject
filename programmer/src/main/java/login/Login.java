package login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import login.CheckMember;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CheckMember loginHandle;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        loginHandle = new CheckMember();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;char=UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		List<String> loginhandle = loginHandle.login(id, pw);
		if(loginhandle.get(0).equals("2")){
			HttpSession session = request.getSession();
		    session.setAttribute("loginId", id);
		    session.setAttribute("userId", Integer.parseInt(loginhandle.get(1)));
		    session.setAttribute("name", loginhandle.get(2));
			RequestDispatcher view = request.getRequestDispatcher("main.html");
			view.forward(request,  response);
		}
		else if(loginhandle.get(0).equals("0")){
			HttpSession session = request.getSession();
			String err_msg = "아이디를 찾을 수 없습니다";
			session.setAttribute("err_msg", err_msg);
			
			response.sendRedirect("login.jsp");
		}
		else if(loginhandle.get(0).equals("1")){
			HttpSession session = request.getSession();
			String err_msg = "비밀번호가 일치하지 않습니다";
			session.setAttribute("err_msg", err_msg);
			
			response.sendRedirect("login.jsp");
		}
	}
}
