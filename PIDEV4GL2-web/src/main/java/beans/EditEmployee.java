package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Employee;
import services.EmployeeService;

@ManagedBean(name = "editEmployeeBean")
@SessionScoped
public class EditEmployee {

	String firstName;
	String lastName;
	String email;
	String password;
	String picture;
	String skills;
	String role;
	Employee emp;

	@EJB
	EmployeeService es = new EmployeeService();

	public String showEditEmployee(int id) {
		emp = es.findEmployeeById(id);
		firstName = emp.getFirstName();
		lastName = emp.getLastName();
		email = emp.getEmail();
		skills = emp.getSkills();
		String navigateto;
		navigateto = "/xhtml/EditEmp?faces-redirect=true";
		return navigateto;
	}
	
	public String editEmp(){
		String navigateto="null";
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setSkills(skills);
		es.updateEmployee(emp);
		navigateto = "/xhtml/showAllEmp?faces-redirect=true";
		return navigateto;
	}
	
	
	
	
	
	
	//Getters and Setters

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	
	
}
