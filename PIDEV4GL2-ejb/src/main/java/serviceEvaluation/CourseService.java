package serviceEvaluation;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Course;

@Stateless
@LocalBean
public class CourseService implements CourseServiceRemote{
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;

	@Override
	public void ajouterCourse(Course course) {
		em.persist(course);
	}

	@Override
	public List<Course> getAllCourses() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c", Course.class);
		return query.getResultList();
	}

	@Override
	public void updateCourse(Course course) {
		em.merge(course);
	}

	@Override
	public void deleteCourseById(int id) {

		Query query = em.createQuery("DELETE FROM Course c WHERE c.id = :id ");
		query.setParameter("id", id);
		int rowsDeleted = query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}

}
