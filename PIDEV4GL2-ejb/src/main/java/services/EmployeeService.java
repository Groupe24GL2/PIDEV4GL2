package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Employee;
import interfaces.IEmployee;

@Stateless
@Remote
@LocalBean
public class EmployeeService implements IEmployee {
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;

	@Override
	public int addEmployee(Employee A) {
		em.persist(A);
		System.out.println("Out of addEmployee" + A.getId());
		return A.getId();
	}

	@Override
	public void removeEmployee(int id) {
		System.out.println("In removeEmployee: ");
		em.remove(em.find(Employee.class, id));
		System.out.println("Out of removeEmployee: ");
	}

	@Override
	public void updateEmployee(Employee A) {
		System.out.println("In updateAccount: ");
		Employee emp = em.find(Employee.class, A.getId());
		emp.setEmail(A.getEmail());
		emp.setFirstName(A.getFirstName());
		emp.setLastName(A.getLastName());
		
	}

	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return em.find(Employee.class, id);
	}
	
	@Override
	public Employee findEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return em.createQuery("from Employee where email = :email", Employee.class).setParameter("email", email).getSingleResult();
	}
	
	@Override
	public List<Employee> findAllEmployees() {
		System.out.println("In findAllEmployees: ");
		List<Employee> accs = em.createQuery("from Employee", Employee.class).getResultList();
		System.out.println("Out of findAllEmployees: ");
		return accs;
	}

	@Override
	public Boolean login(String email, String pw) {
		Query query=em.createQuery("SELECT u FROM Employee u WHERE u.email = :email AND u.password = :pwd").setParameter("email", email).setParameter("pwd", pw);
        if(query.getResultList().size() == 0)
            return false;
        return true;
	}

}
