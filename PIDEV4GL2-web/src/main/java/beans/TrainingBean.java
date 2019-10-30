package beans;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;

import entities.Category;
import entities.Comment;
import entities.Employee;
import entities.Instructor;
import entities.Role;
import entities.Training;
import serviceEvaluation.TrainingService;

@ManagedBean
@SessionScoped
public class TrainingBean implements Serializable {

	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private Category category;
	private Instructor instructor;
	private List<Training> trainings;
	private int selectedInstructorId;
	private int trainingIdToBeUpdated;
	private List<Instructor> instructors;
	private List<Comment> comments;
	private int nbr_participants;
	private String location;
	private Training training;
	private int per;
	private String message;

	@EJB
	TrainingService trainingService;

	@PostConstruct
	public void init() {
		startDate = new Date();
		endDate = new Date();
		instructors = trainingService.getAllInstructors();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor Instructor) {
		this.instructor = Instructor;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public List<Instructor> getInstructors() {
		instructors = trainingService.getAllInstructors();
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
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

	public void addTraining() {
		trainingService.ajouterTraining(
				new Training(name, description, category, startDate, endDate, nbr_participants, location));
	}

	public List<Training> getTrainings() {
		trainings = trainingService.getAllTrainings();
		return trainings;
	}

	public void supprimer(int id) {
		trainingService.deleteTrainingById(id);
		System.out.println(1111);
	}

	public int getSelectedInstructorId() {
		return selectedInstructorId;
	}

	public void setSelectedInstructorId(int selectedInstructorId) {
		this.selectedInstructorId = selectedInstructorId;
	}

	public int getTrainingIdToBeUpdated() {
		return trainingIdToBeUpdated;
	}

	public void setTrainingIdToBeUpdated(int trainingIdToBeUpdated) {
		this.trainingIdToBeUpdated = trainingIdToBeUpdated;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public int getPer() {
		return per;
	}

	public void setPer(int per) {
		this.per = per;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void modifier(Training training) {
		this.setName(training.getName());
		this.setDescription(training.getDescription());
		this.setCategory(training.getCategory());
		this.setStartDate(training.getStartDate());
		this.setEndDate(training.getStartDate());
		this.setInstructor(training.getInstructor());
		this.setNbr_participants(training.getNbr_participants());
		this.setLocation(training.getLocation());
		this.setTrainingIdToBeUpdated(training.getId());
	}

	public void mettreAjourTraining(Training training) {
		training = new Training(trainingIdToBeUpdated, name, description, category, startDate, endDate, instructor,
				nbr_participants, location);
		Instructor selectedInstructor = new Instructor();
		selectedInstructor.setId(selectedInstructorId);
		training.setInstructor(selectedInstructor);
		// trainingService.deleteTrainingById(training.getId());
		trainingService.updateTraining(training);
	}

	public void ajouterTraining() throws ParseException {
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("startDate :" + simpleFormat.format(startDate));
		System.out.println("endDate :" + simpleFormat.format(endDate));
		System.out.println("selectedTrainingId :" + selectedInstructorId);

		Training training = new Training(name, description, category, startDate, endDate, instructor, nbr_participants,
				location);
		Instructor selectedInstructor = new Instructor();
		selectedInstructor.setId(selectedInstructorId);
		training.setInstructor(selectedInstructor);
		trainingService.ajouterTraining(training);
	}

	public void register(int training_id, int employee_id) {
		trainingService.ajouterParticipant(employee_id, training_id);
		sendEmail();
		participantsPercentage(training);

	}

	public String viewDetails(int id) {
		String navigateTo = "null";
		training = trainingService.getTrainingById(id);

		if (training != null && training.getId() == id) {
			navigateTo = "/trainingSessionsDetails.xhtml?faces-redirect=true&id=" + id;
		}
		return navigateTo;

	}

	public void participantsPercentage(Training training) {
		int nbr_employee_total = trainingService.getAllEmployees().size();
		// int percen = (training.getNbr_participants() * 100) / nbr_employee_total;
		per = nbr_employee_total;
	}

	public void addComment(int training_id, int employee_id) throws IOException {
		trainingService.addComment(message, employee_id, training_id);
		viewDetails(training_id);
	}

	public String sendEmail() {
		final String username = "advyteam.company@gmail.com";
		final String password = "161JFT0663";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "*");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("advyteam.company@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nada.achour@esprit.tn"));
			message.setSubject("Registration confirmation");
			message.setText("Hi,"
					+ "\n\n Thank you for registering in our training session. We are delighted to have you on board.");
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return "";
	}

	public String viewAllTrainings() {
		String navigateTo = "null";
		navigateTo = "/trainingSessions.xhtml?faces-redirect=true";
		return navigateTo;
	}
	
}
