package controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;

/**
 * Servlet implementation class ViewAllVehicles
 */
@WebServlet("/viewVehicles")
public class ViewVehiclesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VehicleHelper vh;
    /**
     * Default constructor. 
     */
    public ViewVehiclesServlet() {
    	vh = new VehicleHelper();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vehicle> vehicles = vh.findAll();
		request.setAttribute("vehicles", vehicles);
		String path = "/vehicle-list.jsp";
		if (vehicles.isEmpty()) path = "/index.html";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
