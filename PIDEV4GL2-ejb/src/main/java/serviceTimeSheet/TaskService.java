package serviceTimeSheet;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Project;
import entities.TaskProject;

import entities.User;


@Stateless
@LocalBean
public class TaskService implements TaskServiceRemote, TaskServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean addTask(TaskProject t) {
		em.persist(t);
		em.flush();
		return true;
	}
    public TaskService() {

    }
	@Override
	public List<TaskProject> FindTasksByProject(Project project) {
		return em.createQuery("SELECT t FROM Task t WHERE t.project=?1", TaskProject.class)
				.setParameter(1, project).getResultList();
	}
	
	
	
	@Override
	public long CountTask(String reference) {
		String s = "En cours";
		long foo = em.createQuery("SELECT COUNT(t) FROM Task t WHERE reference =:r  AND state=:s ", Long.class)
					.setParameter("s", s).setParameter("r", reference).getSingleResult();

		System.out.println(foo);
		return foo;
		

	}
	
    @Override
   	public List<TaskProject> FindTaskByUser(User user) {
   		return em.createQuery("SELECT t FROM Task t WHERE t.employee =?1", TaskProject.class).setParameter(1, user).getResultList();
   	}
	
	@Override
	public long CountAllTask(String reference) {

		long foo = (long) em.createQuery("SELECT COUNT(t) FROM Task t WHERE reference =:par1").setParameter("par1",reference).getSingleResult();
		System.out.println(foo);
		return foo;

	}
	
	
	
	
	

}
