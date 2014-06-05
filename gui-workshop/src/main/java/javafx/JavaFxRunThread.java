package javafx;

import javafx.application.Platform;
import common.RunThread;

public class JavaFxRunThread implements RunThread {

	@Override
	public void run(Runnable runnable) {
		Platform.runLater(runnable);
	}

}
