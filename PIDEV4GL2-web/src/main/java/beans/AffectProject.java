package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.AffectedProjects;
import entities.Employee;
import entities.Project;
import services.EmployeeService;
import services.ProjectService;

@ManagedBean(name="affrectProjectBean")
@SessionScoped
public class AffectProject {
	
	@EJB
	ProjectService ps = new ProjectService();
	
	@EJB
	EmployeeService es = new EmployeeService();
	
	
	
	Project p;
	Date startDate , endDate ;
	String name,skills;
	List<Employee> employees;
	
	
	
	
	public String showAffectProject(int id) {
		p = ps.findProjectById(id);
		this.startDate = p.getStartDate();
		this.endDate = p.getEndDate();
		this.name = p.getName();
		this.skills = p.getSkills();
		this.employees = es.findEmployeeBySkill(skills);
		String navigateto ="null";
		navigateto = "/xhtml/affectProject?faces-redirect=true";
		return navigateto;
	}
	
	public void affectToProject(Employee e){
		if(ps.checkExistanceAffectedProject(e.getId(), p.getId())){
			AffectedProjects ap = new AffectedProjects();
			List<Employee> a = new ArrayList<>();
			a.add(e);
			ap.setEmployeeId(e);
			ap.setProjectId(p);
			ps.affectToProject(ap);
			FacesContext.getCurrentInstance().addMessage("formeval:btn", new FacesMessage("Employee Succefully Affected"));
		}else {
			FacesContext.getCurrentInstance().addMessage("formeval:btn", new FacesMessage("Employee already Affected"));
		}
	}


	public Project getP() {
		return p;
	}


	public void setP(Project p) {
		this.p = p;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	

}
