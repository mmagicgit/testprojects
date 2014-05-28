package workshop;

import org.joda.time.DateTime;

public class ClockModel {
	
	public DateTime clock;

	public ClockModel(DateTime dateTime) {
		clock = dateTime;
	}

	public void addOneSecond() {
		clock = clock.plusSeconds(1);
		
	}
}