package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Route;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RouteHelper rh = new RouteHelper();
        String act = request.getParameter("doThis");
        switch (act) {
        case "edit":
            try {
                Integer rId = Integer.parseInt(request.getParameter("id"));
                Route routeToEdit = rh.getRouteById(rId);
                request.setAttribute("routeToEdit", routeToEdit);
                getServletContext().getRequestDispatcher("/update-route.jsp")
                        .forward(request, response);
            } catch (NumberFormatException e) {
                getServletContext().getRequestDispatcher("/viewAllRoutesServlet")
                        .forward(request, response);
            }

            break;
        case "delete":
            try {
                Integer tId = Integer.parseInt(request.getParameter("id"));
                Route routeToDelete = rh.getRouteById(tId);
                rh.deleteRoute(routeToDelete);
                getServletContext()
                        .getRequestDispatcher("/viewAllRoutesServlet")
                        .forward(request, response);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } finally {
                getServletContext()
                        .getRequestDispatcher("/viewAllRoutesServlet")
                        .forward(request, response);
            }
            break;
        case "add":
            getServletContext().getRequestDispatcher("/index.html")
                    .forward(request, response);
            break;
        default:
            getServletContext().getRequestDispatcher("/viewAllRoutesServlet")
                    .forward(request, response);
            break;
        }
    }

}
