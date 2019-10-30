package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import entities.Project;
import services.EmployeeService;
import services.ProjectService;

@ManagedBean(name="addProjectBean")
public class addProject {
	
	Date startDate , endDate ;
	String name,skills;
	List<Date> range ;
	
	
	
	@EJB
	EmployeeService es = new EmployeeService();
	
	@EJB
	ProjectService ps = new ProjectService();
	
	
	public String addProject(){
		String navigateTo ="";
		Project p = new Project();
		p.setEndDate(range.get(0));
		p.setStartDate(range.get(1));
		p.setName(name);
		p.setSkills(skills);
		ps.addProject(p);
		FacesContext.getCurrentInstance().addMessage("formeval:btn", new FacesMessage("Project Succefully Added"));
		navigateTo = "/xhtml/addEmp?faces-redirect=true";
		return navigateTo;
	}

	
	

	public List<Date> getRange() {
		return range;
	}

	public void setRange(List<Date> range) {
		this.range = range;
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
	
	
	
	

}
