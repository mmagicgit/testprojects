package swing.city;

import org.joda.time.DateTime;

import swing.ClockModel;
import swing.listener.ChangeListener;

public class CityClockPresenter {

	private final CityTimeFormatter cityTimeFormatter = new CityTimeFormatter();
	private final ClockModel clockModel;
	private final CityModel cityModel;
	private final CityClockView clockView;

	public CityClockPresenter(ClockModel clockModel, CityClockView clockView, CityModel cityModel) {
		this.clockModel = clockModel;
		this.clockView = clockView;
		this.cityModel = cityModel;
		initializeListeners();
	}

	private void present() {
		DateTime cityTime = clockModel.getUtcDateTime().withZone(cityModel.timeZone);
		String cityTimeString = cityTimeFormatter.format(cityTime, cityModel.displaySeconds);
		clockView.display(cityModel.title, cityTimeString);
	}

	private void initializeListeners() {
		clockModel.addChangeListener(new ChangeListener() {
			@Override
			public void modelHasChanged() {
				present();
			}
		});
	}
}