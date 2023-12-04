package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.PostDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

@WebServlet("/Report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Report() {
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;char=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		int postId = (int)session.getAttribute("postId");
		PostDAO dao = new PostDAO();
		dao.increaseReportCount(postId);
		
		RequestDispatcher view = request.getRequestDispatcher("post.jsp");
		view.forward(request,  response);
	}

}
