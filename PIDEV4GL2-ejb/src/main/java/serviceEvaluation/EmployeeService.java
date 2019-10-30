package serviceEvaluation;



import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Employee;

@Stateless
@LocalBean
public class EmployeeService implements EmployeeServiceRemote{
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;
	
	
	@Override
	public Employee getEmployeeByEmailAndPassword(String email, String password) {
		TypedQuery<Employee> query = em.createQuery("Select e from Employee e " + "where e.email=:email and " + "e.password=:password", Employee.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		Employee employee = null; 
		
		try {
			employee = query.getSingleResult();
		}catch(NoResultException e) {
			Logger.getAnonymousLogger().info("Aucun employe trouve avec email : " + email);
		}
		
		return employee;
		}

}
