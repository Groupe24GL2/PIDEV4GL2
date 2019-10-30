package beans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Project;
import services.ProjectService;

@ManagedBean(name="affrectProjectBean")
public class AffectProject {
	
	@EJB
	ProjectService ps = new ProjectService();
	
	
	
	Project p;
	Date startDate , endDate ;
	String name,skills;
	
	
	public String showAffectProject(int id) {
		p = ps.findProjectById(id);
		startDate = p.getStartDate();
		endDate = p.getEndDate();
		name = p.getName();
		skills = p.getSkills();
		String navigateto;
		navigateto = "/xhtml/EditEmp?faces-redirect=true";
		return navigateto;
	}
	
	

}
