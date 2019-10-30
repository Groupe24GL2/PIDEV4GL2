package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="Holiday")
public class Holiday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1825681491784659661L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name ="descreption")
	private String descreption;
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name ="duration")
    private int duration;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private StateHoliday state;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "applicant")
    private Employee applicant;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public StateHoliday getState() {
		return state;
	}
	public void setState(StateHoliday state) {
		this.state = state;
	}
	public Employee getApplicant() {
		return applicant;
	}
	public void setApplicant(Employee applicant) {
		this.applicant = applicant;
	}
    
    
    
    
    
    
    
    }
