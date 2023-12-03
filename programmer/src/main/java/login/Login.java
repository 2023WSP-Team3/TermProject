package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import login.CheckMember;
import login.GetMember;
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
		if(loginHandle.login(id, pw) == 2) {
			request.getSession().setAttribute("id", id);
			RequestDispatcher view = request.getRequestDispatcher("src/main/webapp/main.html");
			view.forward(request,  response);
		}
		else if(loginHandle.login(id, pw) == 0){
			response.sendRedirect("src/main/webapp/login.jsp");
			request.setAttribute("err_msg", "아이디를 찾을 수 없습니다");
		}
		else if(loginHandle.login(id, pw) == 1){
			response.sendRedirect("src/main/webapp/login.jsp");
			request.setAttribute("err_msg", "비밀번호가 일치하지 않습니다");
		}
	}
}
