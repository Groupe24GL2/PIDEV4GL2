package beans;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Employee;
import services.EmployeeService;

@ManagedBean(name = "loginBean")
@SessionScoped
public class loginBean {
	
	String email;
	String password ;
	@EJB
	EmployeeService es = new EmployeeService();
	
	public String doLogin(){
		String navigateTo = "null";
		if(es.login(email, password)){
			Employee e = es.findEmployeeByEmail(email);
			Cookie loginCookie = new Cookie("user",e.getId().toString());
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		    response.addCookie(loginCookie);
			loginCookie.setMaxAge(30*60);
			FacesContext.getCurrentInstance().addMessage("formeval:btn", new FacesMessage("Welcome"));
			navigateTo = "/xhtml/Profile?faces-redirect=true";
			return navigateTo;
		}
		FacesContext.getCurrentInstance().addMessage("formeval:btn", new FacesMessage("check your email/password"));
		navigateTo = "/xhtml/login?faces-redirect=true";
		return navigateTo;
	}
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
