package workshop;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import workshop.single.SingleClockPresenter;

public class ClockPresenter {

	private List<SingleClockPresenter> presenters;

	public ClockPresenter(List<SingleClockPresenter> presenters) {
		this.presenters = presenters;
	}
	
	public void refreshPeriodically() {
		Timer timer = new Timer();
        TimerTask task = new TimerTask() {
			@Override
			public void run() {
				for (SingleClockPresenter presenter : presenters) {
					presenter.changeTime();
				}
			}
		};
		timer.schedule(task, 0, 1000);
	}
	
	
	
}
