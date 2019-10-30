package serviceEvaluation;


import javax.ejb.Remote;

import entities.Employee;

@Remote
public interface EmployeeServiceRemote {

	public Employee getEmployeeByEmailAndPassword(String email, String password);

}
