package beans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import entities.State;

@ManagedBean(name = "Statedata")
@ApplicationScoped
public class StateData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public State[] getState() {
		return State.values();
		}

	public StateData() {
		// TODO Auto-generated constructor stub
	}

}
