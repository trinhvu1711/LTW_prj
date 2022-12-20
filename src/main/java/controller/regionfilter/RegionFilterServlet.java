package controller.regionfilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Movie;
import model.Region;

import java.io.IOException;
import java.util.List;

import dal.CategoryDAO;
import dal.MovieDAO;
import dal.RegionDao;

/**
 * Servlet implementation class RegionFilterServlet
 */
public class RegionFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO md = new MovieDAO();
		String id_raw =request.getParameter("id");
		String xpage =request.getParameter("page");

		try {
			int id = Integer.parseInt(id_raw);
			Region region = new RegionDao().getById(id);
			List<Movie> phim = md.getByAllRegion(id);
			System.out.println(phim.size());
			int page, numpage= 24;
			int size = phim.size();
			int num = (size%24==0 ? (size/24):((size/24))+1 );
			if (xpage == null ) page = 1;
			else {
				page = Integer.parseInt(xpage);
			}
			int start, end;
			start = (page-1)*numpage;
			end = Math.min(page*numpage, size);
			
//			System.out.println("start "+start);
//			System.out.println("end "+end);
			List<Movie> list = md.getListByPage(phim, start, end);
			
			List<Movie> topphimle = md.getByTopType(21314);
			List<Movie> topphimbo = md.getByTopType(23432);
			
			request.setAttribute("obj", region);
			request.setAttribute("phim", list);
			request.setAttribute("topphimbo", topphimbo);
			request.setAttribute("topphimle", topphimle);
			request.setAttribute("page", page);
			request.setAttribute("num", num);
			
//			response.sendRedirect("catalogfilter");
			request.getRequestDispatcher("catalogfilter").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
