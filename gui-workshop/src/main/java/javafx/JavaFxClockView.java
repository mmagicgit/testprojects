package javafx;

import java.util.List;

import javafx.city.JavaFxCityClockView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import swing.ClockView;

import common.listener.ActionListener;

public class JavaFxClockView implements ClockView {

	private final BorderPane mainPanel = new BorderPane();
	private final Button button = new Button("doIt");
	private final GridPane clockPanel;

	public JavaFxClockView(List<JavaFxCityClockView> subViews) {
		clockPanel = new GridPane();
		clockPanel.setHgap(10);
		clockPanel.setVgap(10);
		
		int line = 0;
		for (JavaFxCityClockView singleClockView : subViews) {
			clockPanel.add(singleClockView.getTitleComponent(), 0, line);
			clockPanel.add(singleClockView.getTimeComponent(), 1, line);
			line++;
		}
		mainPanel.setCenter(clockPanel);
		mainPanel.setBottom(button);
	}

	public Pane getComponent() {
		return mainPanel;
	}

	@Override
	public void addActionListener(final ActionListener listener) {
		button.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						listener.buttonPressed();
					}
				});
	}
}