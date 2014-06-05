package swing.single;

import java.text.DecimalFormat;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.joda.time.DateTime;

public class CityClockView {

	private final JPanel mainPanel = new JPanel();
	private final JLabel title = new JLabel();
	private final JLabel time = new JLabel();

	public CityClockView() {
		mainPanel.add(title);
		mainPanel.add(time);
	}
	
	public JComponent getComponent() {
		return mainPanel;
	}
	
	public void display(String title, DateTime dateTime, boolean withSeconds) {
		this.title.setText(title);
		DecimalFormat decimalFormat = new DecimalFormat("00");
		String hours = decimalFormat.format(dateTime.getHourOfDay());
		String minutes = decimalFormat.format(dateTime.getMinuteOfHour());
		String seconds = decimalFormat.format(dateTime.getSecondOfMinute());
		String cityTime = hours + ":" + minutes;
		if (withSeconds) {
			cityTime += ":" + seconds;
		}
		time.setText(cityTime);
	}
	
}
