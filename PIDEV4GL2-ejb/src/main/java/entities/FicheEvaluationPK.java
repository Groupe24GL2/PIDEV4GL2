package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class FicheEvaluationPK implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -7308779973150688735L;
	private Integer idEmployee;
	private Integer idEvaluation;
	public Integer getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}
	public Integer getIdEvaluation() {
		return idEvaluation;
	}
	public void setIdEvaluation(Integer idEvaluation) {
		this.idEvaluation = idEvaluation;
	}
	
	
}
