package serviceEvaluation;

import java.util.List;

import javax.ejb.Remote;

import entities.Evaluation;

@Remote
public interface ServiceEvaluationRemote {
	public void addEvaluation(Evaluation evaluation);
	public List<Evaluation> getListEvaluations();
	public void deleteEvaluationById(int evaluationId);
	public void updateEvaluation(Evaluation e);
	public void affecterEmployeAEvaluation(int evaluationId, int employeId);
}
