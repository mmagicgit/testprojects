package swing;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import swing.single.SingleClockView;

public class ClockView {

	private final JPanel panel = new JPanel(new GridLayout(4, 1));
	
	public ClockView(List<SingleClockView> subViews) {
		for (SingleClockView singleClockView : subViews) {
			panel.add(singleClockView.getComponent());
		}
	}
	
	public JComponent getComponent() {
		return panel;
	}
	
}
