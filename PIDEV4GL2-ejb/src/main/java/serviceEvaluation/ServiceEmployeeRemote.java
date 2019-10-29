package serviceEvaluation;

import java.util.List;

import javax.ejb.Remote;

import entities.Employee;

@Remote
public interface ServiceEmployeeRemote {
	public List<Employee> getAllEmploye();
	public Employee getEmployeeById(Integer id);
	public void affecterEvaluationAEmployee(Integer evaluationID,Integer employeID);
	
}
