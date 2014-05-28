package workshop;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.joda.time.DateTime;

public class Start {

	public static void main(String[] args) {
		if (args == null || args.length != 1) {
			System.out.println("Wrong Parameters");
			return;
		}
		Long millis = new Long(args[0]);
		DateTime dateTime= new MillisToDateTimeConverter().utcMillisDateTime(millis);

		ClockModel clockModel = new ClockModel(dateTime);
		final ClockView clockView = new ClockView();
		new ClockPresenter(clockModel, clockView).refreshPeriodically();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(clockView.getComponent());
			}
		});
	}
	
	private static void createAndShowGUI(JComponent display) {
        JFrame frame = new JFrame("Zeit in Griechenland");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(display);
        frame.pack();
        frame.setVisible(true);
    }
}
