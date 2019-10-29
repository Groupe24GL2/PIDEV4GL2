package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity

public class TaskProject implements Serializable {

	@Id
	private int IDTask; 
	private String description;
	private String name;
	private String state;
/*
	@ManyToOne
	@JoinColumn(name="reference",referencedColumnName="reference", insertable=false, updatable=false)
	*/
	private Project project;
	
	public TaskProject() {
		super();
	}  

	public TaskProject(String description, String name, Project project,String state) {
		super();
		this.description = description;
		this.name = name;
		this.project = project;
	
		this.state = state;
		
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
   
}
