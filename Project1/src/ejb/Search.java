package ejb;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Search
 *
 */
@Entity

public class Search implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer search_id;
	private String from_date;
	private String to_date;
	private Integer from_station;
	private Integer to_station;
	private static final long serialVersionUID = 1L;

	public Search() {
		super();
	}   
	

	public void setSearch_id(Integer search_id) {
		this.search_id = search_id;
	}   
	public String getFrom_date() {
		return this.from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}   
	public String getTo_date() {
		return this.to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}   
	public Integer getFrom_station() {
		return this.from_station;
	}

	public void setFrom_station(Integer from_station) {
		this.from_station = from_station;
	}   
	public Integer getTo_station() {
		return this.to_station;
	}

	public void setTo_station(Integer to_station) {
		this.to_station = to_station;
	}
   
}
