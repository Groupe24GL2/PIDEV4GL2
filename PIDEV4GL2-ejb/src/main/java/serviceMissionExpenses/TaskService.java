package serviceMissionExpenses;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import entities.Task;

@Stateless
@LocalBean
public class TaskService implements TaskServiceRemote {
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;

	
	
	public  void addTaskSer(Task e) {
		em.persist(e);
	}
	
	
	
	@Override
	public List<Task> getListTasks() {
		System.out.println("d5al lil service");
		TypedQuery<Task> query = em.createQuery("Select e from Task e", Task.class);
		List<Task> result = query.getResultList();
		return result;
	}
	
	
	@Override
	public List<Task> getListTasksByMission(int red) {
		System.out.println("d5al lil service");
		TypedQuery<Task> query = em.createQuery("Select e from Task e where e.idM = :red", Task.class);
		System.out.println("3abba f wost el service");
		List<Task> result = query.setParameter("red", red).getResultList();
		System.out.println("wsol lil return");
		return result;
	}
	
	
	
	public TaskService() {
		// TODO Auto-generated constructor stub
	}

}
