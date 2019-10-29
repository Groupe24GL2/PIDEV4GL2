package entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5195729544267041702L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String lastname;
	private String email;
	private String mdp;
	private int rib;
	private float salary;
	private String poste;
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	private String cv;
	private String picture;
	@Enumerated(EnumType.STRING)
	//private Disponibilte disponibilite;
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/*public Disponibilte getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(Disponibilte disponibilite) {
		this.disponibilite = disponibilite;
	}
	@ManyToMany(mappedBy="employees")
	private List<Evaluation>evaluations;
	//tetet*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getRib() {
		return rib;
	}
	public void setRib(int rib) {
		this.rib = rib;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	/*public List<Evaluation> getEvaluations() {
		return evaluations;
	}
	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	*/
	
}
