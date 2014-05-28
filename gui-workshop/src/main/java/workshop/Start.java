package workshop;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Start {

	public static void main(String[] args) {
		if(args == null || args.length != 1) {
			System.out.println("Wrong Parameters");
			return;
		}
		Long millis = new Long(args[0]);
		String dateTimeAsString = millisToDateTimeString(millis);
		System.out.println(dateTimeAsString);
	}

	private static String millisToDateTimeString(Long millis) {
		DateTime dateTime = new DateTime(millis, DateTimeZone.UTC);
		dateTime = dateTime.withZone(DateTimeZone.forID("Europe/Athens"));
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm");
		return formatter.print(dateTime);
	}

}
