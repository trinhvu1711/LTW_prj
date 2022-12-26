package controller.comment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Comment;
import model.ImageProfile;
import model.User;

import java.io.IOException;

import dal.CommentDao;
import dal.ImageProfileDao;

/**
 * Servlet implementation class AddCommentServlet
 */
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movie_id_raw = request.getParameter("movie_id");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("account");
		if (u == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		String username = u.getUsername();
		String name = u.getName();
		ImageProfile image = new ImageProfileDao().getImage(username);
		String path = image.getPath();
		String content = request.getParameter("content");
		System.out.println(content);
		try {
			int movie_id = Integer.parseInt(movie_id_raw);
			Comment c =  new Comment(movie_id, username, content, path, name);
			new CommentDao().addComment(c);

		} catch (Exception e) {
			// TODO: handle exception
		}
		request.getRequestDispatcher("detail?id="+movie_id_raw).forward(request, response);
	}

}
