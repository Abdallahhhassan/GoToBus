package Rest;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ejb.Station;
import services.Stationservice;
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("station")
public class RestStation {
	@EJB
    private Stationservice stationService;
	@POST
	public String addstation(Station station)
	{
		stationService.add(station);
		return "success";
	}
	@GET
	public List<Station> getall()
	{
		return stationService.getAllStations();
	}
	@GET
	@Path("/{id}")
	public Station getID (@PathParam("id")Integer id)
	{
		return stationService.findStationbyid(id);
	}
	
}