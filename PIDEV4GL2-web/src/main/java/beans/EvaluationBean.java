package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Employee;
import entities.Evaluation;
import entities.FicheEvaluation;
import entities.TypeEvaluation;
import serviceEvaluation.ServiceEvaluation;
import serviceFicheEvaluation.ServiceFicheEvaluation;

@ManagedBean(name="evaluationBean")
@SessionScoped
public class EvaluationBean {
	
	Integer id;
	String nameEvaluation;
	TypeEvaluation typeEvaluation;
	float scoreEvaluation;
	boolean etat;
	Integer selectedEmployeID;
	Integer selectedEvaluationID;
	Integer testrating;
	
	@EJB 
	ServiceFicheEvaluation serviceficheEvaluation;
	//FicheEvaluation ficheevaluation;
	List<FicheEvaluation>fiches;
	List<Employee> lesemp;
	List<Evaluation> leseval;
	
	public Integer getTestrating() {
		return testrating;
	}



	public void setTestrating(Integer testrating) {
		this.testrating = testrating;
	}

	List<Employee> employes;
	List<Evaluation>evaluations;
	
	
	@EJB
	ServiceEvaluation serviceEvaluation;

	Evaluation evaluation;
	List<Evaluation> evaluationss;
	
	
	
	
	
	public List<Evaluation> getEvaluationss() {
		return evaluationss;
	}



	public void setEvaluationss(List<Evaluation> evaluationss) {
		this.evaluationss = evaluationss;
	}



	public List<Employee> getEmployes() {
		return employes;
	}



	public void setEmployes(List<Employee> employes) {
		this.employes = employes;
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



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNameEvaluation() {
		return nameEvaluation;
	}



	public void setNameEvaluation(String nameEvaluation) {
		this.nameEvaluation = nameEvaluation;
	}



	public TypeEvaluation getTypeEvaluation() {
		return typeEvaluation;
	}



	public void setTypeEvaluation(TypeEvaluation typeEvaluation) {
		this.typeEvaluation = typeEvaluation;
	}



	public float getScoreEvaluation() {
		return scoreEvaluation;
	}



	public void setScoreEvaluation(float scoreEvaluation) {
		this.scoreEvaluation = scoreEvaluation;
	}



	public boolean isEtat() {
		return etat;
	}



	public void setEtat(boolean etat) {
		this.etat = etat;
	}



	public ServiceEvaluation getServiceEvaluation() {
		return serviceEvaluation;
	}



	public void setServiceEvaluation(ServiceEvaluation serviceEvaluation) {
		this.serviceEvaluation = serviceEvaluation;
	}



	public Evaluation getEvaluation() {
		return evaluation;
	}



	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}



	public List<Evaluation> getEvaluations() {
		evaluations = serviceEvaluation.getListEvaluations();
		return evaluations;
				
	}



	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}



	public String addEvaluation() {
		String navigateTo="null";
		evaluation = new Evaluation(nameEvaluation, typeEvaluation, scoreEvaluation, etat);

		serviceEvaluation.addEvaluation(evaluation);
		FacesContext.getCurrentInstance().addMessage("formeval:btn", new FacesMessage("Evaluation Succefully Added"));
		navigateTo="/pages/mangeEvaluation?faces-redirect=true";		
		return navigateTo;
	}
	
	public void removeEvaluation(int evaluationId)
	{
	serviceEvaluation.deleteEvaluationById(evaluationId);
	}
	

public void modifier(Evaluation evaluation)
{
	this.setId(evaluation.getId());
	this.setNameEvaluation(evaluation.getNameEvaluation());
	this.setEtat(evaluation.isEtat());
	this.setScoreEvaluation(evaluation.getScoreEvaluation());
	this.setTypeEvaluation(evaluation.getTypeEvaluation());
	
	/*this.setEmail(employe.getEmail());
this.setIsActif(employe.getIsActif());
this.setLogin(employe.getLogin());
this.setPassword(employe.getPassword());
this.setRole(employe.getRole());
	this.setEmployeIdToBeUpdated(employe.getId());*/
}
public void updateeval(){
serviceEvaluation.updateEvaluation(new Evaluation(id, nameEvaluation, typeEvaluation, scoreEvaluation, etat));
FacesContext.getCurrentInstance().addMessage("formevalmanage:btn", new FacesMessage("Evaluation Succefully Updated"));
}

public void majevalscore()
{
	for (Evaluation e : leseval) {
		for(FicheEvaluation ficheevaluation:fiches)
		{
			if(e.getId()==ficheevaluation.getId().getIdEvaluation())
			{
				e.setScoreEvaluation(e.getScoreEvaluation()+ficheevaluation.getAverageRate());
				System.out.println("**score maj");
			
			}
			
		}
	
	}
	
	
}

	
	
	
	
	

}
