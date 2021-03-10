package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editVehicle")
public class EditVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	VehicleHelper vh;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVehicleServlet() {
        super();
		vh = new VehicleHelper();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String model = request.getParameter("model").trim();
		String date = request.getParameter("date").trim().replace('/', '-');
		LocalDate manDate = LocalDate.parse(date);
		String color = request.getParameter("color").trim();
		String trans = request.getParameter("trans").trim();
		int seats;
		try {
			seats = Integer.parseInt(request.getParameter("seats").trim());
		} catch (NumberFormatException e) {
			seats = 0;
		}
		BigDecimal mpg;
		try {
			mpg = new BigDecimal(request.getParameter("mpg").trim());
		} catch (Exception e) {
			mpg = new BigDecimal(0.0);
		}
			
		int vinId = Integer.parseInt(request.getParameter("vinId").trim());
		Vehicle vehicle = vh.findById(vinId);
		
		vehicle.setModel(model);
		vehicle.setManDate(manDate);
		vehicle.setColor(color);
		vehicle.setTrans(trans);
		vehicle.setSeats(seats);
		vehicle.setMpg(mpg);
		System.out.println("Update " + vehicle);
		vh.update(vehicle);
		
		List<Vehicle> vehicles = vh.findAll();
		request.setAttribute("vehicles", vehicles);
		String path = "/vehicle-list.jsp";
		if (vehicles.isEmpty()) path = "/index.html";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
