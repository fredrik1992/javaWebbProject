package controllers;

import beans.AFeedBean;
import connector.SqlConnection;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetTagsController
 */
@WebServlet("/GetFeedController")
public class GetFeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetFeedController() {
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
		
		String allFeeds = SqlConnection.getAllFeeds(); // gets all feeds of database trough sqlCOnnection
		HttpSession session = request.getSession();
		session.setAttribute("allFeedsData", allFeeds);

		RequestDispatcher rd = request.getRequestDispatcher("Feed.jsp");
		rd.forward(request, response);

		// have to go to sql connection and call funciton to get alot of feed beans in a
		// list that is returned here
		// go trough them all and send them back to Feed where we can do somthing with
		// it
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
