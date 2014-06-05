package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import swing.city.CityClockView;

public class ClockView {

	private final JPanel mainPanel = new JPanel(new BorderLayout());
	private final JButton button = new JButton("doIt");
	private final JPanel clockPanel;

	public ClockView(List<CityClockView> subViews) {
		clockPanel = new JPanel(new GridLayout(subViews.size(), 2, 10, 10));
		for (CityClockView singleClockView : subViews) {
			clockPanel.add(singleClockView.getTitleComponent());
			clockPanel.add(singleClockView.getTimeComponent());
		}
		mainPanel.add(clockPanel, BorderLayout.CENTER);
		mainPanel.add(button, BorderLayout.SOUTH);
	}

	public JComponent getComponent() {
		return mainPanel;
	}

}
