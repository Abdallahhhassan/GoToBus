package ejb;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Trip
 *
 */
@Entity

public class Trip implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trip_id;
	private String from_station;
	private String to_station;
	private Integer available_seats;
	private String departure_time;
	private String arrival_time;
	private static final long serialVersionUID = 1L;
	

	
	public Trip() {
		super();
	}   
	public Integer getTrip_id() {
		return this.trip_id;
	}

	public void setTrip_id(Integer trip_id) {
		this.trip_id = trip_id;
	}   
	public String getFrom_station() {
		return this.from_station;
	}

	public void setFrom_station(String from_station) {
		this.from_station = from_station;
	}   
	public String getTo_station() {
		return this.to_station;
	}

	public void setTo_station(String to_station) {
		this.to_station = to_station;
	}   
	public Integer getAvailable_seats() {
		return this.available_seats;
	}

	public void setAvailable_seats(Integer available_seats) {
		this.available_seats = available_seats;
	}   
	public String getDeparture_time() {
		return this.departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}   
	public String getArrival_time() {
		return this.arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	
			
   
}