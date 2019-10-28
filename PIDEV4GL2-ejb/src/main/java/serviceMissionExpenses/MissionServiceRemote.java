package serviceMissionExpenses;

import java.util.List;
import javax.ejb.Remote;
import entities.Mission;


@Remote
public interface MissionServiceRemote {

	public void addMissionSer(Mission e);
	 List<Mission> getListMissions();
	void deleteById(int missionID);
	public void updateMission(Mission e);
	 
}
