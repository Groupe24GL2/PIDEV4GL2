package serviceMissionExpenses;

import javax.ejb.Remote;

import entities.Mission;

@Remote
public interface MissionServiceRemote {

	public void addMissionSer(Mission e);
	
	
}
