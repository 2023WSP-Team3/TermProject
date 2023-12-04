package board;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import db.*;

@WebServlet("/DeletePost")
public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePost() {
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
		dao.delete(postId);
		
		String selectedCategory = request.getParameter("category");
		String addr = "";
	    if ("question".equals(selectedCategory)) {
	        addr = "question_list.jsp";
	    } else if ("normal".equals(selectedCategory)) {
	        addr = "general_list.jsp";
	    } else if ("information".equals(selectedCategory)) {
	        addr = "info_list.jsp";
	    }
		RequestDispatcher view = request.getRequestDispatcher("main.jsp");
		view.forward(request,  response);
	}

}
