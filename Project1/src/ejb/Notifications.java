package ejb;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Notifications
 *
 */
@Entity

public class Notifications implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notification_id;
	private String message;
	private String  notification_datetime;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	

	public Notifications() {
		super();
	}   
	
	public void setUser(User user) {
			this.user = user;
		}


	public void setNotification_id(Integer notification_id) {
		this.notification_id = notification_id;
	}   
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String  getDate() {
		return notification_datetime;
	}
	public void setDate(String  date) {
		this.notification_datetime = date;
	}
   
}
