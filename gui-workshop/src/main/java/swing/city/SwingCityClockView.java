package swing.city;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class SwingCityClockView implements CityClockView {

	private final JLabel title = new JLabel();
	private final JLabel time = new JLabel();

	public JComponent getTitleComponent() {
		return title;
	}
	
	public JComponent getTimeComponent() {
		return time;
	}
	
	@Override
	public void display(String title, String cityTime) {
		this.title.setText(title);
		time.setText(cityTime);
	}
	
}
