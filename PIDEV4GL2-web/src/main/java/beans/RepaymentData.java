package beans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import entities.RepaymentMethod;

@ManagedBean(name = "dataRepayment")
@ApplicationScoped
public class RepaymentData implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	public RepaymentMethod[] getRepaymentMethod() {
		return RepaymentMethod.values();
		}
	
	

	public RepaymentData() {
		// TODO Auto-generated constructor stub
	}

}
