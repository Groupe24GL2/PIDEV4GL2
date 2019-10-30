package beans;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import entities.Employee;
import entities.Holiday;
import services.EmployeeService;
import services.HolidayService;
import services.ProjectService;

@ManagedBean(name = "showAllHolidaysBean")
public class showAllHolidays {

	
	@EJB
	HolidayService hs = new HolidayService();
	
	@EJB
	EmployeeService es = new EmployeeService();
	
	
	List<Holiday> data ;
	
	public String checkInProject(int id){
		ProjectService ps = new ProjectService();
		if(ps.checkUserAvailable(getEmp().getId())){
			return "YES";
		}else{
			return "No";
		}
	}
	
	@PostConstruct
	public void init() {
		data = hs.findAllHolidaysRequests();
	}

	public List<Holiday> getData() {
		return data;
	}

	public void setData(List<Holiday> data) {
		this.data = data;
	}
	
	
	public void AcceptHoliday(Holiday h){
		hs.AcceptHoliday(h);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("showAllDemandHoliday.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void RefusHoliday(Holiday h){
		hs.refusHoliday(h);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("showAllDemandHoliday.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Cookie getCookie() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		Cookie cookie = null;
		Cookie[] userCookies = request.getCookies();
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals("user")) {
					cookie = userCookies[i];
					return cookie;
				}
			}
		}
		return null;
	}

	public Employee getEmp() {
		try {
			Cookie cook = getCookie();
			Employee emp = es.findEmployeeById(Integer.parseInt(cook.getValue()));
			return emp;
		} catch (NullPointerException ex) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}

}
