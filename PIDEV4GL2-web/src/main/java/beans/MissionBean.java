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
	private Integer missionIdToBeUpdated;
	
	
	

	@EJB
	MissionService missionService;
	
	///////////////////////// Crud Mission /////////////////////
	
	
	////////ADD/////////////////
	
	public void addMission() {
		System.out.println("bde");
			missionService.addMissionSer(new Mission(name, place, description, repaymentMethod, dateDeb, dateFin));
			System.out.println("kammal");
	}
	
	////////////////READ ADMIN/////////////////
	
	public List<Mission> getMissions() {
		
		missions = missionService.getListMissions();
		System.out.println(missions);
		return missions;
	}
	
	
	///////////////delete//////////////
	
	public void delete(int missionID)
	{
		missionService.deleteById(missionID);	
	}
	
	/////////////Update////////////
	
	public String Update()
	{
		
		
		System.out.println("////////////////////////////////////////////");
		return "/MissionExpenses/UpdateMission?faces-redirect=true";
	}
	/*
	public void UpdateStep1 (Mission mission)
	{
		
	this.setName(mission.getName());
	this.setPlace(mission.getPlace());
	this.setDescription(mission.getDescription());
	this.setRepaymentMethod(mission.getRepaymentMethod());
	this.setDateDeb(mission.getDateDeb());
	this.setDateFin(mission.getDateFin());
	this.setMissionIdToBeUpdated(mission.getId());
	
		
		missionService.updateMission(new Mission(name, place, description, repaymentMethod, dateDeb, dateFin));

	}
	*/
	
	public void UpdateFinal(Mission mission)
	{
		int id =15;
		missionService.updateMission(new Mission(id,name, place, description, repaymentMethod, dateDeb, dateFin));
		
		

	}
	
	////////////////////////////////
	public String back()
	{
		System.out.println("////////////////////////////////////////////");
		return "/MissionExpenses/ViewMissions?faces-redirect=true";
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

	public Integer getMissionIdToBeUpdated() {
		return missionIdToBeUpdated;
	}

	public void setMissionIdToBeUpdated(Integer missionIdToBeUpdated) {
		this.missionIdToBeUpdated = missionIdToBeUpdated;
	}

	public MissionService getMissionService() {
		return missionService;
	}

	public void setMissionService(MissionService missionService) {
		this.missionService = missionService;
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
