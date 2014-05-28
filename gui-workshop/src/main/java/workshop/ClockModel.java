package workshop;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class ClockModel {
	
	private final DateTimeZone timeZone = DateTimeZone.forID("Europe/Athens");
	private DateTime clock;
	private ChangeListener listener;

	public ClockModel(DateTime dateTime) {
		clock = dateTime;
	}

	public void addOneSecond() {
		clock = clock.plusSeconds(1);
		if(listener != null) {
		    listener.stateChanged(new ChangeEvent(this));
		}
	}
	
	public DateTime getDateTime() {
		return clock.withZone(timeZone);
	}
	
	public void addChangeListener(ChangeListener listener) {
		this.listener = listener;
	}
}