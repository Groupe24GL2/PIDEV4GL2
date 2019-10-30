package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Employee;
import entities.Role;
import serviceEvaluation.EmployeeService;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
	private String email;
	private String password;
	private Employee employee;
	private boolean loggedIn;
	
	@EJB
	EmployeeService employeeService;
	
	public String doLogin() {
		String navigateTo = "null"; 
		employee = employeeService.getEmployeeByEmailAndPassword(email, password);
		
		if (employee != null && employee.getRole() == Role.employee) {
			navigateTo = "/trainingSessions.xhtml?faces-redirect=true";
			loggedIn = true;
		}else if(employee != null && employee.getRole() == Role.manager) {
			navigateTo = "/training.xhtml?faces-redirect=true";
			loggedIn = true;
		}else
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
		}
		return navigateTo;
	}
	
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String login) {
		this.email = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
}
