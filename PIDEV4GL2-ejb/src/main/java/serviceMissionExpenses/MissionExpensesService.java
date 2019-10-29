package serviceMissionExpenses;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import entities.MissionExpenses;

@Stateless
@LocalBean
public class MissionExpensesService implements MissionExpensesRemote{
	
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;
	
	
	public void addMissionExpensesSer(MissionExpenses e) {
		em.persist(e);
	}

	public MissionExpensesService() {
		// TODO Auto-generated constructor stub
	}

}
