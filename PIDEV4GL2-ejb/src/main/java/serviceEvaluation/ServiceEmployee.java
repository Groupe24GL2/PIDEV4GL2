package serviceEvaluation;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Employee;
import entities.Evaluation;

@LocalBean
@Stateless
public class ServiceEmployee implements ServiceEmployeeRemote{
	@PersistenceContext(unitName="pidev4gl2-ejb")
	EntityManager em;
	@Override
	public List<Employee> getAllEmploye(){
		return em.createQuery("from Employee").getResultList();
	}
	@Override
	public Employee getEmployeeById(Integer id) {
		TypedQuery<Employee> query= em.createQuery("Select e from Employee e " + "where e.id=:id", Employee.class);
		query.setParameter("id", id);		
		Employee employee = null;
		try{
			employee = query.getSingleResult();
		}
		catch(NoResultException e){
			Logger.getAnonymousLogger().info("Not found");
		}
		return employee;
	}
	@Override
	public void affecterEvaluationAEmployee(Integer evaluationID,Integer employeID)
	{
		Evaluation evaluationMangedEntity=em.find(Evaluation.class,evaluationID);
		Employee employeeManagedEntity=em.find(Employee.class,employeID);
		System.out.println(employeeManagedEntity.getId());
		
		employeeManagedEntity.getEvaluations().add(evaluationMangedEntity);
		
		//evaluationMangedEntity.getEmployee().add(employeeManagedEntity);
		System.out.println("affectaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
	}
	

}
