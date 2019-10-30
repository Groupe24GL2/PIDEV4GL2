package serviceFicheEvaluation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Employee;
import entities.Evaluation;
import entities.FicheEvaluation;
import entities.FicheEvaluationPK;

@LocalBean
@Stateless
public class ServiceFicheEvaluation implements ServiceFicheEvaluationRemote {
	
	@PersistenceContext(unitName="pidev4gl2-ejb")
	EntityManager em;
	@Override
	public void addFicheEvaluation(Integer noteTeamWork,Integer noteDeadlineRespect,Integer noteOrganisation,Integer noteCommunication,Integer noteLeadership,Integer noteInteraction,Integer noteRegularity,Integer noteWorkQuality,float averageRate,String comment,String desription,Evaluation evaluation,Employee employee) {
		FicheEvaluationPK ficheevalPK=new FicheEvaluationPK(employee.getId(),evaluation.getId());
		
		FicheEvaluation ficheevaluation=new FicheEvaluation();
		ficheevaluation.setId(ficheevalPK);
		
		ficheevaluation.setNoteTeamWork(noteTeamWork);
		ficheevaluation.setNoteDeadlineRespect(noteDeadlineRespect);
		ficheevaluation.setNoteOrganisation(noteOrganisation);
		ficheevaluation.setNoteCommunication(noteCommunication);
		ficheevaluation.setNoteInteraction(noteInteraction);
		ficheevaluation.setNoteLeadership(noteLeadership);
		ficheevaluation.setNoteRegularity(noteRegularity);
		ficheevaluation.setNoteWorkQuality(noteWorkQuality);
		
		ficheevaluation.setAverageRate(calculAverageRate(ficheevaluation));
		
		ficheevaluation.setComment(comment);
		ficheevaluation.setDesription(desription);
		em.persist(ficheevaluation);	
	}
	@Override
	public float calculAverageRate(FicheEvaluation fe)
	{
		float moy;
		moy=(fe.getNoteTeamWork()+
				fe.getNoteWorkQuality()+
				fe.getNoteRegularity()+
				fe.getNoteOrganisation()+
				fe.getNoteLeadership()+
				fe.getNoteInteraction()+
				fe.getNoteDeadlineRespect()+
				fe.getNoteCommunication()
				
				);
		
		
		return moy;
	}
	
	

}
