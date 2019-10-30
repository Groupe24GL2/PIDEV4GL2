package interfaces;

import javax.ejb.Remote;

import entities.Entrepreneur;

@Remote
public interface IDiagnostic {

	public String diagnostic(Entrepreneur e);
}
