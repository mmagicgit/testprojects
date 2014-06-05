package swing;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import swing.city.CityClockView;

public class ClockView {

	private final JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

	public ClockView(List<CityClockView> subViews) {
		for (CityClockView singleClockView : subViews) {
			panel.add(singleClockView.getTitleComponent());
			panel.add(singleClockView.getTimeComponent());
		}
	}

	public JComponent getComponent() {
		return panel;
	}

}
