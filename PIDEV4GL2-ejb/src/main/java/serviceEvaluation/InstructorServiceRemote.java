package serviceEvaluation;


import java.util.List;

import javax.ejb.Remote;

import entities.Instructor;

@Remote
public interface InstructorServiceRemote {

	public void ajouterInstructor(Instructor Instructor);

	public List<Instructor> getAllInstructors();

	public void updateInstructor(Instructor Instructor);

	public void deleteInstructorById(int id);

}
