package controller.uploadimage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Servlet implementation class UploadImageServlet
 */
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			Part part =request.getPart(name);
			String realPart = request.getServletContext().getRealPath("/images");
			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (Files.exists(Path.of(realPart))) {
				Files.createDirectory(Path.of(realPart));
			}
			part.write(realPart+"/"+filename);

			System.out.println(filename);
			PrintWriter out = response.getWriter();
			out.print("test");
			out.print(filename);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			Part part =request.getPart(name);
			String realPart = request.getServletContext().getRealPath("/images");
			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (Files.exists(Path.of(realPart))) {
				Files.createDirectory(Path.of(realPart));
			}
			part.write(realPart+"/"+filename);

			System.out.println(filename);
			PrintWriter out = response.getWriter();
			out.print("test");
			out.print(filename);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
