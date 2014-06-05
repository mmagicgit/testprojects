package swing;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.joda.time.DateTime;

import swing.GuiCreator.ClockGui;

public class Start {

	public static void main(String[] args) {
		if (args == null || args.length != 1) {
			System.out.println("Wrong Parameters");
			return;
		}
		Long millis = new Long(args[0]);
		DateTime dateTime= new MillisToDateTimeConverter().utcMillisToDateTime(millis);

		final ClockGui clockGui = new GuiCreator().create(dateTime);
		clockGui.presenter.refreshPeriodically();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(clockGui.view.getComponent());
			}
		});
	}

	private static void createAndShowGUI(JComponent display) {
        JFrame frame = new JFrame("Zeit an wichtigen Orten");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(display);
        frame.pack();
        frame.setVisible(true);
    }
	
}
