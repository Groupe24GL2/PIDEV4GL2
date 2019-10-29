package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Mission;
import entities.MissionExpenses;
import serviceMissionExpenses.MissionExpensesService;

@ManagedBean(name = "missionExpensesBean")
@SessionScoped
public class MissionExpensesBean implements Serializable {
	
	private int idMission;
	private int transportationCosts;
	private int accommodationFees;
	private int mealFees;
	private int ceiling;

	@EJB
	MissionExpensesService missionExpenses;
	//////////////////////////////////////////////////////////
	
	//////////////Crud///////////////////
	
	////////Add//////////
	public void addMissionExpenses() {
		System.out.println("bde");
			missionExpenses.addMissionExpensesSer(new MissionExpenses(idMission, transportationCosts, accommodationFees, mealFees, ceiling));
			System.out.println("kammal");
	}
	
	public String backExpenses()
	{
		System.out.println("****************back to MissionList*************");
		return "/MissionExpenses/ViewMissions?faces-redirect=true";
	}
	
	public String redirectionExpenses()
	{
		System.out.println("****************Redirection to ExpensesList*************");
		return "/MissionExpenses/AddMissionExpenses?faces-redirect=true";
	}
	
	///////////////////////////////////////////////////////////
	public MissionExpensesBean() {
		// TODO Auto-generated constructor stub
	}



	public MissionExpensesBean(int idMission, int transportationCosts, int accommodationFees, int mealFees, int ceiling,
			MissionExpensesService missionExpenses) {
		super();
		this.idMission = idMission;
		this.transportationCosts = transportationCosts;
		this.accommodationFees = accommodationFees;
		this.mealFees = mealFees;
		this.ceiling = ceiling;
		this.missionExpenses = missionExpenses;
	}



	public int getIdMission() {
		return idMission;
	}



	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}



	public int getTransportationCosts() {
		return transportationCosts;
	}



	public void setTransportationCosts(int transportationCosts) {
		this.transportationCosts = transportationCosts;
	}



	public int getAccommodationFees() {
		return accommodationFees;
	}



	public void setAccommodationFees(int accommodationFees) {
		this.accommodationFees = accommodationFees;
	}



	public int getMealFees() {
		return mealFees;
	}



	public void setMealFees(int mealFees) {
		this.mealFees = mealFees;
	}



	public int getCeiling() {
		return ceiling;
	}



	public void setCeiling(int ceiling) {
		this.ceiling = ceiling;
	}



	public MissionExpensesService getMissionExpenses() {
		return missionExpenses;
	}



	public void setMissionExpenses(MissionExpensesService missionExpenses) {
		this.missionExpenses = missionExpenses;
	}
	
	


	
}
