package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Mission;
import entities.RepaymentMethod;
import serviceMissionExpenses.MissionService;





@ManagedBean(name = "missionBean")
@SessionScoped
public class MissionBean implements Serializable {
	
	private String name ;
	private String place;
	private String description;
	private RepaymentMethod repaymentMethod;
	private Date dateDeb;
	private Date dateFin;
	private List<Mission> missions = new ArrayList<Mission>();
	
	
	@EJB
	MissionService missionService;
	
	///////////////////////// Crud Mission /////////////////////
	
	
	public void addMission() {
		System.out.println("bde");
			missionService.addMissionSer(new Mission(name, place, description, repaymentMethod, dateDeb, dateFin));
			System.out.println("kammal");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	////////////////////////////////// Getters and Setter ///////////////////////////////
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RepaymentMethod getRepaymentMethod() {
		return repaymentMethod;
	}

	public void setRepaymentMethod(RepaymentMethod repaymentMethod) {
		this.repaymentMethod = repaymentMethod;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public MissionBean(String name, String place, String description, RepaymentMethod repaymentMethod, Date dateDeb,
			Date dateFin, List<Mission> missions) {
		super();
		this.name = name;
		this.place = place;
		this.description = description;
		this.repaymentMethod = repaymentMethod;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.missions = missions;
	}

	public MissionBean() {
		// TODO Auto-generated constructor stub
	}

}
