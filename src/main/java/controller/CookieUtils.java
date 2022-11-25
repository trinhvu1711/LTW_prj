package controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.User;

public class CookieUtils {
	public static final String name_user = "cname";
	public static void storeLoginedUser(HttpSession session, User user) {
		session.setAttribute("u", user);
	}
	
	public static User getLoginedUser(HttpSession session) {
		User user = (User) session.getAttribute("u");
		return user;
	}
	
	public static String getUserNameInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie: cookies) {
				if (name_user.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
