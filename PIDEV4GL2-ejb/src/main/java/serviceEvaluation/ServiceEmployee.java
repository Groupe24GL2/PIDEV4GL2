package serviceEvaluation;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Employee;

@LocalBean
@Stateless
public class ServiceEmployee implements ServiceEmployeeRemote{
	@PersistenceContext(unitName="pidev4gl2-ejb")
	EntityManager em;
	
	public List<Employee> getAllEmploye(){
		return em.createQuery("from Employee").getResultList();
	}

}
