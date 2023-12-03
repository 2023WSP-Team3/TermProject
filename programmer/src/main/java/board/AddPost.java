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

        pvo.setPostId(1);
        pvo.setUserId(1);
        pvo.setTitle(request.getParameter("title"));
        pvo.setContent(request.getParameter("content"));
        pvo.setPostDate(new Date());
        pvo.setCategoryId(1);

        PostDAO pdao = new PostDAO();
        pdao.add(pvo);

        RequestDispatcher view = request.getRequestDispatcher("general_list.jsp");
        view.forward(request,  response);
	}
}
