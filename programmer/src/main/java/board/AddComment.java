package board;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.*;
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddComment() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;char=UTF-8");
		
		CommentVO avo = new CommentVO();
		
		avo.setCommentId(1);
        avo.setPostId(1);
        avo.setUserId(1);
        avo.setCommentText(request.getParameter("password"));
        avo.setCommentDate(new Date());

        CommentDAO adao = new CommentDAO();
        adao.add(avo);
        
        RequestDispatcher view = request.getRequestDispatcher("post.jsp");
		view.forward(request,  response);
	}

}
