package java8;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public class DateAndTime {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		today = today.plusDays(1);
		System.out.println(today);
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);
		
		Clock utcClock = Clock.systemUTC();
		Clock zonedClock = Clock.systemDefaultZone();
		
		System.out.println(ZonedDateTime.now(utcClock));
		System.out.println(ZonedDateTime.now(zonedClock));
	}
	
}
