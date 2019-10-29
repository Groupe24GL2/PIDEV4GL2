package serviceMissionExpenses;

import javax.ejb.Remote;

import entities.Task;

@Remote
public interface TaskServiceRemote {

	
	public  void addTaskSer(Task e);
}
