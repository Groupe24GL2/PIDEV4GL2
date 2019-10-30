package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Project;

@Remote
public interface IProject {

	public int addProject(Project A);
	public void updateProject(Project A);
	public Project findProjectById(int id);
	public List<Project> findAllProject();
	public List<Project> findAllAvailableProject();
	public Long getNbProjectPerUser(int idEmp);
	public Boolean checkUserAvailable(int id);
}
