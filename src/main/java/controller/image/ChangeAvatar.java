package controller.image;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.ImageProfile;
import model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import dal.ImageProfileDao;

/**
 * Servlet implementation class ChangeAvatar
 */
@MultipartConfig
public class ChangeAvatar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeAvatar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("account");
		if (u == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		request.setAttribute("account", u);
		Part part = request.getPart("file");
		String realPart = request.getServletContext().getRealPath("/images");
		String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
		if (!Files.exists(Path.of(realPart))){
			Files.createDirectory(Path.of(realPart));
		}
		part.write(realPart+"/"+filename);
		String path = "images/"+ filename;
		ImageProfile image = new ImageProfile(filename, path, u.getUsername());
		System.out.println(filename +" "+path);
		new ImageProfileDao().addImage(image);
		request.setAttribute("account", u);
		response.sendRedirect("userprofile");
	}

	public String extractFileName(Part part) {// This method will print the file name.
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
