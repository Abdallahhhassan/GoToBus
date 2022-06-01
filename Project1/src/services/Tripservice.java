package services;


import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	public List<Trip> getAllTrips() {
		  TypedQuery<Trip> query = entityManager.createQuery("SELECT t FROM Trip t", Trip.class);
		  	List<Trip> trips = query.getResultList();

			 return trips;
	}
	
	public Date convertfromStringtoDate(String s)
	{
		 try {
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(s);
			return date1;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}