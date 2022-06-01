package services;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.Station;


@Stateless

public class Stationservice {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public void add(Station station) {

        entityManager.persist(station);
    }
}
