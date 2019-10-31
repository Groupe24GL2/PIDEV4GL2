package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Mission implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String name ;
	private String place;
	private String description;
	private RepaymentMethod repaymentMethod;
	private Date dateDeb;
	private Date dateFin;
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RepaymentMethod getRepaymentMethod() {
		return repaymentMethod;
	}

	public void setRepaymentMethod(RepaymentMethod repaymentMethod) {
		this.repaymentMethod = repaymentMethod;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Mission(int id, String name, String place, String description, RepaymentMethod repaymentMethod, Date dateDeb,
			Date dateFin) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.description = description;
		this.repaymentMethod = repaymentMethod;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
	}
	
	
	

	public Mission(String name, String place, String description, RepaymentMethod repaymentMethod, Date dateDeb,
			Date dateFin) {
		super();
		this.name = name;
		this.place = place;
		this.description = description;
		this.repaymentMethod = repaymentMethod;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
	}

	public Mission() {
		// TODO Auto-generated constructor stub
	}

}
