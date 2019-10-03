package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.ClimberHelper;
import helper.DateThing;
import model.Climber;

/**
 * Servlet implementation class climberNavigationServlet
 */
@WebServlet("/allClimbersNavigationServlet")
public class allClimbersNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allClimbersNavigationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        ClimberHelper ch = new ClimberHelper();
        String act = request.getParameter("doThis");
        switch (act) {
        case "editClimber":
            try {
                Integer cId = Integer.parseInt(request.getParameter("id"));
                Climber climberToEdit = ch.getClimberById(cId);
                DateThing dt = new DateThing(climberToEdit.getDob());
                request.setAttribute("climberToEdit", climberToEdit);
                request.setAttribute("dateFields", dt);
                getServletContext().getRequestDispatcher("/update-climber.jsp")
                        .forward(request, response);
            } catch (NumberFormatException e) {
                getServletContext().getRequestDispatcher("/viewAllClimbersServlet")
                        .forward(request, response);
            }

            break;
        case "editAscents":
            try {
                Integer cId = Integer.parseInt(request.getParameter("id"));
                Climber climberToEdit = ch.getClimberById(cId);
                request.setAttribute("climberToEdit", climberToEdit);
                getServletContext().getRequestDispatcher("/update-climber-ascents.jsp")
                        .forward(request, response);
            } catch (NumberFormatException e) {
                getServletContext().getRequestDispatcher("/viewAllClimbersServlet")
                        .forward(request, response);
            }
            break;
        case "delete":
            try {
                Integer cId = Integer.parseInt(request.getParameter("id"));
                Climber climberToDelete = ch.getClimberById(cId);
                ch.deleteClimber(climberToDelete);
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
            getServletContext().getRequestDispatcher("/new-climber.html")
                    .forward(request, response);
            break;
        default:
            getServletContext().getRequestDispatcher("/viewAllClimbersServlet")
                    .forward(request, response);
            break;
        }
	}

}
