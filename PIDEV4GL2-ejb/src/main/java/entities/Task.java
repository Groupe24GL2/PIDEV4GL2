package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private int idM ;
	private String task ;
	private State state;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdM() {
		return idM;
	}


	public void setIdM(int idM) {
		idM = idM;
	}


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}


	public Task(int idM, String task, State state) {
		super();
		idM = idM;
		this.task = task;
		this.state = state;
	}


	public Task(int id, int idM, String task, State state) {
		super();
		this.id = id;
		idM = idM;
		this.task = task;
		this.state = state;
	}


	public Task() {
		// TODO Auto-generated constructor stub
	}

}
