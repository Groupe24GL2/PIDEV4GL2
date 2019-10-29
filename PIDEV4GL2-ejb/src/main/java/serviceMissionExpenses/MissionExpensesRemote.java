package serviceMissionExpenses;

import java.util.List;

import javax.ejb.Remote;

import entities.MissionExpenses;



@Remote
public interface MissionExpensesRemote {
	
	
	public void addMissionExpensesSer(MissionExpenses e);
	public List<MissionExpenses> getListMissionsExpenses();

}
