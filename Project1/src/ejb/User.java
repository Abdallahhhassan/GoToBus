package ejb;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	private String password;
	private String username;
	private String full_name;
	private String role;
	
	private static final long serialVersionUID = 1L;
	@ManyToMany(mappedBy = "users",fetch=FetchType.EAGER)
	private Set <Trip> trips = new HashSet<Trip>();
	
	public Set<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}

	public User() {
		super();
	}   
	
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getFull_name() {
		return this.full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public void addtrip(Trip t)
	{
		this.trips.add(t);
	}
	
   
}