package workshop;

import java.util.Timer;
import java.util.TimerTask;

public class ClockPresenter {

	private final ClockModel clockModel;
	private final ClockView clockView;

	public ClockPresenter(ClockModel clockModel, ClockView clockView) {
		this.clockModel = clockModel;
		this.clockView = clockView;
	}
	
	public void refreshPeriodically() {
		Timer timer = new Timer();
        TimerTask task = new TimerTask() {
			@Override
			public void run() {
				clockModel.addOneSecond();
				clockView.display(clockModel.clock);
			}
		};
		timer.schedule(task, 0, 1000);
	}
	
}