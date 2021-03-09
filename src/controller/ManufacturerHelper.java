package controller;

import java.util.List;

import javax.persistence.*;

import model.Manufacturer;

/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Mar 7, 2021
 */
public class ManufacturerHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("Cars");
	
	public void save(Manufacturer m) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Manufacturer> findAll(){
		EntityManager em = emfactory.createEntityManager();
		List<Manufacturer> manufacturers = 
				em.createQuery("SELECT m FROM Manufacturer m").getResultList();
		return manufacturers;
	}
	
	public Manufacturer findManufacturer(String make) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Manufacturer> typedQuery = 
				em.createQuery("select m from Manufacturer m "
						+ "where m.manufacturerName = :selectedMfgr", Manufacturer.class);
		typedQuery.setParameter("selectedMfgr", make);
		List<Manufacturer> manufacturers = typedQuery.getResultList();
		em.close();
		return manufacturers.get(0);
		
	}

}
