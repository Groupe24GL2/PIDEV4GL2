package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String message;

	@ManyToOne
	private Employee employee;

	@ManyToOne(cascade = CascadeType.ALL)
	private Training training;

	public Comment() {
		super();
	}

	public Comment(Date date, String message, Employee employee, Training training) {
		super();
		this.date = date;
		this.message = message;
		this.employee = employee;
		this.training = training;
	}

	public Comment(int id, Date date, String message, Employee employee, Training training) {
		super();
		this.id = id;
		this.date = date;
		this.message = message;
		this.employee = employee;
		this.training = training;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

}
