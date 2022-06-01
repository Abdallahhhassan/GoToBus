package services;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import ejb.Station;


@Stateless

public class Stationservice {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public void add(Station station) {

        entityManager.persist(station);
    }
	public List<Station> getAllStations() {
		  TypedQuery<Station> query = entityManager.createQuery("SELECT p FROM Station p", Station.class);
		  	List<Station> stations = query.getResultList();

			  return stations;
	}
	
	public Station findStationbyid (int id)
	{
		return entityManager.find(Station.class, id);
	}
}
