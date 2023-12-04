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
		request.setCharacterEncoding("UTF-8");
		
		CommentVO avo = new CommentVO();
		CommentDAO adao = new CommentDAO();
		ArrayList<CommentVO> commentList = adao.getCommentList();
		int size = commentList.size();
		int commentId = 0;
		for (int i=0; i<size; i++) {
			if (i == size-1) {
				CommentVO vo = commentList.get(i);
				commentId = vo.getCommentId() + 1;
			}
		}		
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		String username = (String)session.getAttribute("name");
		int postId = (int)session.getAttribute("postId"); // 변경필요
		avo.setCommentId(commentId);
        avo.setPostId(1);
        avo.setUserId(userId);
        avo.setCommentText(request.getParameter("cmt_content"));
        avo.setCommentDate(currentDate);
        avo.setUserName(username);
        
        adao.add(avo);
        
        RequestDispatcher view = request.getRequestDispatcher("post.jsp");
		view.forward(request,  response);
	}

}
