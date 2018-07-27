package swing;

import common.RunThread;

public class SwingRunThread implements RunThread {

	@Override
	public void run(Runnable runnable) {
		runnable.run();
	}

}
