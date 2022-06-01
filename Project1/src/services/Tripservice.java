package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.Trip;
import ejb.User;

@Stateless
public class Tripservice {
	@PersistenceContext
    private EntityManager entityManager;
	
	public String add(Trip trip , int id) {
			
			User u =entityManager.find(User.class, id);
			if(u.getRole().equals("admin"))
			{
				entityManager.persist(trip);
				return "success";
			}
			else
			{
				return "false";
			}
	        
	    }
	

}