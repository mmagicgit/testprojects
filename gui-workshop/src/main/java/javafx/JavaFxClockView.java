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
	private final GridPane clockPanel = new GridPane();

	public JavaFxClockView(List<JavaFxCityClockView> subViews) {
		clockPanel.setHgap(10);
		clockPanel.setVgap(10);
		for (int index = 0; index < subViews.size(); index++) {
			JavaFxCityClockView singleClockView = subViews.get(index);
			clockPanel.add(singleClockView.getTitleComponent(), 0, index);
			clockPanel.add(singleClockView.getTimeComponent(), 1, index);
        }
		mainPanel.setCenter(clockPanel);
		mainPanel.setBottom(button);
	}

	public Pane getComponent() {
		return mainPanel;
	}

	@Override
	public void addActionListener(final ActionListener listener) {
		button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				listener.buttonPressed();
			}
		});
	}
}
