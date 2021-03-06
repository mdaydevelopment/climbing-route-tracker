package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.RouteHelper;

/**
 * Servlet implementation class viewAllRoutesServlet
 */
@WebServlet("/viewAllRoutesServlet")
public class viewAllRoutesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllRoutesServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RouteHelper rh = new RouteHelper();
        request.setAttribute("allRoutes", rh.getAllRoutes());
        if (rh.getAllRoutes().isEmpty()) {
            request.setAttribute("allRoutes", " ");
        }
        getServletContext().getRequestDispatcher("/route-list.jsp")
                .forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
