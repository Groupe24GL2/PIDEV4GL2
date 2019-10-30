package beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Employee;
import entities.EmployeeRole;
import services.EmployeeService;

@ManagedBean(name = "addEmployeeBean")
@SessionScoped
public class addEmployee {
	String firstName;
	String lastName;
	String email;
	String password;
	String picture;
	String skills;
	String role;

	@EJB
	EmployeeService es = new EmployeeService();

	public String addEmp() {
		String navigateTo = "null";
		Employee emp = new Employee();
		emp.setEmail(email);
		emp.setLastName(lastName);
		emp.setFirstName(firstName);
		emp.setRole(EmployeeRole.valueOf(role));
		emp.setSkills(skills);
		emp.setPassword(password);
		es.addEmployee(emp);
		FacesContext.getCurrentInstance().addMessage("formeval:btn", new FacesMessage("Employee Succefully Added"));
		navigateTo = "/xhtml/addEmp?faces-redirect=true";
		return navigateTo;
	}

	// Getters and Setters

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

	public EmployeeService getEs() {
		return es;
	}

	public void setEs(EmployeeService es) {
		this.es = es;
	}

}