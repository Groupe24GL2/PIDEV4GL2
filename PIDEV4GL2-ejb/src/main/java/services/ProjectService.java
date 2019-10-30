package services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.AffectedProjects;
import entities.Project;
import interfaces.IProject;

@Stateless
@Remote
@LocalBean
public class ProjectService implements IProject {
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;

	@Override
	public int addProject(Project A) {
		em.persist(A);
		System.out.println("Out of addProject" + A.getId());
		return A.getId();
	}

	@Override
	public void updateProject(Project A) {
		System.out.println("In updateProject: ");
		Project project = em.find(Project.class, A.getId());
		project.setName(A.getName());
		project.setStartDate(A.getStartDate());
		project.setEndDate(A.getEndDate());
	}

	@Override
	public Project findProjectById(int id) {
		// TODO Auto-generated method stub
		return em.find(Project.class, id);
	}

	@Override
	public List<Project> findAllProject() {
		// TODO Auto-generated method stub
		return em.createQuery("select l from Project").getResultList();
	}

	@Override
	public List<Project> findAllAvailableProject() {
		// TODO Auto-generated method stub
		return em.createQuery("select l from Project where l.starDate > :sysDate")
				.setParameter("sysDate", new Date()).getResultList();
	}
	
	public Long getNbProjectPerUser(int idEmp){
		System.out.println("================================== In getNbProjectPerUser(User): ");
		Long c = em.createQuery("select COUNT(c)  from AffectedProjects c where c.EmployeeId.id =:u", Long.class)
				.setParameter("u", idEmp)
				.getSingleResult();
		System.out
				.println("================================== Out of getNbProjectPerUser ==================================");
		return c;
	}
	
	
	public Boolean checkUserAvailable(int id){
		List<AffectedProjects> l = em.createQuery("select l from AffectedProjects where l.c.EmployeeId.id =:u")
		.setParameter("u", id).getResultList();
		if(l.size() >= 0){
			return false ;
		}else {
			return true ;
		}
	}

}
