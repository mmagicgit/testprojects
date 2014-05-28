package workshop;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class MillisToDateTimeConverter {

	public DateTime utcMillisToGreeceDateTime(Long millis) {
		DateTime dateTime = new DateTime(millis, DateTimeZone.UTC);
		dateTime = dateTime.withZone(DateTimeZone.forID("Europe/Athens"));
		return dateTime;
	}
	
}