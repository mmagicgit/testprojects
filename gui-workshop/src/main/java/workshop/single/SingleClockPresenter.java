package workshop.single;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SingleClockPresenter {

	private final ClockModel clockModel;
	private final SingleClockView clockView;

	public SingleClockPresenter(ClockModel clockModel, SingleClockView clockView) {
		this.clockModel = clockModel;
		this.clockView = clockView;
		initializeListeners();
	}

	public void changeTime() {
		clockModel.addOneSecond();
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