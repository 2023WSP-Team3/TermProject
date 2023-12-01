package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			request.setAttribute("msg", "로그인 성공");
			request.setAttribute("sig", 2);
			request.getSession().setAttribute("id", id);
		}
		else if(loginHandle.login(id, pw) == 0){
			request.setAttribute("msg", "아이디를 찾을 수 없습니다");
			request.setAttribute("sig", 0);
		}
		else if(loginHandle.login(id, pw) == 1){
			request.setAttribute("msg", "비밀번호가 일치하지 않습니다");
			request.setAttribute("sig", 1);
		}
	}
}
