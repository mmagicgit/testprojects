package workshop;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class MillisToDateTimeConverter {

	public DateTime utcMillisDateTime(Long millis) {
		return new DateTime(millis, DateTimeZone.UTC);
	}
	
}