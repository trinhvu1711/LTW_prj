package controller.region;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

import dal.RegionDao;

/**
 * Servlet implementation class DeleteRegionServlet
 */
public class DeleteRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRegionServlet() {
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
		String id_raw = request.getParameter("id");
		try {
			int id = Integer.parseInt(id_raw);
//			System.out.println(id);
			RegionDao cd = new RegionDao();
			cd.delete(id);
			response.sendRedirect("region");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
