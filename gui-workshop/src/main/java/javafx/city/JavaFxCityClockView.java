package javafx.city;

import javafx.scene.control.Label;
import swing.city.CityClockView;

public class JavaFxCityClockView implements CityClockView {

	private final Label title = new Label();
	private final Label time = new Label();

	public Label getTitleComponent() {
		return title;
	}
	
	public Label getTimeComponent() {
		return time;
	}
	
	@Override
	public void display(String title, String cityTime) {
		this.title.setText(title);
		time.setText(cityTime);
	}
	
}
