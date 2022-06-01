package services;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import ejb.User;

@Stateless

public class Userservice {
	@PersistenceContext
    private EntityManager entityManager;
	
	public void add(User user) {

        entityManager.persist(user);
    }

	public List<User> getAllPersons() {
		  TypedQuery<User> query = entityManager.createQuery("SELECT p FROM User p", User.class);
		  	List<User> persons = query.getResultList();

			  return persons;
	}
	
	public User findUserbyid (int id)
	{
		return entityManager.find(User.class, id);
	}
	
	
}
