package serviceEvaluation;

import java.util.List;

import javax.ejb.Remote;

import entities.Employee;

@Remote
public interface ServiceEmployeeRemote {
	public List<Employee> getAllEmploye();

}
