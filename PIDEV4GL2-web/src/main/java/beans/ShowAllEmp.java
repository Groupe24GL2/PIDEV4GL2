package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import services.EmployeeService;
import entities.*;

@ManagedBean(name = "ShowAllEmpBean")
public class ShowAllEmp {

	List<Employee> data;

	@EJB
	EmployeeService es = new EmployeeService();

	@PostConstruct
	public void init() {
		data = es.findAllEmployees();
	}

	public void delete(int id) {
		Employee l = es.findEmployeeById(id);
		es.removeEmployee(id);
		data.remove(l);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee deleted", null);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}
	
	
}
