package swing;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import swing.city.CityClockView;

public class ClockView {

	private final JPanel panel;

	public ClockView(List<CityClockView> subViews) {
		panel = new JPanel(new GridLayout(subViews.size(), 2, 10, 10));
		for (CityClockView singleClockView : subViews) {
			panel.add(singleClockView.getTitleComponent());
			panel.add(singleClockView.getTimeComponent());
		}
	}

	public JComponent getComponent() {
		return panel;
	}

}
