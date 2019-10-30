package beans;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import entities.Employee;
import entities.Holiday;
import entities.StateHoliday;
import services.EmployeeService;
import services.HolidayService;

@ManagedBean(name = "DemandHolidayBean")
@SessionScoped
public class DemandHoliday {

	
	@EJB
	HolidayService hs = new HolidayService();
	
	@EJB
	EmployeeService es = new EmployeeService();
	
	String descreption;
	Date startDate ;
	Integer duration;
	
	
	public String addHoliday(){
		Holiday h = new Holiday();
		h.setDescreption(descreption);
		h.setStartDate(startDate);
		h.setDuration(duration);
		Employee e = getEmp();
		if(e != null){
			h.setApplicant(e);
			h.setState(StateHoliday.pending);
			hs.addHoliday(h);
		}
		else{
			return "/xhtml/login?faces-redirect=true";
		}
		return "/xhtml/addEmp?faces-redirect=true";
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
	
	
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
	
	
	
}
