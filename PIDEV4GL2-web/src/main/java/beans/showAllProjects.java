package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Project;
import services.ProjectService;

@ManagedBean(name="showAllProjectsBean")
public class showAllProjects {
	
	@EJB
	ProjectService ps = new ProjectService();
	
	List<Project> data;
	
	@PostConstruct
	public void init(){
		data = ps.findAllAvailableProject();
	}
	
	
	

	public List<Project> getData() {
		return data;
	}

	public void setData(List<Project> data) {
		this.data = data;
	}
	
	
	

}
