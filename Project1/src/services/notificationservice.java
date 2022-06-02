package services;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

import ejb.Notifications;
import ejb.User;


@Stateless
public class notificationservice {
	@PersistenceContext
    private EntityManager entityManager;
	
	public void notify(Notifications n ,Integer id, EntityManager em)
	{
		
		  User user = em.find(User.class, id);
		  user.addnotification(n);
		  n.setUser(user); 
		  em.persist(n);
		  
		  
	}
	public List<Notifications> getnotfication (int user_id)
	{
		 TypedQuery<Notifications> query = entityManager.createQuery("SELECT p FROM Notifications p JOIN FETCH p.user where user_id =: user_id ", Notifications.class);
		 query.setParameter("user_id", user_id);
		  List<Notifications> notifications = query.getResultList();
			return notifications;
	}
}
