package serviceEvaluation;



import java.util.List;

import javax.ejb.Remote;

import entities.Course;

@Remote
public interface CourseServiceRemote {

	public void ajouterCourse(Course course);

	public List<Course> getAllCourses();

	public void updateCourse(Course course);

	public void deleteCourseById(int id);

}
