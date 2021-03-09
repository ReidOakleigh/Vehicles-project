import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import controller.CountryHelper;
import controller.ManufacturerHelper;
import controller.VehicleHelper;
import model.Country;
import model.Manufacturer;
import model.Vehicle;
 
public class CarsTester {

	public static void main(String[] args) {
		CountryHelper ch = new CountryHelper();
//		Country country = new Country("South Korea");
//		ch.save(country);
		List<Country> countries = ch.findAll();
		countries.forEach(System.out::println);
		
		ManufacturerHelper mh = new ManufacturerHelper();
//		Manufacturer manufacturer = new Manufacturer(country, "Hyundai");
//		mh.save(manufacturer);
		List<Manufacturer> manufacturers = mh.findAll();
		manufacturers.forEach(System.out::println);
		
		VehicleHelper vh = new VehicleHelper();
//		Vehicle vehicle = new Vehicle("Santa Fe", LocalDate.now(), "Red", "Auto", 7,
//				new BigDecimal(41.0), manufacturers.get(8));
//		vh.save(vehicle);
		List<Vehicle> vehicles = vh.findAll();
		vehicles.forEach(System.out::println);
	}

}
