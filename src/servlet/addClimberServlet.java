package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.ClimberHelper;
import model.Climber;

/**
 * Servlet implementation class addClimberServlet
 */
@WebServlet("/addClimberServlet")
public class addClimberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addClimberServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ClimberHelper ch = new ClimberHelper();
	    String fName = request.getParameter("fName");
	    String lName = request.getParameter("lName");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String year = request.getParameter("year");
        LocalDate dob;
        try{
            dob = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        } catch (NumberFormatException ex) {
            dob = LocalDate.now();
        }
	    Climber c = new Climber(fName, lName, dob);
	    ch.insertClimber(c);
	    getServletContext().getRequestDispatcher("/new-climber.html").forward(request, response);
	}

}
