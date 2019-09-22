package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Route;

/**
 * Servlet implementation class editRouteServlet
 */
@WebServlet("/editRouteServlet")
public class editRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editRouteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RouteHelper rh = new RouteHelper();
	    Integer rId = Integer.parseInt(request.getParameter("id"));
	    String name = request.getParameter("name");
	    String difficulty = request.getParameter("difficulty");
	    boolean completed;
	    if (request.getParameter("completed") != null) {
	       completed = true; 
	    } else {
	       completed = false;
	    }
	    Route r = new Route(name, difficulty, completed);
	    r.setId(rId);
	    rh.updateRoute(r);
	    getServletContext().getRequestDispatcher("/viewAllRoutesServlet").forward(request, response);
	}

}
