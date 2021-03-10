package controller;

import java.util.List;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Manufacturer;
import model.Vehicle;

/**
 * Servlet implementation class AddVehicleServlet
 */
@WebServlet("/addVehicle")
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VehicleHelper vh;
    private ManufacturerHelper mh;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleServlet() {
        super();
		vh = new VehicleHelper();
		mh = new ManufacturerHelper();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int manId = Integer.parseInt(request.getParameter("make").trim());
		Manufacturer manufacturer = mh.findById(manId);
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
		
		Vehicle vehicle = new Vehicle(model, manDate, color, trans, seats, mpg, manufacturer);
		vh.save(vehicle);
		
		List<Vehicle> vehicles = vh.findAll();
		request.setAttribute("vehicles", vehicles);
		String path = "/vehicle-list.jsp";
		if (vehicles.isEmpty()) path = "/index.html";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
	/**
	 * @see HttpServlet#doGett(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Manufacturer> manufacturers = mh.findAll();
		request.setAttribute("mfgrs", manufacturers);
		getServletContext().getRequestDispatcher("/add-vehicle.jsp").forward(request, response);
	}
}
