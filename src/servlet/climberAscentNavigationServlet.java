package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.AscentHelper;
import helper.ClimberHelper;
import helper.DateThing;
import helper.RouteHelper;
import model.Ascent;
import model.Climber;
import model.Route;

/**
 * Servlet implementation class climberAscentNavigationServlet
 */
@WebServlet("/climberAscentNavigationServlet")
public class climberAscentNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public climberAscentNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AscentHelper ah = new AscentHelper();
        String act = request.getParameter("doThis");
        switch (act) {
        case "edit":
            try {
                ClimberHelper ch = new ClimberHelper();
                RouteHelper rh = new RouteHelper();
                Integer aId = Integer.parseInt(request.getParameter("id"));
                Ascent ascentToEdit = ah.getAscentById(aId);
                List<Climber> cl = ch.getAllClimbers();
                List<Route> rl = rh.getAllRoutes();
                DateThing dt = new DateThing(ascentToEdit.getDate());
                request.setAttribute("ascentToEdit", ascentToEdit);
                request.setAttribute("climbers", cl);
                request.setAttribute("routes", rl);
                request.setAttribute("dateFields", dt);
                getServletContext().getRequestDispatcher("/update-ascent.jsp")
                        .forward(request, response);
            } catch (NumberFormatException e) {
                getServletContext().getRequestDispatcher("/viewAllClimbersServlet")
                        .forward(request, response);
            }

            break;
        case "delete":
            try {
                Integer aId = Integer.parseInt(request.getParameter("id"));
                Ascent ascentToDelete = ah.getAscentById(aId);
                // use ascent.climber to get climber from db and pass back to allClimbersNavigator with "edit ascents"
                ah.deleteAscent(ascentToDelete);
                getServletContext()
                        .getRequestDispatcher("/viewAllClimbersServlet")
                        .forward(request, response);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } finally {
                getServletContext()
                        .getRequestDispatcher("/viewAllClimbersServlet")
                        .forward(request, response);
            }
            break;
        case "add":
            try {
                ClimberHelper ch = new ClimberHelper();
                Integer cId = Integer.parseInt(request.getParameter("climber"));
                Climber c = ch.getClimberById(cId);
                RouteHelper rh = new RouteHelper();
                List<Route> rl = rh.getAllRoutes();
                request.setAttribute("climber", c);
                request.setAttribute("routes", rl);
                getServletContext().getRequestDispatcher("/new-ascent.jsp")
                        .forward(request, response);
            } catch (NumberFormatException e) {
                getServletContext().getRequestDispatcher("/viewAllClimbersServlet")
                        .forward(request, response);
            }
            break;
        default:
            getServletContext().getRequestDispatcher("/viewAllClimbersServlet")
                    .forward(request, response);
            break;
        }
	}

}
