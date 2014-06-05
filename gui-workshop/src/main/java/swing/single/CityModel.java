package swing.single;

import org.joda.time.DateTimeZone;

public class CityModel {
	
	public final DateTimeZone timeZone;
	public final String title;
	
	public CityModel(DateTimeZone timeZone, String title) {
		this.timeZone = timeZone;
		this.title = title;
	}
}