package controller.studio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Director;
import model.Studio;
import model.User;

import java.io.IOException;

import dal.DirectorDao;
import dal.StudioDao;

/**
 * Servlet implementation class AddStudioServlet
 */
public class AddStudioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudioServlet() {
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
		request.getRequestDispatcher("addStudio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = (int) (Math.floor(Math.random()*89999)+10000);
		String name =request.getParameter("name");
		String slug =request.getParameter("slug");
		String thumb_url =request.getParameter("thumb_url");
		System.out.println(name);
		System.out.println(slug);
		try {
			StudioDao cd = new StudioDao();
			Studio c = cd.getById(id);
			if (c == null) {
				cd.add(new Studio(id, name, slug, thumb_url));
				response.sendRedirect("studio");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
