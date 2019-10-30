package serviceEvaluation;


import java.util.List;

import javax.ejb.Remote;

import entities.Employee;
import entities.Instructor;
import entities.Training;

@Remote
public interface TrainingServiceRemote {

	public void ajouterTraining(Training training);

	public List<Training> getAllTrainings();

	public void updateTraining(Training training);

	public void deleteTrainingById(int id);

	public void ajouterInstructor(Instructor Instructor);

	public List<Instructor> getAllInstructors();

	public void ajouterParticipant(int employee_id, int training_id);

	public Training getTrainingById(int id);

	public List<Employee> getAllEmployees();

	public void addComment(String message, int employee_id, int training_id);


}
