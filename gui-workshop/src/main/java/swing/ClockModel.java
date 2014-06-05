package swing;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import swing.listener.ChangeListener;

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
			listener.modelHasChanged();
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