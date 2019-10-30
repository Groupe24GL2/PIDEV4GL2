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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEmployee == null) ? 0 : idEmployee.hashCode());
		result = prime * result + ((idEvaluation == null) ? 0 : idEvaluation.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FicheEvaluationPK other = (FicheEvaluationPK) obj;
		if (idEmployee == null) {
			if (other.idEmployee != null)
				return false;
		} else if (!idEmployee.equals(other.idEmployee))
			return false;
		if (idEvaluation == null) {
			if (other.idEvaluation != null)
				return false;
		} else if (!idEvaluation.equals(other.idEvaluation))
			return false;
		return true;
	}
	
	
	
	
}
