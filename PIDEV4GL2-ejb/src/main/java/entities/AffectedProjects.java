package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AffectedProjects")
public class AffectedProjects {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne()
	private Project projectId ;
	@ManyToOne()
	private Employee EmployeeId ;
	
	
	
	public Project getProjectId() {
		return projectId;
	}
	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}
	public Employee getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		EmployeeId = employeeId;
	}
	
	
	

}
