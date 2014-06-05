package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import swing.city.CityClockView;

import common.listener.ActionListener;

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
