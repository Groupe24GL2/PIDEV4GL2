package beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import entities.Employee;
import entities.Project;
import entities.TaskProject;

import entities.User;
import serviceTimeSheet.ProjectServiceLocal;
import serviceTimeSheet.TaskServiceLocal;


@ManagedBean(name = "projectBean")
@SessionScoped
public class ProjectBean {

	@EJB
	ProjectServiceLocal projectServiceLocal;

	/*
	@EJB
	UserServiceLocal userServiceLocal;
	*/
	@EJB
	TaskServiceLocal taskServiceLocal;
	
	@ManagedProperty("#{authBean.user}")
	private Employee employee = new Employee();
	private boolean disableButton;
	
	
	
	
	private Employee e = new Employee();
	private Project proj = new Project();
	private List<Project> projects = new ArrayList<>();
	private List<User> employees = new ArrayList<>();
	private List<TaskProject> tasks = new ArrayList<>();

	private Project project;
	private Project p;
	private String reference ="";
	private String name_task ="";
	private String desc_task ="";
	private String id;
	private String date_debut;
	private String date_fin;
	boolean ms =false;
	String result;
	private boolean isselected = false;
	private boolean isdetail = false;
	private boolean istask = false;
	private boolean isNewtask = false;
	private boolean isAdd = false;
	private boolean isUpdate = false;

	public ProjectBean() {

	}
	
	@PostConstruct
	public void initModel() {
		project=new Project();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public List<User> getEmployees() {
		return employees;
	}

	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}

	public boolean isIsselected() {
		return isselected;
	}

	public void setIsselected(boolean isselected) {
		this.isselected = isselected;
	}

	public boolean isIsdetail() {
		return isdetail;
	}

	public void setIsdetail(boolean isdetail) {
		this.isdetail = isdetail;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<TaskProject> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskProject> tasks) {
		this.tasks = tasks;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public boolean getIsAdd() {
		return isAdd;
	}

	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}

	public boolean getisUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public boolean getisNewtask() {
		return isNewtask;
	}

	public void setNewtask(boolean isNewtask) {
		this.isNewtask = isNewtask;
	}

	public Project getP() {
		if (p == null) {
			p = new Project();
		}
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

	public String getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	/*
	public List<Project> getProjectByUser() {
		
		projects = projectServiceLocal.FindProjectByUser(employee);
		if(projects.isEmpty()){
			disableButton=true;
			FacesMessage message = new FacesMessage( "Aucun projet trouver !" );
	        FacesContext.getCurrentInstance().addMessage( null, message );
	        
		}
		else {
			disableButton=false;
		}
		ms=false;
		return projects;
		
	}
	*/
	/*
	public List<User> getAllEmployees() {
		employees = userServiceLocal.findAllUsers();
		return employees;
	}
*/
	public void ajaxListener(AjaxBehaviorEvent event) {
		result = "called by " + event.getComponent().getClass().getName();
		setIsselected(true);
	}

	public Project getProjectByReference() {
		isNewtask = false;
		isdetail = true;
		istask = false;
		isAdd = false;
		isUpdate = false;
		project = projectServiceLocal.FindProjectByReference(reference);
		return project;
	}

	public boolean isIstask() {
		return istask;
	}

	public void setIstask(boolean istask) {
		this.istask = istask;
	}

	public List<TaskProject> getTaskByProject() {
		isdetail = false;
		istask = true;
		isAdd = false;
		isUpdate = false;
		isNewtask = false;
		project = projectServiceLocal.FindProjectByReference(reference);

		tasks = taskServiceLocal.FindTasksByProject(project);
		if(tasks.isEmpty() && !ms){
			FacesMessage message = new FacesMessage( "Aucune Tache trouver !" );
	        FacesContext.getCurrentInstance().addMessage( null, message );
	        ms=true;
		}
		
		proj = project;
		System.out.println("eeeeeeeee"+proj.getReference());
		System.out.println(tasks);
		ms=false;
		return tasks;
	}
	
	

	public void setAdd() {
		p = new Project();
		date_debut = "";
		date_fin = "";
		isAdd = true;
		isdetail = false;
		istask = false;
		isUpdate = false;
		isNewtask = false;
		ms=false;
	}

	public void setUpdate() {
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		date_debut = format.format(project.getStart_date());
		date_fin = format.format(project.getEnd_date());
		isUpdate = true;
		isAdd = false;
		isdetail = false;
		istask = false;
		isNewtask = false;
	}
	
	public void setTask() {

		isUpdate = false;
		isAdd = false;
		isdetail = false;
		istask = false;
		isNewtask = true;
		ms=false;
	}

	public void cancelAdd() {
		isAdd = false;
		isdetail = false;
		istask = false;
		isNewtask = false;
		isUpdate = false;
		ms=false;
		p = new Project();
	}

	public void cancelUpdate() {
		isUpdate = false;
		isAdd = false;
		isdetail = true;
		istask = false;
		isNewtask = false;
	}

	public void AddNewProject() {
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date_d;
		Date date_f;
		try {
			date_d = format.parse(date_debut);
			p.setStart_date(date_d);
			date_f = format.parse(date_fin);
			p.setEnd_date(date_f);
			long diff = date_f.getTime() - date_d.getTime();
			p.setDuration(diff / (1000 * 60 * 60 * 24));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		p.setProject_creator(employee);
		projectServiceLocal.addProject(p);
		isUpdate = false;
		isAdd = false;
		isdetail = false;
		istask = false;
		isNewtask = false;
	}

	public void UpdateProject() {
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date_d;
		Date date_f;
		try {
			date_d = format.parse(date_debut);
			project.setStart_date(date_d);
			date_f = format.parse(date_fin);
			project.setEnd_date(date_f);
			long diff = date_f.getTime() - date_d.getTime();
			project.setDuration(diff / (1000 * 60 * 60 * 24));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		project.setProject_creator(employee);
		projectServiceLocal.UpdateProject(project);
		isUpdate = false;
		isAdd = false;
		isdetail = true;
		istask = false;
		isNewtask = false;
	}

	public void DeleteProject() {

		project.setProject_creator(employee);
		projectServiceLocal.deleteProject(project.getReference());
		isUpdate = false;
		isAdd = false;
		isdetail = false;
		istask = false;
		isNewtask = false;
	}
	
	public void AddNewTask() {
		
		e=(Employee) projectServiceLocal.FindEmployeeById(id);
		TaskProject task=new TaskProject(desc_task, name_task, project, e,"En cours");
		taskServiceLocal.addTask(task);
		isUpdate = false;
		isAdd = false;
		isdetail = false;
		istask = false;
		isNewtask = false;
		ms=false;
		
		
		final String username = "mohamedfadhel.louati@esprit.tn";
		final String password = "20778737";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		
		
		
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Employee getE() {
		return e;
	}

	public void setE(Employee e) {
		this.e = e;
	}

	public String getName_task() {
		return name_task;
	}

	public void setName_task(String name_task) {
		this.name_task = name_task;
	}

	public String getDesc_task() {
		return desc_task;
	}

	public void setDesc_task(String desc_task) {
		this.desc_task = desc_task;
	}

	public Project getProj() {
		return proj;
	}

	public void setProj(Project proj) {
		this.proj = proj;
	}

	public boolean getDisableButton() {
		return disableButton;
	}

	public void setDisableButton(boolean disableButton) {
		this.disableButton = disableButton;
	}
	
	
	
     
    
 /*
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                        "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   */
	
	



    
    

}
