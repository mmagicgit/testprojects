package workshop;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.joda.time.DateTime;

public class ClockModel {
	
	public DateTime clock;
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
	
	public void addChangeListsner(ChangeListener listener) {
		this.listener = listener;
	}
}