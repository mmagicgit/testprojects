package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import swing.city.SwingCityClockView;
import common.ClockView;
import common.listener.ActionListener;

public class SwingClockView implements ClockView {

	private final JPanel mainPanel = new JPanel(new BorderLayout());
	private final JButton button = new JButton("doIt");
	private final JPanel clockPanel;

	public SwingClockView(List<SwingCityClockView> subViews) {
		clockPanel = new JPanel(new GridLayout(subViews.size(), 2, 10, 10));
		for (SwingCityClockView singleClockView : subViews) {
			clockPanel.add(singleClockView.getTitleComponent());
			clockPanel.add(singleClockView.getTimeComponent());
		}
		mainPanel.add(clockPanel, BorderLayout.CENTER);
		mainPanel.add(button, BorderLayout.SOUTH);
	}

	public JComponent getComponent() {
		return mainPanel;
	}
	
	@Override
	public void addActionListener(final ActionListener listener) {
		java.awt.event.ActionListener swingListener = new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.buttonPressed();
			}
		};
		button.addActionListener(swingListener);
	}

}
