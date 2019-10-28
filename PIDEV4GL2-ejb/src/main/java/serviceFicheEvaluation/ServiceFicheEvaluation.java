package serviceFicheEvaluation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class ServiceFicheEvaluation implements ServiceFicheEvaluationRemote {
	
	@PersistenceContext(unitName="pidev4gl2-ejb")
	EntityManager em;
	
	
	
	
	

}
