package board;

import java.io.IOException;
import java.sql.Date;
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


@WebServlet("/RetuchPost")
public class RetuchPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RetuchPost() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;char=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		String lang = request.getParameter("lang_tag");
		String code_content = request.getParameter("code_content");
		int postId = (int)session.getAttribute("postId");
		
		PostDAO dao = new PostDAO();
		dao.update(title, content, currentDate, lang, code_content, postId);
		
		RequestDispatcher view = request.getRequestDispatcher("post.jsp?postId="+postId+"&category=1");
		view.forward(request,  response);
	}

}
