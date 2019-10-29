package serviceMissionExpenses;

import javax.ejb.Remote;

import entities.MissionExpenses;



@Remote
public interface MissionExpensesRemote {
	
	
	public void addMissionExpensesSer(MissionExpenses e);

}
