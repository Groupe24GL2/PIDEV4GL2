package serviceEvaluation;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Instructor;

@Stateless
@LocalBean
public class InstructorService implements InstructorServiceRemote{
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;

	@Override
	public void ajouterInstructor(Instructor instructor) {
		em.persist(instructor);
	}

	@Override
	public List<Instructor> getAllInstructors() {
		TypedQuery<Instructor> query = em.createQuery("Select t from Instructor t", Instructor.class);
		return query.getResultList();
	}

	@Override
	public void updateInstructor(Instructor instructor) {
		em.merge(instructor);
	}

	@Override
	public void deleteInstructorById(int id) {
		Instructor t=em.find(Instructor.class, id);
		em.remove(t);
	}
}
