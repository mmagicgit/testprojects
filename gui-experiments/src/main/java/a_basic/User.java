package a_basic;

import org.joda.time.LocalDate;

public class User {

	public final String name;
	public final int age;
	public final LocalDate birthday;
	
	public User(String name, int age, LocalDate birthday) {
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	
}
