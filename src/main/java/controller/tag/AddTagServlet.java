package controller.tag;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Region;
import model.Tag;
import model.User;

import java.io.IOException;

import dal.RegionDao;
import dal.TagDao;

/**
 * Servlet implementation class AddTagServlet
 */
public class AddTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("account");
		if (u == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		request.setAttribute("account", u);
		request.getRequestDispatcher("addTag.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (int) (Math.floor(Math.random()*89999)+10000);
		String name =request.getParameter("name");
		String slug =request.getParameter("slug");
		System.out.println(name);
		System.out.println(slug);
		try {
			TagDao cd = new TagDao();
			Tag c= cd.get(name, slug);
			if (c == null) {
				cd.add(new Tag(id, name, slug));
				response.sendRedirect("tag");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
