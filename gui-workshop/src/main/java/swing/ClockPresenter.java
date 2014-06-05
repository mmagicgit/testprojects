package swing;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import swing.single.CityClockPresenter;

public class ClockPresenter {

	private List<CityClockPresenter> presenters;

	public ClockPresenter(List<CityClockPresenter> presenters) {
		this.presenters = presenters;
	}
	
	public void refreshPeriodically() {
		Timer timer = new Timer();
        TimerTask task = new TimerTask() {
			@Override
			public void run() {
				for (CityClockPresenter presenter : presenters) {
					presenter.changeTime();
				}
			}
		};
		timer.schedule(task, 0, 1000);
	}
	
	
	
}
