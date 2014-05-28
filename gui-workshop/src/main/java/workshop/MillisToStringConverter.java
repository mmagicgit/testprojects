package workshop;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MillisToStringConverter {

	public String millisToDateTimeString(Long millis) {
		DateTime dateTime = new DateTime(millis, DateTimeZone.UTC);
		dateTime = dateTime.withZone(DateTimeZone.forID("Europe/Athens"));
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm Z");
		return formatter.print(dateTime);
	}
	
}