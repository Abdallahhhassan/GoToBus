package services;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import ejb.Booking;
import ejb.Notifications;
import ejb.Station;
import ejb.Trip;
import ejb.User;

@Stateless
public class Userservice {
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
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
		notificationservice ns = new notificationservice();
		Notifications n = new Notifications();
		entityManager.persist(b);
		User user = entityManager.find(User.class, b.getUser_id());
		Trip trip = entityManager.find(Trip.class, b.getTrip_id());
		
		if(trip.getAvailable_seats()>0)
		{
			n.setMessage("you have booked a trip from "+trip.getFrom_station()+" to "+trip.getTo_station()+" successfully");
			n.setDate(now());
			user.addtrip(trip);
			trip.adduser(user);
			trip.setAvailable_seats(trip.getAvailable_seats()-1);
			ns.notify(n, b.getUser_id(),entityManager);
			
		}
		else
		{
			n.setMessage("Sorry, Trip "+trip.getFrom_station()+" to " +trip.getTo_station()+" have no available seats");
			n.setDate(now());
			ns.notify(n, b.getUser_id(),entityManager);
		}
		
		
		return "success";
	}
	
	public Set<Trip>  getbooking(int id)
	{
		User user = entityManager.find(User.class, id);
		return user.getTrips();
	}
	
	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
		}

}
