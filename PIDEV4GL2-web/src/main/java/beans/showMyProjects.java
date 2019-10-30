package beans;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import entities.AffectedProjects;
import entities.Employee;
import entities.Project;
import services.EmployeeService;
import services.ProjectService;

@ManagedBean(name="showMyProjectsBean")
public class showMyProjects {

	
	@EJB
	ProjectService ps = new ProjectService();
	
	@EJB
	EmployeeService es = new EmployeeService();
	
	List<AffectedProjects> data;
	
	@PostConstruct
	public void init(){
		data = ps.findMyProjects(findEmp().getId());
	}
	
	
	

	public List<AffectedProjects> getData() {
		return data;
	}

	public void setData(List<AffectedProjects> data) {
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
