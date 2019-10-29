package serviceTimeSheet;

import java.util.List;

import javax.ejb.Local;

import entities.Employee;
import entities.Project;
import entities.User;

@Local
public interface ProjectServiceLocal {
	
	void UpdateProject(Project p);

	List<Project> getAllProjects();

	Project addProject(Project p);

	List<Project> FindProjectByUser(User user);

	void deleteProject(String reference);

	Project FindProjectByReference(String reference);

	Employee FindEmployeeById(String id);

}
