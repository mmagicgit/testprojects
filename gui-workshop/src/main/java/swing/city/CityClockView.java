package swing.city;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CityClockView {

	private final JPanel mainPanel = new JPanel();
	private final JLabel title = new JLabel();
	private final JLabel time = new JLabel();

	public CityClockView() {
		mainPanel.add(title);
		mainPanel.add(time);
	}
	
	public JComponent getTitleComponent() {
		return title;
	}
	
	public JComponent getTimeComponent() {
		return time;
	}
	
	public void display(String title, String cityTime) {
		this.title.setText(title);
		time.setText(cityTime);
	}
	
}
