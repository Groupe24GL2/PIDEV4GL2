package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Holiday;
import entities.StateHoliday;
import interfaces.IHoliday;

@Stateless
@Remote
@LocalBean
public class HolidayService implements IHoliday {
	
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;

	@Override
	public int addHoliday(Holiday A) {
		em.persist(A);
		System.out.println("Out of addEmployee" + A.getId());
		return A.getId();
	}

	@Override
	public void updateHoliday(Holiday A) {
		System.out.println("In updateAccount: ");
		Holiday holiday = em.find(Holiday.class, A.getId());
		if(holiday.getState().equals(StateHoliday.pending)){
			holiday.setDescreption(A.getDescreption());
			holiday.setDuration(A.getDuration());
			holiday.setStartDate(A.getStartDate());
		}
	}

	@Override
	public Holiday findHolidayById(int id) {
		// TODO Auto-generated method stub
		return em.find(Holiday.class, id);
	}

	@Override
	public List<Holiday> findAllHolidaysRequests() {
		// TODO Auto-generated method stub
		return em.createQuery("select l from Holiday l where l.state =:s", Holiday.class).setParameter("s", StateHoliday.pending).getResultList();
	}

	@Override
	public Boolean AcceptHoliday(Holiday A) {
		System.out.println("In AcceptHoliday: ");
		Holiday holiday = em.find(Holiday.class, A.getId());
		if(holiday.getState().equals(StateHoliday.pending)){
			holiday.setState(StateHoliday.approved);
			return true; 
		} else {
			return false ;
		}
	}

	@Override
	public Boolean refusHoliday(Holiday A) {
		System.out.println("In AcceptHoliday: ");
		Holiday holiday = em.find(Holiday.class, A.getId());
		if(holiday.getState().equals(StateHoliday.pending)){
			holiday.setState(StateHoliday.refus);
			return true; 
		} else {
			return false ;
		}
		
	}

}
