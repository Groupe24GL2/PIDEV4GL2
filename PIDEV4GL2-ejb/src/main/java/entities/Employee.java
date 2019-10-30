package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5195729544267041702L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	private String lastname;

	private String email;

	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "employees")
	private Set<Training> trainings = new HashSet<Training>(0);

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Comment> comments;

	@ManyToMany(mappedBy = "employees")
	private List<Evaluation> evaluations;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee() {
	}

	public Employee(int id, String name, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}

	public Set<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}

	public Employee(int id, String name, String lastname, Set<Training> trainings) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.trainings = trainings;
	}

	public Employee(int id, String name, String lastname, String email, String password, Role role,
			Set<Training> trainings, List<Comment> comments) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.trainings = trainings;
		this.comments = comments;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Employee(int id, String name, String lastname, String email, String password, Role role,
			Set<Training> trainings) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.trainings = trainings;
	}

	public Employee(String name, String lastname, String email, String password, Role role) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Employee(String name, String lastname, String email, String password, Role role, Set<Training> trainings) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.trainings = trainings;
	}

}
