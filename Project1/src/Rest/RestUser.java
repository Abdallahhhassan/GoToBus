package Rest;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.Booking;
import ejb.Trip;
import ejb.User;
import services.Userservice;

import javax.ws.rs.POST;
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/user")
public class RestUser {
	@EJB
    private Userservice userService;
	@POST
	
	public String adduser(User user)
	{
		userService.add(user);
		return "success";
	}
	
	@GET
	public List<User> getall()
	{
		return userService.getAllPersons();
	}
	@GET
	@Path("/getID/{id}")
	public User getID (@PathParam("id")int id)
	{
		return userService.findUserbyid(id);
	}
	@POST
	@Path("/login")
	public Response  login(User u)
	{
		return userService.login(u);
	}
	@POST
	@Path("/booktrip")
	public String  book(Booking b)
	{
		return userService.book(b);
	}
	
	@GET
	@Path("/viewtrips/{id}")
	public Set<Trip>  getbooking(@PathParam("id")int id)
	{
		return userService.getbooking(id);
	}
	
	
}