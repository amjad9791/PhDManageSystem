package php.manag.sys.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.manag.sys.db.SqlLiteDatabase;

/**
 * @author Crunchify.com
 */

public class AdminMenu extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6192688008912715427L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Calling when AddApplication Button is selected
		if (request.getParameter("addApplication") != null) {
			request.getRequestDispatcher("addApplication.jsp").forward(request,
					response);
		}

		// Calling this clauses when the viewResponses Button got pressed
		else if (request.getParameter("viewResponses") != null) {
			getServletContext().removeAttribute("applicationNr");
			getServletContext().setAttribute("applicationNr", 0);
			request.getRequestDispatcher("viewApplication.jsp").forward(
					request, response);
		}

		// Calling this clauses when the pending Button got pressed
		else if (request.getParameter("addUser") != null) {
			request.getRequestDispatcher("registerUser.jsp").forward(request,
					response);
		}

		// Calling when Upload File Button is selected
		else if (request.getParameter("uploadFile") != null) {
			SqlLiteDatabase sql = new SqlLiteDatabase();
			List<Integer> list = sql.listOfUBNumbers();
			getServletContext().setAttribute("listUbNumber", list);
			request.setAttribute("listUbNumber", list);
			request.getRequestDispatcher("uploadFileProposal.jsp").forward(
					request, response);
		}
		// Calling when ChangePropsalStatus File Button is selected
		else if (request.getParameter("ChangePropsalStatus") != null) {
			SqlLiteDatabase sql = new SqlLiteDatabase();
			List<Integer> list = sql.listOfUBNumbers();
			getServletContext().setAttribute("listUbNumber", list);
			request.setAttribute("listUbNumber", list);
			request.getRequestDispatcher("ChangePropsalStatus.jsp").forward(
					request, response);
		}
		// Calling when ShowProposalByDiscipline File Button is selected
		else if (request.getParameter("ShowProposalByDiscipline") != null) {
			SqlLiteDatabase sql = new SqlLiteDatabase();
			List<Integer> list = sql.listOfUBNumbers();
			getServletContext().setAttribute("listUbNumber", list);
			request.setAttribute("listUbNumber", list);
			request.getRequestDispatcher("ShowProposalByDiscipline.jsp").forward(
					request, response);
		}

	}
}