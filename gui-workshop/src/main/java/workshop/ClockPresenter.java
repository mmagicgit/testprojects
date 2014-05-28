package workshop;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ClockPresenter {

	private final ClockModel clockModel;
	private final ClockView clockView;

	public ClockPresenter(ClockModel clockModel, ClockView clockView) {
		this.clockModel = clockModel;
		this.clockView = clockView;
		initializeListeners();
	}

	public void refreshPeriodically() {
		Timer timer = new Timer();
        TimerTask task = new TimerTask() {
			@Override
			public void run() {
				clockModel.addOneSecond();
			}
		};
		timer.schedule(task, 0, 1000);
	}
	
	private void initializeListeners() {
		clockModel.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				clockView.display(clockModel.getDateTime());
			}
		});
	}
}