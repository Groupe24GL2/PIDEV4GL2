package serviceMissionExpenses;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Mission;


@Stateless
@LocalBean
public class MissionService implements MissionServiceRemote{
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;
	
	
	public void addMissionSer(Mission e) {
		em.persist(e);
	}
	
	
	
	
	
	public MissionService() {
		// TODO Auto-generated constructor stub
	}

}
