package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StreamTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("erster");
		list.add("zweiter");
		System.out.println(list);
		
		Predicate<String> predicate = string -> string.startsWith("e");
		
		list.stream().filter(predicate).forEach(string -> System.out.println(string));
		
		//TODO: convert Stream<String> back to List<String> 
	}
	
}
