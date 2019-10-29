package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.MissionExpenses;

@ManagedBean(name = "missionExpensesBean")
@SessionScoped
public class MissionExpensesBean implements Serializable {
	
	private int idMission;
	private int transportationCosts;
	private int AccommodationFees;
	private int MealFees;
	private int ceiling;
	
	@EJB
	MissionExpenses missionExpenses;
	///////////////////////////////////////////
	
	
	
	//////////////////////////////////////////
	public MissionExpensesBean() {
		// TODO Auto-generated constructor stub
	}
	public MissionExpensesBean(int idMission, int transportationCosts, int accommodationFees, int mealFees, int ceiling,
			MissionExpenses missionExpenses) {
		super();
		this.idMission = idMission;
		this.transportationCosts = transportationCosts;
		AccommodationFees = accommodationFees;
		MealFees = mealFees;
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
		return AccommodationFees;
	}
	public void setAccommodationFees(int accommodationFees) {
		AccommodationFees = accommodationFees;
	}
	public int getMealFees() {
		return MealFees;
	}
	public void setMealFees(int mealFees) {
		MealFees = mealFees;
	}
	public int getCeiling() {
		return ceiling;
	}
	public void setCeiling(int ceiling) {
		this.ceiling = ceiling;
	}
	public MissionExpenses getMissionExpenses() {
		return missionExpenses;
	}
	public void setMissionExpenses(MissionExpenses missionExpenses) {
		this.missionExpenses = missionExpenses;
	}

	
}
