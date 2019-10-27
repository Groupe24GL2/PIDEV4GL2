package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Repayment implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int idMess;
	private int idEmp;
	private int ribEmp;
	private int money;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMess() {
		return idMess;
	}

	public void setIdMess(int idMess) {
		this.idMess = idMess;
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public int getRibEmp() {
		return ribEmp;
	}

	public void setRibEmp(int ribEmp) {
		this.ribEmp = ribEmp;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Repayment(int id, int idMess, int idEmp, int ribEmp, int money) {
		super();
		this.id = id;
		this.idMess = idMess;
		this.idEmp = idEmp;
		this.ribEmp = ribEmp;
		this.money = money;
	}

	public Repayment() {
		// TODO Auto-generated constructor stub
	}

}
