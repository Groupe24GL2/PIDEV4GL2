package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	private String cin ; 
	private String firstName;
	private String lastName;
	private String role;
	private String Photo;
	private String mail;
	private String adresse;
	private String login;
	private String password;
	private String confirmPassword;
	private String sexe;
	private String phoneNumber;
	private String status;
	private int nbConnect;
	private Date birthDay;
 
	private String experience; 
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	


	public String getCin() {
		return cin;
	}



	public void setCin(String cin) {
		this.cin = cin;
	}



	


	public String getExperience() {
		return experience;
	}



	public void setExperience(String experience) {
		this.experience = experience;
	}



	



  
	public User(String cin, String firstName, String lastName, String role, String photo, String mail, String adresse,
			String login, String password, String confirmPassword, String sexe, String phoneNumber, String status,
			int nbConnect, Date birthDay, String experience) {
		super();
		this.cin = cin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		Photo = photo;
		this.mail = mail;
		this.adresse = adresse;
		this.login = login;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.sexe = sexe;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.nbConnect = nbConnect;
		this.birthDay = birthDay;
		this.experience = experience;
	}
	
	



	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}   
	public String getPhoto() {
		return this.Photo;
	}

	public void setPhoto(String Photo) {
		this.Photo = Photo;
	}   
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getConfirmPassword() {
		return this.confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}   
	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}   
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}   
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}   
	public int getNbConnect() {
		return this.nbConnect;
	}

	public void setNbConnect(int nbConnect) {
		this.nbConnect = nbConnect;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		birthDay = birthDay;
	}




	
   
}
