package workshop;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class ClockModel {
	
	private final DateTimeZone timeZone = DateTimeZone.forID("Europe/Athens");
	private DateTime utcDateTime;
	private ChangeListener listener;

	public ClockModel(DateTime dateTime) {
		utcDateTime = dateTime;
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
	
	public void addChangeListener(ChangeListener listener) {
		this.listener = listener;
	}
}