package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.AscentHelper;
import helper.ClimberHelper;
import helper.RouteHelper;
import model.Ascent;
import model.Climber;
import model.Route;

/**
 * Servlet implementation class updateAscentServlet
 */
@WebServlet("/updateAscentServlet")
public class updateAscentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateAscentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    AscentHelper ah = new AscentHelper();
	    RouteHelper rh = new RouteHelper();
	    ClimberHelper ch = new ClimberHelper();
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String year = request.getParameter("year");
        LocalDate ad;
        try{
            ad = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        } catch (NumberFormatException ex) {
            ad = LocalDate.now();
        }
        Integer cId = Integer.parseInt(request.getParameter("climberId"));
        Climber c = ch.getClimberById(cId);
        Integer rId = Integer.parseInt(request.getParameter("route"));
        Route r = rh.getRouteById(rId);
        Ascent a = new Ascent(c, r, ad);
	    ah.updateAscent(a);
	    request.setAttribute("climberToEdit", c);
	    //getServletContext().getRequestDispatcher("/viewAllClimbersServlet").forward(request, response);
	    getServletContext().getRequestDispatcher("/update-climber-ascents.jsp")
                        .forward(request, response);
	}

}
