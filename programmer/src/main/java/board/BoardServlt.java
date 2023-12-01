package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

/**
 * Servlet implementation class BoardServlt
 */
@WebServlet("/BoardServlt")
public class BoardServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<BoardPost> posts = new ArrayList<>();
    private int postIdCounter = 1;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;char=UTF-8");
        // 게시글 목록을 보여주는 부분
        // 실제로는 데이터베이스에서 가져와야 함

        for (BoardPost post : posts) {
            out.println("<p>" + post.getTitle() + " - <a href='/board?postId=" + post.getPostId() +
            		"'>수정</a> | <a href='/board?action=delete&postId=" + post.getPostId() + "'>삭제</a></p>");
        }

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;char=UTF-8");
        String action = request.getParameter("action");

        if ("작성".equals(action)) {
            // 게시글 작성 처리 부분
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            BoardPost newPost = new BoardPost(postIdCounter++, title, content);
            posts.add(newPost);
        } else if ("수정".equals(action)) {
            // 게시글 수정 처리 부분
            int postId = Integer.parseInt(request.getParameter("postId"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            for (BoardPost post : posts) {
                if (post.getPostId() == postId) {
                    post.setTitle(title);
                    post.setContent(content);
                    break;
                }
            }
        } else if ("삭제".equals(action)) {
            // 게시글 삭제 처리 부분
            int postId = Integer.parseInt(request.getParameter("postId"));

            posts.removeIf(post -> post.getPostId() == postId);
        }

        // 작업 완료 후 다시 목록으로 리다이렉션
        response.sendRedirect(request.getContextPath() + "/board");
    }      

}
