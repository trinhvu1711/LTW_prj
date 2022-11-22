package controller.region;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Region;

import java.io.IOException;

import dal.CategoryDAO;
import dal.RegionDao;

/**
 * Servlet implementation class AddRegionServlet
 */
public class AddRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRegionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addRegion.jsp").forward(request, response);
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
			RegionDao cd = new RegionDao();
			Region c= cd.get(name, slug);
			if (c == null) {
				cd.add(new Region(id, name, slug));
				response.sendRedirect("region");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
