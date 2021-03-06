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

/**
 * Servlet implementation class GetFeedFromTag
 */
@WebServlet("/GetFeedFromTag")
public class GetFeedFromTag extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetFeedFromTag() {
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

		HttpSession session = request.getSession();
		String tag = request.getParameter("choosenTag"); //the tag the user choose
		String allFeedsWithTag = SqlConnection.getFeedsFromTag(tag);

		if (allFeedsWithTag != null) {
			session.setAttribute("allFeedsData", allFeedsWithTag);
			RequestDispatcher rd = request.getRequestDispatcher("Feed.jsp");
			rd.forward(request, response);

		} else {
			session.setAttribute("allFeedsData", "no feeds with this tag found;" + "");
			// have to set value so that session isen't null but a message is shown
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
	}

}
