package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("erster");
		list.add("zweiter");
		
		print(list);
		
		Predicate<String> predicate = string -> string.startsWith("e");
		Stream<String> filtered = list.stream().filter(predicate);
		List<String> resultList = Arrays.asList(filtered.<String>toArray(String[]::new));
		
		print(resultList);
	}

	private static void print(List<String> list) {
		list.stream().forEach(string -> System.out.println(string));
		System.out.println();
	}
	
}
