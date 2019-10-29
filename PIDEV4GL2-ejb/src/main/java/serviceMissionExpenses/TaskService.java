package serviceMissionExpenses;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Mission;
import entities.Task;

@Stateless
@LocalBean
public class TaskService implements TaskServiceRemote {
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;

	
	
	public  void addTaskSer(Task e) {
		em.persist(e);
	}
	
	
	
	public TaskService() {
		// TODO Auto-generated constructor stub
	}

}
