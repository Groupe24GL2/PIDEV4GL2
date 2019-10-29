package serviceTimeSheet;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Employee;
import entities.Project;
import entities.User;

/**
 * Session Bean implementation class ProjectService
 */
@Stateless
@LocalBean
public class ProjectService implements ProjectServiceRemote, ProjectServiceLocal {

	@PersistenceContext
	EntityManager em;

    public ProjectService() {

    }


	@Override
	public Project addProject(Project p) {
		em.persist(p);
		em.flush();
		return p;
	}

	@Override
	public List<Project> getAllProjects() {
		return (em.createQuery("SELECT p FROM Project p")).getResultList();
	}

	@Override
	public void deleteProject(String reference) {
		Project project = em.find(Project.class, reference);
		em.remove(project);
	}

	@Override
	public void UpdateProject(Project p) {
		em.merge(p);

	}

	@Override
	public Project FindProjectByReference(String reference) {
		Project project = em.find(Project.class, reference);
		return project;
	}
	
    @Override
   	public List<Project> FindProjectByUser(User user) {
   		return em.createQuery("SELECT p FROM Project p WHERE p.project_creator=?1", Project.class).setParameter(1, user).getResultList();
   	}

	@Override
	public Employee FindEmployeeById(String id) {
		Employee employee = em.find(Employee.class, id);
		return employee;
	}

}
