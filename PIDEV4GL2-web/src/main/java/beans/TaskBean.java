package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Mission;
import entities.State;
import entities.Task;
import serviceMissionExpenses.TaskService;
import beans.MissionBean;

@ManagedBean(name = "taskBean")
@SessionScoped
public class TaskBean implements Serializable {
	private int idM ;
	private String task ;
	private State state;
	private int missionId;
	
	@EJB
	TaskService taskService;
	////////////////////////////////////////////////////
	public void addTask(int missionId) {
		System.out.println("************************");
		System.out.println("bde");
		System.out.println(missionId);
		System.out.println("************************");
		//idM = MissionId;
		
		//taskService.addTaskSer(new Task(idM, task, state));
		System.out.println("kammal");
	}
	
	public String redirectionVersAdd(int MissionId)
	{
		 
		System.out.println("**************d5al lil redirection***********");
		System.out.println("************************");
		missionId = MissionId;
		System.out.println(missionId);
		return "/MissionExpenses/AddTask?faces-redirect=true";
	}
	
	public String backTask()
	{
		System.out.println("****************back to taskList*************");
		return "/MissionExpenses/MissionsTasks?faces-redirect=true";
	}
	
	/////////////////////////////////////////////////////
	
	public int getIdM() {
		return idM;
	}

	

	public int getMissionId() {
		return missionId;
	}

	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public void setIdM(int idM) {
		idM = idM;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public TaskBean(int idM, String task, State state) {
		super();
		idM = idM;
		this.task = task;
		this.state = state;
	}

	public TaskBean() {
		// TODO Auto-generated constructor stub
	}

}
