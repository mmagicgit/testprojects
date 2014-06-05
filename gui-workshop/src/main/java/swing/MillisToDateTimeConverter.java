package swing;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class MillisToDateTimeConverter {

	public DateTime utcMillisToDateTime(Long millis) {
		return new DateTime(millis, DateTimeZone.UTC);
	}
	
}