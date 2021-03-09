package controller;

import java.util.List;

import javax.persistence.*;

import model.Vehicle;

public class VehicleHelper {

	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("Cars");

	public void save(Vehicle v) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Vehicle> findAll() {
		EntityManager em = emfactory.createEntityManager();
		List<Vehicle> vehicles = em.createQuery("SELECT v FROM Vehicle v").getResultList();
		em.close();
		return vehicles;
	}

	public Vehicle findById(int id) {
		EntityManager em = emfactory.createEntityManager();
		Vehicle vehicle = em.find(Vehicle.class, id);
		em.close();
		return vehicle;
	}
	
	public void deleteVehicle(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Vehicle vehicle = findById(id);
		em.remove(vehicle);
		em.getTransaction().commit();
		em.close();
	}
}