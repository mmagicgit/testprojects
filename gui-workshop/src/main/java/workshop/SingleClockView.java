package workshop;

import java.text.DecimalFormat;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.joda.time.DateTime;

public class SingleClockView {

	private final JPanel jPanel = new JPanel();
	private final JLabel title = new JLabel();
	private final JLabel hours = new JLabel("00");
	private final JLabel minutes = new JLabel("00");
//	private final JLabel seconds = new JLabel("00");

	public JComponent getComponent() {
		jPanel.add(title);
		jPanel.add(hours);
		jPanel.add(minutes);
//		jPanel.add(seconds);
		return jPanel;
	}
	
	public void display(DateTime dateTime) {
		DecimalFormat decimalFormat = new DecimalFormat("00");
		hours.setText(decimalFormat.format(dateTime.getHourOfDay()));
		minutes.setText(decimalFormat.format(dateTime.getMinuteOfHour()));
//		seconds.setText(decimalFormat.format(dateTime.getSecondOfMinute()));
	}
	
}
