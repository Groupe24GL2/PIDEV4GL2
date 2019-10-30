package beans;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import entities.Employee;
import services.EmployeeService;

@ManagedBean(name = "getUserInfoBean")
@SessionScoped
public class getUserInfo {

	String fullName;
	Employee e;

	@EJB
	EmployeeService es = new EmployeeService();

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

	public String getFullName() {
		String navigateTo = "null";
		try {
			Cookie cook = getCookie();
			Employee emp = es.findEmployeeById(Integer.parseInt(cook.getValue()));
			fullName = emp.getFirstName() + " " + emp.getLastName();
			return fullName;
		} catch (NullPointerException ex) {
			navigateTo = "/xhtml/login?faces-redirect=true";
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}

	}

	public String getRole() {
		String navigateTo = "null";
		try {
			Cookie cook = getCookie();
			Employee emp = es.findEmployeeById(Integer.parseInt(cook.getValue()));
			return emp.getRole().toString();
		} catch (NullPointerException ex) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return navigateTo;
		}

	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
