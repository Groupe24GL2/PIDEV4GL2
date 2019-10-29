package beans;

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

	@EJB 
	ServiceFicheEvaluation serviceficheEvaluation;
	FicheEvaluation ficheevaluation;

	public FicheEvaluationPK getId() {
		return id;
	}

	public void setId(FicheEvaluationPK id) {
		this.id = id;
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
	public String addFicheEvaluation() {
		String navigateTo="null";
		//evaluation = new Evaluation(nameEvaluation, typeEvaluation, scoreEvaluation, etat);
		ficheevaluation=new FicheEvaluation(noteTeamWork, noteDeadlineRespect, noteOrganisation, noteCommunication, noteLeadership, noteInteraction, noteRegularity, noteWorkQuality, averageRate, comment, desription, evaluation, employee);
		//serviceEvaluation.addEvaluation(evaluation);
		serviceficheEvaluation.addFicheEvaluation(ficheevaluation);
		FacesContext.getCurrentInstance().addMessage("formeval:btn", new FacesMessage("Fiche Evaluation Succefully Added"));
		//navigateTo="/pages/mangeEvaluation?faces-redirect=true";	
		navigateTo="****************************************************";		

		return navigateTo;
	}
	
	
}
