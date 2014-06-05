package swing.single;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.joda.time.DateTime;

import swing.ClockModel;

public class CityClockPresenter {

	private final ClockModel clockModel;
	private final CityModel cityModel;
	private final CityClockView clockView;

	public CityClockPresenter(ClockModel clockModel, CityClockView clockView, CityModel cityModel) {
		this.clockModel = clockModel;
		this.clockView = clockView;
		this.cityModel = cityModel;
		initializeListeners();
	}

	public void changeTime() {
		clockModel.addOneSecond();
	}
	
	private void present() {
		DateTime cityTime = clockModel.getUtcDateTime().withZone(cityModel.timeZone);
		clockView.display(cityModel.title, cityTime);
	}
	
	private void initializeListeners() {
		clockModel.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				present();
			}
		});
	}
}