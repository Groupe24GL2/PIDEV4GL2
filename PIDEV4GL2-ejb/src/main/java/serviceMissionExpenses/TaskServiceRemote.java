package serviceMissionExpenses;

import java.util.List;

import javax.ejb.Remote;

import entities.Task;

@Remote
public interface TaskServiceRemote {

	
	public  void addTaskSer(Task e);
	public List<Task> getListTasks();
	public List<Task> getListTasksByMission(int MissionId) ;
	public void updateTask(Task e , int taskIdToBeUpdated);
	public void deleteById(int taskID);

}
