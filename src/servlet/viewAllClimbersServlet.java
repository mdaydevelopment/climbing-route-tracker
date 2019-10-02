package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.ClimberHelper;
import model.Climber;

/**
 * Servlet implementation class viewAllClimbersServlet
 */
@WebServlet("/viewAllClimbersServlet")
public class viewAllClimbersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllClimbersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    ClimberHelper ch = new ClimberHelper();
	    List<Climber> cl = ch.getAllClimbers();
	    request.setAttribute("allClimbers", cl);
	    if (cl.isEmpty()) {
	        request.setAttribute("allClimbers", "");
	    }
	    getServletContext().getRequestDispatcher("/ascents-by-climber.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
