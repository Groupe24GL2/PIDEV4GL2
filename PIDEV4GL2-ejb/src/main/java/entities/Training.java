package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.JoinColumn;

@Entity
public class Training implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;

	@Enumerated(EnumType.STRING)
	private Category category;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@ManyToOne
	private Instructor instructor;

	private int nbr_participants;

	private String location;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_training", joinColumns = {
			@JoinColumn(name = "training_id", nullable = true, updatable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "employee_id", nullable = true, updatable = true) })
	private Set<Employee> employees = new HashSet<Employee>(0);

	@OneToMany(mappedBy = "training", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> comments;

	public Training() {
		super();
	}

	public Training(int id, String name, String description, Category category, Date startDate, Date endDate,
			int nbr_participants, String location) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.nbr_participants = nbr_participants;
		this.location = location;
	}

	public Training(String name, String description, Category category, Date startDate, Date endDate,
			int nbr_participants, String location) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.nbr_participants = nbr_participants;
		this.location = location;
	}

	public Training(String name, String description, Category category, Date startDate, Date endDate,
			Instructor instructor, int nbr_participants, String location) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.instructor = instructor;
		this.nbr_participants = nbr_participants;
		this.location = location;
	}

	public Training(int id, String name, String description, Category category, Date startDate, Date endDate,
			Instructor Instructor, int nbr_participants, String location) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.instructor = Instructor;
		this.nbr_participants = nbr_participants;
		this.location = location;
	}

	public Training(int id, String name, String description, Category category, Date startDate, Date endDate,
			Instructor instructor, int nbr_participants, String location, Set<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.instructor = instructor;
		this.nbr_participants = nbr_participants;
		this.location = location;
		this.employees = employees;
	}

	public Training(int id, String name, String description, Category category, Date startDate, Date endDate,
			Instructor instructor, int nbr_participants, String location, Set<Employee> employees,
			List<Comment> comments) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.instructor = instructor;
		this.nbr_participants = nbr_participants;
		this.location = location;
		this.employees = employees;
		this.comments = comments;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor Instructor) {
		this.instructor = Instructor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbr_participants() {
		return nbr_participants;
	}

	public void setNbr_participants(int nbr_participants) {
		this.nbr_participants = nbr_participants;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
