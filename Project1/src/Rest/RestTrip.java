package Rest;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.Search;
import ejb.Trip;
import services.Tripservice;
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("trip")
public class RestTrip {
	@EJB
    private Tripservice tripService;
	@POST
	@Path("/{id}")
	public String addtrip(Trip trip, @PathParam("id")int id)
	{
		return tripService.add(trip,id);
		
	}
	@GET
	public List<Trip> getall()
	{
		return tripService.getAllTrips();
	}
	@POST
	@Path("/searchtrips")
	public List<Trip>  addsearch(Search s1)
	{
		
		return tripService.Search(s1);
	}
	
}