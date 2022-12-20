package controller.filmfilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Movie;
import model.Region;

import java.io.IOException;
import java.util.List;

import dal.MovieDAO;

/**
 * Servlet implementation class FilmFilterServlet
 */
public class FilmFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO md = new MovieDAO();
		String xpage =request.getParameter("page");
		String type_raw = request.getParameter("type");
		String category_raw = request.getParameter("category");
		String region_raw = request.getParameter("region");
		String year_raw = request.getParameter("year");
		String sort = request.getParameter("sort");
		try {
			Integer type, category, year, region;
			type = (type_raw==null || type_raw.equals(""))?
					0:Integer.parseInt(type_raw);
			region = (region_raw==null || region_raw.equals(""))?
					0:Integer.parseInt(region_raw);
			year = (year_raw==null || year_raw.equals(""))?
					0:Integer.parseInt(year_raw);
			category = (category_raw==null || category_raw.equals(""))?
					0:Integer.parseInt(category_raw);
			Region r = new Region();
			r.setName("Tìm kiếm phim");
			List<Movie> phim = md.getByAllFilmFilter(type, region, year, category, sort);
//			System.out.println(phim.size());
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
			
			List<Movie> list = md.getListByPage(phim, start, end);
			
			List<Movie> topphimle = md.getByTopType(21314);
			List<Movie> topphimbo = md.getByTopType(23432);
			
			request.setAttribute("obj", r);
			request.setAttribute("phim", list);
			request.setAttribute("topphimbo", topphimbo);
			request.setAttribute("topphimle", topphimle);
			request.setAttribute("page", page);
			request.setAttribute("num", num);
		
//			response.sendRedirect("catalogfilter");
		
		} catch (Exception e) {
			System.out.println(e);
		}
		request.getRequestDispatcher("catalogfilter").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
