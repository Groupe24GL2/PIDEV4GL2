package serviceFicheEvaluation;

import java.util.List;

import javax.ejb.Remote;

import entities.Employee;
import entities.Evaluation;
import entities.FicheEvaluation;

@Remote
public interface ServiceFicheEvaluationRemote {
	public void addFicheEvaluation(Integer noteTeamWork,Integer noteDeadlineRespect,Integer noteOrganisation,Integer noteCommunication,Integer noteLeadership,Integer noteInteraction,Integer noteRegularity,Integer noteWorkQuality,float averageRate,String comment,String desription,Evaluation evaluation,Employee employee);
	public float calculAverageRate(FicheEvaluation fe);
	public List<FicheEvaluation> getListFicheEvaluations();
}
