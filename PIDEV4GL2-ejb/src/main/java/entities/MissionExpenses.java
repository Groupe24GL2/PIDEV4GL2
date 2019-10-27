package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class MissionExpenses implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private int idMission;
	private int transportationCosts;
	private int AccommodationFees;
	private int MealFees;
	private int ceiling;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public MissionExpenses(int id, int idMission, int transportationCosts, int accommodationFees, int mealFees,
			int ceiling) {
		super();
		this.id = id;
		this.idMission = idMission;
		this.transportationCosts = transportationCosts;
		AccommodationFees = accommodationFees;
		MealFees = mealFees;
		this.ceiling = ceiling;
	}

	public MissionExpenses() {
		// TODO Auto-generated constructor stub
	}

}
