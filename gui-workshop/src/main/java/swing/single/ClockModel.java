package swing.single;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class ClockModel {
	
	private final DateTimeZone timeZone;
	private final String title;
	private DateTime utcDateTime;
	private ChangeListener listener;

	public ClockModel(DateTime dateTime, DateTimeZone timeZone, String title) {
		utcDateTime = dateTime;
		this.timeZone = timeZone;
		this.title = title;
	}

	public void addOneSecond() {
		utcDateTime = utcDateTime.plusSeconds(1);
		if(listener != null) {
		    listener.stateChanged(new ChangeEvent(this));
		}
	}
	
	public DateTime getDateTime() {
		return utcDateTime.withZone(timeZone);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void addChangeListener(ChangeListener listener) {
		this.listener = listener;
	}
}