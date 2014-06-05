package swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.joda.time.DateTime;

public class ClockModel {
	
	private final List<ChangeListener> listeners = new ArrayList<>();
	private boolean isStopped = false;
	private DateTime utcDateTime;

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

	public void toggleProcess() {
		isStopped = !isStopped;
	}

	public boolean isStopped() {
		return isStopped;
	}
	
}