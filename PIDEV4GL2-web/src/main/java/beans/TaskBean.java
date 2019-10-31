package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Mission;
import entities.State;
import entities.Task;
import serviceMissionExpenses.TaskService;
import beans.MissionBean;

@ManagedBean(name="taskBean")
@SessionScoped
public class TaskBean implements Serializable {
	private int id;
	private int idM ;
	private String task ;
	private State state;
	private int missionId;
	private List<Task> tasks = new ArrayList<Task>();
	private List<Task> tasks1 = new ArrayList<Task>();
	private int red;
	private int taskIdToBeUpdated;
	
	@EJB
	TaskService taskService;
	////////////////////////////////////////////////////
	public void addTask(int MissionId) {
		System.out.println("************************");
		System.out.println("bde");
		System.out.println(missionId);
		System.out.println(MissionId);
		System.out.println("************************");
		idM = missionId;
		System.out.println(idM);
		taskService.addTaskSer(new Task(idM, task, state));
		System.out.println("kammal");
	}
	
	public String redirectionVersAdd(int MissionId)
	{
		 
		System.out.println("**************d5al lil redirection***********");
		System.out.println("************************");
		missionId = MissionId;
		System.out.println(MissionId);
		idM=MissionId;
		System.out.println("**********************");
		System.out.println(idM);
		System.out.println("**********************");
		return "Addtask?faces-redirect=true";
	}
	
	public String backTask()
	{
		System.out.println("****************back to taskList*************");
		return "/MissionExpenses/MissionsTasks?faces-redirect=true";
	}
	
	//////////////////////Read///////////////////////////////
	public List<Task> getTasks() {
		
		tasks = taskService.getListTasks();
		System.out.println(tasks);
		return tasks;
	}
	/////////////////////////Read by mission//////////
	
	public String redirectionVerview(int MissionId)
	{
		 
		System.out.println("**************d5al lil redirection***********");
		System.out.println("************************");
		 red = MissionId;
		
		
		System.out.println("**********************");
		System.out.println(red);
		System.out.println("**********************");
		tasks1 = taskService.getListTasksByMission(red);
		System.out.println("3abbaaa ************");
		return "TasksByMission?faces-redirect=true";
	}
	
	public List<Task> getTasksByMission(int red) {
		System.out.println(red);
		System.out.println("bde ylawwej ");
		tasks1 = taskService.getListTasksByMission(red);
		System.out.println("*/////////////////*////////////*//////////");
		System.out.println(tasks1);
		return tasks1;
	}
	
	////////////////Update Task Status//////////////////////
	
	public String Update(int taskID)
	{
		taskIdToBeUpdated = taskID;
		
		System.out.println("////////////////////////////////////////////");
		System.out.println(taskIdToBeUpdated);
		return "/MissionExpenses/UpdateTask?faces-redirect=true";
	}
	
	public void UpdateFinal(Mission mission)
	{
		int id = taskIdToBeUpdated;
		System.out.println("aaaabbbb "+id);
		taskService.updateTask(new Task(id, task, state),taskIdToBeUpdated);
		
	}
	///////////////////////////////////////////////////////
	
	
	public void deleteTask(int taskID)
	{
		taskService.deleteById(taskID);	
	}
	
	//////////////////////////////////////////////////////
	
	public String backTaskList()
	{
		System.out.println("****************back to taskList*************");
		return "Viewmission?faces-redirect=true";
	}
	
	///////////////////////////////////////////////////////
	
	public int getIdM() {
		return idM;
	}

	

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
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

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public List<Task> getTasks1() {
		return tasks1;
	}

	public void setTasks1(List<Task> tasks1) {
		this.tasks1 = tasks1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
