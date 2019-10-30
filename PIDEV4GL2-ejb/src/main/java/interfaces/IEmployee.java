package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Employee;

@Remote
public interface IEmployee {

	public int addEmployee(Employee A);
	public void removeEmployee(int id);
	public void updateEmployee(Employee A);
	public Employee findEmployeeById(int id);
	public List<Employee> findAllEmployees();
	public Boolean login(String email,String pw);
	public Employee findEmployeeByEmail(String email);
}
