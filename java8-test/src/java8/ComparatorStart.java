package java8;

import java.util.Comparator;

public class ComparatorStart {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		Comparator<Integer> comparator = (o1, o2) -> {
			if(o1.equals(o2)) {
				return 0;
			}
			if(o1 > o2) {
				return -1;
			}
			return 1;
		};
		
		Comparator<Integer> uselessComparator = (o1, o2) -> 0;
		
		System.out.println(comparator.compare(a, b));
		System.out.println(uselessComparator.compare(a, b));
	}

}
