package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EmbeddedId;

import entities.Employee;
import entities.Evaluation;
import entities.FicheEvaluation;
import entities.FicheEvaluationPK;
import serviceEvaluation.ServiceEmployee;
import serviceEvaluation.ServiceEvaluation;
import serviceFicheEvaluation.ServiceFicheEvaluation;

@ManagedBean(name="ficheevaluationBean")
@SessionScoped
public class FicheevaluationBean {
	
	//***
	@EmbeddedId
	FicheEvaluationPK id;
	Integer noteTeamWork;
	Integer noteDeadlineRespect;
	Integer noteOrganisation;
	Integer noteCommunication;
	Integer noteLeadership;
	Integer noteInteraction;//avec les collegues
	Integer noteRegularity;
	Integer noteWorkQuality;
	float 	averageRate;
	String comment;
	String desription;
	Employee employee;
	Evaluation evaluation;
	
	Integer selectedEmployeID;
	Integer selectedEvaluationID;
	
	List<Employee> lesemp;
	List<Evaluation> leseval;
	
	@EJB
	ServiceEvaluation serviceEvaluation;
	@EJB
	ServiceEmployee serviceEmployee;

	@EJB 
	ServiceFicheEvaluation serviceficheEvaluation;
	FicheEvaluation ficheevaluation;

	

	public FicheEvaluationPK getId() {
		return id;
	}

	public void setId(FicheEvaluationPK id) {
		this.id = id;
	}

	public FicheEvaluation getFicheevaluation() {
		return ficheevaluation;
	}

	public void setFicheevaluation(FicheEvaluation ficheevaluation) {
		this.ficheevaluation = ficheevaluation;
	}

	public Integer getNoteTeamWork() {
		return noteTeamWork;
	}

	public void setNoteTeamWork(Integer noteTeamWork) {
		this.noteTeamWork = noteTeamWork;
	}

	public Integer getNoteDeadlineRespect() {
		return noteDeadlineRespect;
	}

	public void setNoteDeadlineRespect(Integer noteDeadlineRespect) {
		this.noteDeadlineRespect = noteDeadlineRespect;
	}

	public Integer getNoteOrganisation() {
		return noteOrganisation;
	}

	public void setNoteOrganisation(Integer noteOrganisation) {
		this.noteOrganisation = noteOrganisation;
	}

	public Integer getNoteCommunication() {
		return noteCommunication;
	}

	public void setNoteCommunication(Integer noteCommunication) {
		this.noteCommunication = noteCommunication;
	}

	public Integer getNoteLeadership() {
		return noteLeadership;
	}

	public void setNoteLeadership(Integer noteLeadership) {
		this.noteLeadership = noteLeadership;
	}

	public Integer getNoteInteraction() {
		return noteInteraction;
	}

	public void setNoteInteraction(Integer noteInteraction) {
		this.noteInteraction = noteInteraction;
	}

	public Integer getNoteRegularity() {
		return noteRegularity;
	}

	public void setNoteRegularity(Integer noteRegularity) {
		this.noteRegularity = noteRegularity;
	}

	public Integer getNoteWorkQuality() {
		return noteWorkQuality;
	}

	public void setNoteWorkQuality(Integer noteWorkQuality) {
		this.noteWorkQuality = noteWorkQuality;
	}

	public float getAverageRate() {
		return averageRate;
	}

	public void setAverageRate(float averageRate) {
		this.averageRate = averageRate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public ServiceFicheEvaluation getServiceficheEvaluation() {
		return serviceficheEvaluation;
	}

	public void setServiceficheEvaluation(ServiceFicheEvaluation serviceficheEvaluation) {
		this.serviceficheEvaluation = serviceficheEvaluation;
	}
	public String addFicheEvaluation1() {
		String navigateTo="null";
		System.out.println("d5alna lel add");
		//evaluation = new Evaluation(nameEvaluation, typeEvaluation, scoreEvaluation, etat);
		//ficheevaluation=new FicheEvaluation(noteTeamWork, noteDeadlineRespect, noteOrganisation, noteCommunication, noteLeadership, noteInteraction, noteRegularity, noteWorkQuality, averageRate, comment, desription, evaluation, employee);
		//serviceEvaluation.addEvaluation(evaluation);
		serviceficheEvaluation.addFicheEvaluation(noteTeamWork, noteDeadlineRespect, noteOrganisation, noteCommunication, noteLeadership, noteInteraction, noteRegularity, noteWorkQuality, averageRate, comment, desription, serviceEvaluation.getEvalById(selectedEvaluationID), serviceEmployee.getEmployeeById(selectedEmployeID));
		//FacesContext.getCurrentInstance().addMessage("formficheeval:btn", new FacesMessage("Fiche Evaluation Succefully Added"));
		//navigateTo="/pages/mangeEvaluation?faces-redirect=true";	
		navigateTo="****************************************************aaaat";		

		return navigateTo;
	}
	public float calculAverageRating() {
		
		return serviceficheEvaluation.calculAverageRate(ficheevaluation);
	}

	public List<Employee> getLesemp() {
		return serviceEmployee.getAllEmploye();
	}

	public void setLesemp(List<Employee> lesemp) {
		this.lesemp = lesemp;
	}

	public List<Evaluation> getLeseval() {
		return serviceEvaluation.getListEvaluations();
	}

	public void setLeseval(List<Evaluation> leseval) {
		this.leseval = leseval;
	}

	public ServiceEvaluation getServiceEvaluation() {
		return serviceEvaluation;
	}

	public void setServiceEvaluation(ServiceEvaluation serviceEvaluation) {
		this.serviceEvaluation = serviceEvaluation;
	}

	public ServiceEmployee getServiceEmployee() {
		return serviceEmployee;
	}

	public void setServiceEmployee(ServiceEmployee serviceEmployee) {
		this.serviceEmployee = serviceEmployee;
	}

	public Integer getSelectedEmployeID() {
		return selectedEmployeID;
	}

	public void setSelectedEmployeID(Integer selectedEmployeID) {
		this.selectedEmployeID = selectedEmployeID;
	}

	public Integer getSelectedEvaluationID() {
		return selectedEvaluationID;
	}

	public void setSelectedEvaluationID(Integer selectedEvaluationID) {
		this.selectedEvaluationID = selectedEvaluationID;
	}
	
	
}
