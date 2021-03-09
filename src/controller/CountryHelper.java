package controller;

import java.util.List;

import javax.persistence.*;

import model.Country;
import model.Vehicle;

/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Mar 7, 2021
 */
public class CountryHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("Cars");
	
	public void save(Country c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Country> findAll(){
		EntityManager em = emfactory.createEntityManager();
		List<Country> countries = 
				em.createQuery("SELECT c FROM Country c").getResultList();
		return countries;
	}

}
