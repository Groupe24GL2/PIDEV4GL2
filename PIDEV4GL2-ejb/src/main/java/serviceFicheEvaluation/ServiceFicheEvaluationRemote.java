package serviceFicheEvaluation;

import javax.ejb.Remote;

import entities.FicheEvaluation;

@Remote
public interface ServiceFicheEvaluationRemote {
	public void addFicheEvaluation(FicheEvaluation ficheevaluation);
}
