package controller.page;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Movie;

import java.io.IOException;
import java.util.List;

import dal.MovieDAO;

/**
 * Servlet implementation class PageServlet
 */
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO md = new MovieDAO();
		String xpage =request.getParameter("page");
		List<Movie> phim = (List<Movie>) request.getAttribute("phim");
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
		request.setAttribute("phim", list);
		request.setAttribute("page", page);
		request.setAttribute("num", num);
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
