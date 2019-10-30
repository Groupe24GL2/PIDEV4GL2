package serviceMissionExpenses;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Mission;
import serviceMissionExpenses.MissionServiceRemote;

//import beans.missionIdToBeUpdated;

@Stateless
@LocalBean
public class MissionService implements MissionServiceRemote{
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;
	
	
	public void addMissionSer(Mission e) {
		em.persist(e);
	}
	
	
	
	@Override
	public List<Mission> getListMissions() {
		System.out.println("d5al lil service");
		TypedQuery<Mission> query = em.createQuery("Select e from Mission e", Mission.class);
		List<Mission> result = query.getResultList();
		return result;
	}
	
	public void deleteById(int missionID) {
		Mission mission = em.find(Mission.class, missionID);
		em.remove(mission);
	}
	
	
	@Override
	public void updateMission(Mission e , int missionIdToBeUpdated)
	{
		Mission a = em.find( Mission.class, missionIdToBeUpdated );
		em.merge(e);
		
	}
	
	
	public MissionService() {
		// TODO Auto-generated constructor stub
	}

}
