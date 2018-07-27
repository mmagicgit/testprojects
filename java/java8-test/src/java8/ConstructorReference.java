package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class ConstructorReference {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("1", "2", "3");

		Stream<Integer> map1 = strList.stream().map(
				new Function<String, Integer>() {
					@Override
					public Integer apply(String t) {
						return new Integer(t);
					}
				});
		
		Stream<Integer> map2 = strList.stream().map((s) -> new Integer(s));

		Stream<Integer> map3 = strList.stream().map(Integer::new);

		System.out.println(Arrays.asList(map1.toArray()));
		System.out.println(Arrays.asList(map2.toArray()));
		System.out.println(Arrays.asList(map3.toArray()));
	}

}
