package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeAssignment implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private int idMission;
	private int idEmp;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdMission() {
		return idMission;
	}


	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}


	public int getIdEmp() {
		return idEmp;
	}


	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}


	public EmployeeAssignment(int id, int idMission, int idEmp) {
		super();
		this.id = id;
		this.idMission = idMission;
		this.idEmp = idEmp;
	}


	public EmployeeAssignment() {
		// TODO Auto-generated constructor stub
	}

}
