package java8;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		Optional<String> optional = Optional.ofNullable(null);
		System.out.println(optional.isPresent());
		
		Optional<String> optional2 = Optional.ofNullable("");
		System.out.println(optional2.isPresent());
		
		Optional<String> optional3 = Optional.empty();
		System.out.println(optional3.isPresent());
	}
	
}
