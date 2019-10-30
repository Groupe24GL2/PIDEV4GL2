package serviceEvaluation;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.el.ELProcessor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Comment;
import entities.Employee;
import entities.Instructor;
import entities.Training;

@Stateless
@LocalBean
public class TrainingService implements TrainingServiceRemote {
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;

	@Override
	public void ajouterTraining(Training training) {
		em.persist(training);
	}

	@Override
	public List<Training> getAllTrainings() {
		TypedQuery<Training> query = em.createQuery("Select t from Training t", Training.class);
		return query.getResultList();
	}

	@Override
	public void updateTraining(Training training) {
		em.merge(training);
	}

	@Override
	public void deleteTrainingById(int id) {
		Training training = em.find(Training.class, id);
		em.remove(training);
	}

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
	public void ajouterParticipant(int employee_id,int training_id)
	{
		Employee employee=em.find(Employee.class, employee_id);
		Training training=em.find(Training.class, training_id);
		training.getEmployees().add(employee);
		training.setNbr_participants(training.getNbr_participants()+1);
		em.merge(training);
	}

	@Override
	public Training getTrainingById(int id) {
		Training training=em.find(Training.class, id);
		return training;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> query = em.createQuery("Select e from Employee e", Employee.class);
		return query.getResultList();
	}

	
	@Override
	public void addComment(String message, int employee_id, int training_id) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		Employee employee=em.find(Employee.class, employee_id);
		Training training=em.find(Training.class, training_id);
		Comment comment=new Comment(date, message, employee, training);
		em.persist(comment);
	}
	

}
