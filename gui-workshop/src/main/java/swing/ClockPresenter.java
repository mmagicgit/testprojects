package swing;

import java.util.Timer;
import java.util.TimerTask;

import swing.listener.ActionListener;

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
				if(!clockModel.isStopped())
				clockModel.addOneSecond();
			}
		};
		timer.schedule(task, 0, 1000);
	}

	private void initializeListeners() {
		this.clockView.addActionListener(new ActionListener() {
			@Override
			public void buttonPressed() {
				clockModel.toggleProcess();
			}
		});
	}

}
