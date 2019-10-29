package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Employee;
import entities.Evaluation;
import serviceEvaluation.ServiceEmployee;
import serviceEvaluation.ServiceEvaluation;

@ManagedBean(name="employeeBean")
@SessionScoped
public class EmployeeBean {

	Integer id;
	String name;
	Integer selectedEmployeID;
	Integer selectedEvaluationID;
	
	List<Employee> lesemp;
	List<Evaluation> leseval;
	
	@EJB
	ServiceEvaluation serviceEvaluation;
	@EJB
	ServiceEmployee serviceEmployee;
	
	public void affecterEvalAEmploye()
	{
		serviceEmployee.affecterEvaluationAEmployee(selectedEvaluationID, selectedEmployeID);
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSelectedEmployeID() {
		return selectedEmployeID;
	}
	public void setSelectedEmployeID(Integer selectedEmployeID) {
		this.selectedEmployeID = selectedEmployeID;
	}
	public Integer getSelectedEvaluationID() {
		return selectedEvaluationID;
	}
	public void setSelectedEvaluationID(Integer selectedEvaluationID) {
		this.selectedEvaluationID = selectedEvaluationID;
	}
	public List<Employee> getLesemp() {
		return serviceEmployee.getAllEmploye();
	}
	public void setLesemp(List<Employee> lesemp) {
		this.lesemp = lesemp;
	}
	public List<Evaluation> getLeseval() {
		return serviceEvaluation.getListEvaluations();
	}
	public void setLeseval(List<Evaluation> leseval) {
		this.leseval = leseval;
	}
	public ServiceEvaluation getServiceEvaluation() {
		return serviceEvaluation;
	}
	public void setServiceEvaluation(ServiceEvaluation serviceEvaluation) {
		this.serviceEvaluation = serviceEvaluation;
	}
	public ServiceEmployee getServiceEmployee() {
		return serviceEmployee;
	}
	public void setServiceEmployee(ServiceEmployee serviceEmployee) {
		this.serviceEmployee = serviceEmployee;
	}
	
	
	
	
	
	
}
