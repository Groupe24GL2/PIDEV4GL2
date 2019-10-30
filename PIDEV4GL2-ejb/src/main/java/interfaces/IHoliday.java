package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Holiday;

@Remote
public interface IHoliday {
	
	public int addHoliday(Holiday A);
	public void updateHoliday(Holiday A);
	public Holiday findHolidayById(int id);
	public List<Holiday> findAllHolidaysRequests();
	public Boolean AcceptHoliday(Holiday A);
	public Boolean refusHoliday(Holiday A);
}
