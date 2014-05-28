package workshop;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import workshop.single.ClockModel;
import workshop.single.SingleClockPresenter;
import workshop.single.SingleClockView;

import com.google.common.collect.Lists;

public class GuiCreator {

	public GuiCreator.ClockGui create(DateTime dateTime) {
		List<SingleClockView> clockViews = Lists.newArrayList();
		List<SingleClockPresenter> clockPresenters = Lists.newArrayList();
		
		createClock(" ", "Europe/Athens", dateTime, false, clockPresenters, clockViews);
		createClock("Frankfurt", "Europe/Berlin", dateTime, true, clockPresenters, clockViews);
		createClock("New York", "America/New_York", dateTime, true, clockPresenters, clockViews);
		createClock("Tokio", "Asia/Tokyo", dateTime, true, clockPresenters, clockViews);
		
		final ClockView clockView = new ClockView(clockViews);
		ClockPresenter clockPresenter = new ClockPresenter(clockPresenters);
		return new ClockGui(clockView, clockPresenter);
	}
	
	private void createClock(String title, String timeZone, DateTime dateTime, boolean withSeconds, List<SingleClockPresenter> clockPresenters, List<SingleClockView> clockViews) {
		ClockModel clockModel = new ClockModel(dateTime, DateTimeZone.forID(timeZone));
		SingleClockView clockView = new SingleClockView(title, withSeconds);
		SingleClockPresenter clockPresenter = new SingleClockPresenter(clockModel, clockView);
		clockPresenters.add(clockPresenter);
		clockViews.add(clockView);
	}

	
	public static class ClockGui {
		
		public final ClockView view;
		public final ClockPresenter presenter;
		
		public ClockGui(ClockView view, ClockPresenter presenter) {
			this.view = view;
			this.presenter = presenter;
		}
		
	}
}