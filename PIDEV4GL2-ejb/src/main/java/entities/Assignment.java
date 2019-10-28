package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	int idMission;
	int idEmployee;
	
	
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

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	
	
	public Assignment(int id, int idMission, int idEmployee) {
		super();
		this.id = id;
		this.idMission = idMission;
		this.idEmployee = idEmployee;
	}

	public Assignment(int idMission, int idEmployee) {
		super();
		this.idMission = idMission;
		this.idEmployee = idEmployee;
	}

	
	public Assignment() {
		// TODO Auto-generated constructor stub
	}

}
