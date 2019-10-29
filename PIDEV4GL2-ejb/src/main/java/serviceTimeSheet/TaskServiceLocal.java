package serviceTimeSheet;

import java.util.List;

import javax.ejb.Local;

import entities.Project;
import entities.TaskProject;

import entities.User;

@Local
public interface TaskServiceLocal {

	List<TaskProject> FindTasksByProject(Project project);

	boolean addTask(TaskProject t);
	

	long CountTask(String reference);

	long CountAllTask(String reference);

	List<TaskProject> FindTaskByUser(User user);


}
