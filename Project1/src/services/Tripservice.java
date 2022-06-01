package services;


import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import ejb.Search;
import ejb.Station;
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
public List<Trip>  Search(Search search) {
		
		List<Trip> result = new ArrayList<Trip>();
		Date d1,d2;
        entityManager.persist(search);
        d1=convertfromStringtoDate(search.getFrom_date());
        d2=convertfromStringtoDate(search.getTo_date());
        
        for(int i=0 ;i<getAllTrips().size();i++)
        {
        	
        	String[] Departure = getAllTrips().get(i).getDeparture_time().split("\\s+");
        	Date Dep=convertfromStringtoDate(Departure[0]);
        	String[] arrival =getAllTrips().get(i).getArrival_time().split("\\s+");
        	Date arrive=convertfromStringtoDate(arrival[0]);
        	String From_station = entityManager.find(Station.class, search.getFrom_station()).getName();
        	String To_station = entityManager.find(Station.class, search.getTo_station()).getName();
        	if(Dep.compareTo(d1)>= 0 && arrive.compareTo(d2)<=0 && getAllTrips().get(i).getFrom_station().equalsIgnoreCase(From_station) && getAllTrips().get(i).getTo_station().equalsIgnoreCase(To_station))
        	{
        		
        		result.add(getAllTrips().get(i));
        		
        	}
        }
        
        return result;
        
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