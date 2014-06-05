package javafx;

import java.util.List;

import javafx.city.JavaFxCityClockView;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import swing.ClockModel;
import swing.ClockPresenter;
import swing.city.CityClockPresenter;
import swing.city.CityModel;

import com.google.common.collect.Lists;

public class GuiCreator {

	public GuiCreator.ClockGui create(DateTime dateTime) {
		List<JavaFxCityClockView> clockViews = Lists.newArrayList();
		List<CityClockPresenter> clockPresenters = Lists.newArrayList();
		
		ClockModel clockModel = new ClockModel(dateTime);

		createClock(" ", "Europe/Athens", dateTime, false, clockModel, clockPresenters, clockViews);
		createClock("Frankfurt", "Europe/Berlin", dateTime, true, clockModel, clockPresenters, clockViews);
		createClock("London", "Europe/London", dateTime, true, clockModel, clockPresenters, clockViews);
		createClock("New York", "America/New_York", dateTime, true, clockModel, clockPresenters, clockViews);
		createClock("Tokio", "Asia/Tokyo", dateTime, true, clockModel, clockPresenters, clockViews);
		
		JavaFxClockView clockView = new JavaFxClockView(clockViews);
		ClockPresenter clockPresenter = new ClockPresenter(clockModel, clockView);
		return new ClockGui(clockView, clockPresenter);
	}
	
	private void createClock(String title, String timeZone, DateTime dateTime, boolean withSeconds, ClockModel clockModel, List<CityClockPresenter> clockPresenters, List<JavaFxCityClockView> clockViews) {
		JavaFxCityClockView clockView = new JavaFxCityClockView();
		CityModel cityModel = new CityModel(DateTimeZone.forID(timeZone), title, withSeconds);
		CityClockPresenter clockPresenter = new CityClockPresenter(clockModel, clockView, cityModel);
		clockPresenters.add(clockPresenter);
		clockViews.add(clockView);
	}
	
	public static class ClockGui {
		
		public final JavaFxClockView view;
		public final ClockPresenter presenter;
		
		public ClockGui(JavaFxClockView view, ClockPresenter presenter) {
			this.view = view;
			this.presenter = presenter;
		}
		
	}
}