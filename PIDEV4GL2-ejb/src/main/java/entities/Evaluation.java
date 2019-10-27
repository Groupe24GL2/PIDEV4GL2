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
import javax.persistence.OneToMany;

@Entity
public class Evaluation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6058390057461518012L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nameEvaluation;
	@Enumerated(EnumType.STRING)
	private TypeEvaluation typeEvaluation;
	private float scoreEvaluation;
	private boolean etat;
	@OneToMany(mappedBy="evaluation")
	List<FicheEvaluation>evalsheets;
	
	@ManyToMany
	private List<Employee>employees;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameEvaluation() {
		return nameEvaluation;
	}
	public void setNameEvaluation(String nameEvaluation) {
		this.nameEvaluation = nameEvaluation;
	}
	public TypeEvaluation getTypeEvaluation() {
		return typeEvaluation;
	}
	public void setTypeEvaluation(TypeEvaluation typeEvaluation) {
		this.typeEvaluation = typeEvaluation;
	}
	public float getScoreEvaluation() {
		return scoreEvaluation;
	}
	public void setScoreEvaluation(float scoreEvaluation) {
		this.scoreEvaluation = scoreEvaluation;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<FicheEvaluation> getEvalsheets() {
		return evalsheets;
	}
	public void setEvalsheets(List<FicheEvaluation> evalsheets) {
		this.evalsheets = evalsheets;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Evaluation(String nameEvaluation, TypeEvaluation typeEvaluation, float scoreEvaluation, boolean etat) {
		super();
		this.nameEvaluation = nameEvaluation;
		this.typeEvaluation = typeEvaluation;
		this.scoreEvaluation = scoreEvaluation;
		this.etat = etat;
	}
	public Evaluation(Integer id, String nameEvaluation, TypeEvaluation typeEvaluation, float scoreEvaluation,
			boolean etat) {
		super();
		this.id = id;
		this.nameEvaluation = nameEvaluation;
		this.typeEvaluation = typeEvaluation;
		this.scoreEvaluation = scoreEvaluation;
		this.etat = etat;
	}
	
	
	
	

}
