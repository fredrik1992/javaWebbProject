package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connector.SqlConnection;
import model.AFeedBean;

/**
 * Servlet implementation class AddTagsController
 */
@WebServlet("/AddTagsController")
public class AddFeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFeedController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("Feed.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();

		String text = request.getParameter("text");
		String tag = request.getParameter("tag");
		
		AFeedBean feed = new AFeedBean(text,tag);

		if (SqlConnection.connectSQL("feed")) { //checks server is good and then adds the feed
			SqlConnection.addFeed(feed);

			String oldFeedData = (String) session.getAttribute("allFeedsData"); // gets the old feed to add new data

			oldFeedData += feed.getTextData() + ";";
			oldFeedData += feed.getTagData() + ";";

			session.setAttribute("allFeedsData", oldFeedData);

			RequestDispatcher rd = request.getRequestDispatcher("Feed.jsp");
			rd.forward(request, response);
		}

	}

}
