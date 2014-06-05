package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class ClockPresenter {

	private final ClockModel clockModel;
	private final ClockView clockView;

	public ClockPresenter(ClockModel clockModel, ClockView clockView) {
		this.clockModel = clockModel;
		this.clockView = clockView;
		initializeListeners();
	}

	private void initializeListeners() {
		this.clockView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clockModel.toggleProcess();
			}
		});
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

}
