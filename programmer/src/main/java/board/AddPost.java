package board;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.*;

@WebServlet("/AddPost")
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPost() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;char=UTF-8");
        PostVO pvo = new PostVO();
        PostDAO pdao = new PostDAO();
        ArrayList<PostVO> postList = pdao.getPostList();
		int size = postList.size();
		int postId = 0;
		for (int i=0; i<size; i++) {
			if (i == size-1) {
				PostVO vo = postList.get(i);
				postId = vo.getPostId() + 1;
			}
		}
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		String selectedCategory = request.getParameter("category");
		int categoryValue = 0;
	    if ("question".equals(selectedCategory)) {
	        categoryValue = 1;
	    } else if ("normal".equals(selectedCategory)) {
	        categoryValue = 2;
	    } else if ("information".equals(selectedCategory)) {
	        categoryValue = 3;
	    }
        pvo.setPostId(postId);
        pvo.setUserId(userId);
        pvo.setTitle(request.getParameter("title"));
        pvo.setContent(request.getParameter("content"));
        pvo.setPostDate(currentDate);
        pvo.setCategoryId(categoryValue);

        pdao.add(pvo);
        
        session.setAttribute("postId", postId);
        RequestDispatcher view = request.getRequestDispatcher("general_list.jsp");
        view.forward(request,  response);
	}
}
