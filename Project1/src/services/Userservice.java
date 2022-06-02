package services;
import javax.ejb.Stateless;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ejb.Booking;
import ejb.Trip;
import ejb.User;

@Stateless

public class Userservice {
	@PersistenceContext
    private EntityManager entityManager;
	
	public void add(User user) {

        entityManager.persist(user);
    }

	public List<User> getAllPersons() {
		  TypedQuery<User> query = entityManager.createQuery("SELECT p FROM User p", User.class);
		  	List<User> persons = query.getResultList();

			  return persons;
	}
	
	public User findUserbyid (int id)
	{
		return entityManager.find(User.class, id);
	}
	public Response login(User u)
	{
		ResponseBuilder builder=Response.noContent();
		boolean x=false;
		for(int i=0;i<getAllPersons().size();i++)
		{
			if(u.getUsername().equals(getAllPersons().get(i).getUsername())&&u.getPassword().equals(getAllPersons().get(i).getPassword()))
			{
				x=true;
				builder = Response.ok();
			}
			
		}
		if(x==true)
		{
			return builder.build();
		}
		else
		{
			builder=Response.status(Response.Status.BAD_REQUEST);
			return builder.build();
		}
	}
	public String book(Booking b)
	{
		entityManager.persist(b);
		User user = entityManager.find(User.class, b.getUser_id());
		Trip trip = entityManager.find(Trip.class, b.getTrip_id());
		
		if(trip.getAvailable_seats()>0)
		{
			user.addtrip(trip);
			trip.adduser(user);
			trip.setAvailable_seats(trip.getAvailable_seats()-1);
			return "success";
			
		}
		else
		{
			return "false";
		}
		
	}
	
	
	
	
}
