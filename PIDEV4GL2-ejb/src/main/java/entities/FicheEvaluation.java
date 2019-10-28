package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class FicheEvaluation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7555959210824008700L;
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
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idEvaluation",referencedColumnName="id",insertable=false,updatable=false)
	Evaluation evaluation;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idEmployee",referencedColumnName="id",insertable=false,updatable=false)
	Employee employee;
	public FicheEvaluation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public FicheEvaluation(Integer noteTeamWork, Integer noteDeadlineRespect, Integer noteOrganisation,
			Integer noteCommunication, Integer noteLeadership, Integer noteInteraction, Integer noteRegularity,
			Integer noteWorkQuality, float averageRate, String comment, String desription, Evaluation evaluation,
			Employee employee) {
		super();
		this.noteTeamWork = noteTeamWork;
		this.noteDeadlineRespect = noteDeadlineRespect;
		this.noteOrganisation = noteOrganisation;
		this.noteCommunication = noteCommunication;
		this.noteLeadership = noteLeadership;
		this.noteInteraction = noteInteraction;
		this.noteRegularity = noteRegularity;
		this.noteWorkQuality = noteWorkQuality;
		this.averageRate = averageRate;
		this.comment = comment;
		this.desription = desription;
		this.evaluation = evaluation;
		this.employee = employee;
		this.id=new FicheEvaluationPK(employee.getId(), evaluation.getId());
	}


	public FicheEvaluationPK getId() {return id;}
	public void setId(FicheEvaluationPK id) {this.id = id;}
	public Integer getNoteTeamWork() {return noteTeamWork;}
	public void setNoteTeamWork(Integer noteTeamWork) {this.noteTeamWork = noteTeamWork;}
	public Integer getNoteDeadlineRespect() {return noteDeadlineRespect;}
	public void setNoteDeadlineRespect(Integer noteDeadlineRespect) {this.noteDeadlineRespect = noteDeadlineRespect;}
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
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	
	
	/*****/
	
	
	
	

}
