package common.city;

import java.text.DecimalFormat;

import org.joda.time.DateTime;

public class CityTimeFormatter {

	public String format(DateTime cityTime, boolean displaySeconds) {
		DecimalFormat decimalFormat = new DecimalFormat("00");
		String hours = decimalFormat.format(cityTime.getHourOfDay());
		String minutes = decimalFormat.format(cityTime.getMinuteOfHour());
		String seconds = decimalFormat.format(cityTime.getSecondOfMinute());
		String cityTimeString = hours + ":" + minutes;
		if (displaySeconds) {
			cityTimeString += ":" + seconds;
		}
		return cityTimeString;
	}
	
}