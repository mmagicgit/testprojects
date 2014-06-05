package javafx;

import javafx.GuiCreator.ClockGui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class JavaFxLauncher extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		for (String parameter : getParameters().getRaw()) {
			System.out.println(parameter);
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		DateTime dateTime = new DateTime().withZone(DateTimeZone.forID("Europe/Athens"));
		ClockGui gui = new GuiCreator().create(dateTime);
		gui.presenter.refreshPeriodically();
		display(stage, gui.view.getComponent());
	}

	private void display(Stage stage, Pane guiContent) {
		stage.setTitle("Zeit an wichtigen Orten");
		stage.setScene(new Scene(guiContent));
		stage.setWidth(640);
		stage.show();
	}

}
