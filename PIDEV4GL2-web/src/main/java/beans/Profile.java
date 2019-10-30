package beans;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import entities.Employee;
import services.EmployeeService;
import services.ProjectService;

@ManagedBean(name = "ProfileBean")
@RequestScoped
public class Profile {

	Long nbProject ;
	
	@EJB
	EmployeeService es = new EmployeeService();
	
	@EJB
	ProjectService ps = new ProjectService();

	@PostConstruct
	public void init() {
		nbProject = ps.getNbProjectPerUser(getEmp().getId());
	}

	
	public Long getNbProject() {
		return ps.getNbProjectPerUser(getEmp().getId());
	}

	public void setNbProject() {
		this.nbProject = ps.getNbProjectPerUser(getEmp().getId());
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
