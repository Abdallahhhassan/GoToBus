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

import ejb.Notifications;
import services.notificationservice;
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("notifications")
public class RestNotfication {
	
	@EJB
    private notificationservice notificationService;
		
	@GET
	@Path("/{user_id}")
	public List<Notifications> getall(@PathParam("user_id")Integer user_id)
	{
		return notificationService.getnotfication(user_id);
	}

}
