package serviceEvaluation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Employee;
import entities.Evaluation;

@Stateless
@LocalBean

public class ServiceEvaluation implements ServiceEvaluationRemote {

	@PersistenceContext(unitName="pidev4gl2-ejb")
	EntityManager em;
	
	@Override
	public void addEvaluation(Evaluation evaluation) {
		em.persist(evaluation);	
	}
	
	@Override
	public List<Evaluation> getListEvaluations() {
		System.out.println("********LISTET");
		TypedQuery<Evaluation> query = em.createQuery("Select e from Evaluation e", Evaluation.class);
		List<Evaluation> result = query.getResultList();
		return result;
	}
	@Override
	public void deleteEvaluationById(int evaluationId)
	{Evaluation e = em.find(Evaluation.class,evaluationId);

		em.remove(e);
	}
	@Override
	public void updateEvaluation(Evaluation e)
	{
		//Employe a = em.find( Employe.class, e.getId() );
	System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"+e.getNameEvaluation());
	 
		em.merge(e);

	}
	
	/*@Override
	public void affecterEvaluationAEmploye(int evaluationId, int employeId) {
		// TODO Auto-generated method stub
		Evaluation evaluationEntity = em.find(Evaluation.class,evaluationId);
		Employee employeeEntity = em.find(Employee.class, employeId);
		
		evaluationEntity
		
		em.merge(contratEntity);
	}
	*/
	@Override
	public void affecterEmployeAEvaluation(int evaluationId, int employeId) {
		// TODO Auto-generated method stub
		Evaluation evaluationEntity = em.find(Evaluation.class,evaluationId);
		Employee employeeEntity = em.find(Employee.class, employeId);

		if(evaluationEntity.getEmployees() == null){
			List<Employee> employes = new ArrayList<>();
			employes.add(employeeEntity);
			evaluationEntity.setEmployees(employes);
		}else{
			evaluationEntity.getEmployees().add(employeeEntity);
		}

	}
	
	
	
}
