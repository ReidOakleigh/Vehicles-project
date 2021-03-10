package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/chgVehicle")
public class ChgVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    VehicleHelper vh;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChgVehicleServlet() {
        super();
        vh = new VehicleHelper();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("updateVehicle");
		System.out.println(act);
		String path="/viewVehicles";
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				System.out.println("Delete " + tempId);
				vh.deleteVehicle(tempId);
				
				List<Vehicle> vehicles = vh.findAll();
				request.setAttribute("vehicles", vehicles);
				path = "/vehicle-list.jsp";
				if (vehicles.isEmpty()) path = "/index.html";
				getServletContext().getRequestDispatcher(path).forward(request, response);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an team.");
			}
			
		} else {
			try {
				Integer vinId = Integer.parseInt(request.getParameter("id"));
				Vehicle vehicle = vh.findById(vinId);
				request.setAttribute("vehicle", vehicle);
				path="/edit-vehicle.jsp";
				getServletContext().getRequestDispatcher(path).forward(request, response);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an team.");
			}
		}
	}

}
