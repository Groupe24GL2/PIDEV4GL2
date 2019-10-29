package serviceMissionExpenses;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Mission;
import entities.MissionExpenses;

@Stateless
@LocalBean
public class MissionExpensesService implements MissionExpensesRemote{
	
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;
	
	
	public void addMissionExpensesSer(MissionExpenses e) {
		em.persist(e);
	}
	
	
	@Override
	public List<MissionExpenses> getListMissionsExpenses() {
		System.out.println("d5al lil service");
		TypedQuery<MissionExpenses> query = em.createQuery("Select e from missionexpenses e", MissionExpenses.class);
		List<MissionExpenses> result = query.getResultList();
		return result;
	}
	

	public MissionExpensesService() {
		// TODO Auto-generated constructor stub
	}

}
