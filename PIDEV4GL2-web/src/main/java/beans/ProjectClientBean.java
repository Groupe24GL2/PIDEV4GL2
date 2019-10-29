package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Employee;
import entities.Project;
import entities.TaskProject;
import serviceTimeSheet.ProjectServiceLocal;
import serviceTimeSheet.TaskServiceLocal;

@ManagedBean(name = "projectClientBean")
@SessionScoped
public class ProjectClientBean {

	
	@EJB
	ProjectServiceLocal projectServiceLocal;
/*
	@EJB
	UserServiceLocal userServiceLocal;
	*/
	@EJB
	TaskServiceLocal taskServiceLocal;
	
	
	@ManagedProperty("#{authBean.user}")
	private Employee employee = new Employee();
	
	
	private List<TaskProject> tasks = new ArrayList<>();
	boolean isdetailpr =false;
	Project project_c = new Project();
	
	
	public ProjectClientBean() {

	}
	/*
	@PostConstruct
	public void initModel() {
		tasks =getTaskByEmployee();
		isdetailpr =false;

	}
	*/
	/*
	
	public List<Task> getTaskByEmployee() {


		tasks = taskServiceLocal.FindTaskByUser(employee);
		if(tasks.isEmpty()){
			FacesMessage message = new FacesMessage( "Aucune Tache trouver !" );
	        FacesContext.getCurrentInstance().addMessage( null, message );
		}

		return tasks;
	}
	*/
	public Project getProjectByReference(String reference) {
		isdetailpr = true;
		project_c = projectServiceLocal.FindProjectByReference(reference);
		return project_c;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public List<TaskProject> getTasks() {
		return tasks;
	}



	public void setTasks(List<TaskProject> tasks) {
		this.tasks = tasks;
	}
	public boolean isIsdetailpr() {
		return isdetailpr;
	}
	public void setIsdetailpr(boolean isdetailpr) {
		this.isdetailpr = isdetailpr;
	}
	public Project getProject_c() {
		return project_c;
	}
	public void setProject_c(Project project_c) {
		this.project_c = project_c;
	}
	
	
	
	
	
	

}
