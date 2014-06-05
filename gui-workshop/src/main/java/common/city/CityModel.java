package common.city;

import org.joda.time.DateTimeZone;

public class CityModel {
	
	public final DateTimeZone timeZone;
	public final String title;
	public final boolean displaySeconds;
	
	public CityModel(DateTimeZone timeZone, String title, boolean displaySeconds) {
		this.timeZone = timeZone;
		this.title = title;
		this.displaySeconds = displaySeconds;
	}
}