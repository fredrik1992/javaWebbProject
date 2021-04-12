package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connector.SqlConnection;
import model.userBean;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	userBean userBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
		
		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		
		if (username != null && password != null) {
			RequestDispatcher rd = request.getRequestDispatcher("Feed.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String uiColor = request.getParameter("uiColor");
		
		System.out.print(uiColor);
	

		userBean = new userBean(username, password);

		if (SqlConnection.connectSQL("login") && userBean.validating()) {
			HttpSession session = request.getSession();

			session.setAttribute("username", username);
			session.setAttribute("password", password);
			Cookie ckUiColor = new Cookie("uiColor", uiColor);

			ckUiColor.setMaxAge(600);
			response.addCookie(ckUiColor);

			RequestDispatcher rd = request.getRequestDispatcher("Feed.jsp");
			rd.forward(request, response);

			System.out.print("connection good and user exists");
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
			// send them to index with a wrong username or password message
		}
	}

}
