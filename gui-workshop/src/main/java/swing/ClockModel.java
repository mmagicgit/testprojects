package swing;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.joda.time.DateTime;

public class ClockModel {
	
	private DateTime utcDateTime;
	private ChangeListener listener;

	public ClockModel(DateTime utcDateTime) {
		this.utcDateTime = utcDateTime;
	}

	public DateTime getUtcDateTime() {
		return utcDateTime;
	}
	
	public void addOneSecond() {
		utcDateTime = utcDateTime.plusSeconds(1);
		if(listener != null) {
		    listener.stateChanged(new ChangeEvent(this));
		}
	}
	
	public void addChangeListener(ChangeListener listener) {
		this.listener = listener;
	}
	
}