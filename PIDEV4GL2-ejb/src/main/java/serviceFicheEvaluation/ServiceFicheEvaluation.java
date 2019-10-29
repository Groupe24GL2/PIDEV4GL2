package serviceFicheEvaluation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.FicheEvaluation;

@LocalBean
@Stateless
public class ServiceFicheEvaluation implements ServiceFicheEvaluationRemote {
	
	@PersistenceContext(unitName="pidev4gl2-ejb")
	EntityManager em;
	@Override
	public void addFicheEvaluation(FicheEvaluation ficheevaluation) {
		em.persist(ficheevaluation);	
	}
	
	
	
	

}
