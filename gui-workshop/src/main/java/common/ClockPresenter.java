package common;

import java.util.Timer;
import java.util.TimerTask;

import common.listener.ActionListener;

public class ClockPresenter {

	private final ClockModel clockModel;
	private final ClockView clockView;
	private final RunThread runThread;

	public ClockPresenter(ClockModel clockModel, ClockView clockView, RunThread runThread) {
		this.clockModel = clockModel;
		this.clockView = clockView;
		this.runThread = runThread;
		initializeListeners();
	}

	public void refreshPeriodically() {
		final Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				if (!clockModel.isStopped())
					clockModel.addOneSecond();
				
			}
		};
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				runThread.run(runnable);
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
