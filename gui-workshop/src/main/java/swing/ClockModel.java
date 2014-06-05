package swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.joda.time.DateTime;

public class ClockModel {
	
	private DateTime utcDateTime;
	private List<ChangeListener> listeners = new ArrayList<>();

	public ClockModel(DateTime utcDateTime) {
		this.utcDateTime = utcDateTime;
	}

	public DateTime getUtcDateTime() {
		return utcDateTime;
	}
	
	public void addOneSecond() {
		utcDateTime = utcDateTime.plusSeconds(1);
		for (ChangeListener listener : listeners) {
			listener.stateChanged(new ChangeEvent(this));
		}
	}
	
	public void addChangeListener(ChangeListener listener) {
		listeners.add(listener);
	}
	
}