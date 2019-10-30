package beans;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import entities.Employee;
import entities.Holiday;
import services.EmployeeService;

@ManagedBean(name="showMyHolidaysBean")
public class showMyHolidays {

	
	
	List<Holiday> data ;
	
	@EJB
	EmployeeService es = new EmployeeService();
	
	@PostConstruct
	public void init(){
		data = findEmp().getHolidays();
	}
	
	
	
	
	
	
	public List<Holiday> getData() {
		return data;
	}






	public void setData(List<Holiday> data) {
		this.data = data;
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

	public Employee findEmp() {
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
