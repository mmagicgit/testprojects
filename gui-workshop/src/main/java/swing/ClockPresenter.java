package swing;

import java.util.Timer;
import java.util.TimerTask;

public class ClockPresenter {

	private final ClockModel clockModel;

	public ClockPresenter(ClockModel clockModel) {
		this.clockModel = clockModel;
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

}
