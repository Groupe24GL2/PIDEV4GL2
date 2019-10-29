package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity

public class Project implements Serializable {

	
	@Id
	private String reference;
	private String name;
	private String description;
	private Date start_date;
	private Date end_date;
	private long duration;
	private String budget;
	private String project_creator;
	
	
	private List<TaskProject> tasks;
	
	private static final long serialVersionUID = 1L;

	public Project() {
		super();
	}   
	
	public Project(String name, String description, Date start_date, Date end_date,
			long duration, String reference, String budget) {
		super();
		this.name = name;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.duration = duration;
		this.reference = reference;
		this.budget = budget;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   

	

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Date getStart_date() {
		return this.start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}   
	public Date getEnd_date() {
		return this.end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}   
	public long getDuration() {
		return this.duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}   
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}   
	public String getBudget() {
		return this.budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}
	public List<TaskProject> getTasks() {
		return tasks;
	}
	public void setTasks(List<TaskProject> tasks) {
		this.tasks = tasks;
	}

	public Project(String reference, String name, String description, Date start_date, Date end_date, long duration,
			String budget, String project_creator, List<TaskProject> tasks) {
		super();
		this.reference = reference;
		this.name = name;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.duration = duration;
		this.budget = budget;
		this.project_creator = project_creator;
		this.tasks = tasks;
	}

	public String getProject_creator() {
		return project_creator;
	}

	public void setProject_creator(String project_creator) {
		this.project_creator = project_creator;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
   
}

