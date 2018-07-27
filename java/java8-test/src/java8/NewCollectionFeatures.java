package java8;

import java.util.ArrayList;
import java.util.List;

public class NewCollectionFeatures {

	public static void main(String[] args) {
		List<String> list = createList();
		list.removeIf(t -> t == null || t.isEmpty());
		System.out.println(list);
		
		list.replaceAll(String::toUpperCase);
		System.out.println(list);
	}
	
	private static List<String> createList() {
		List<String> list = new ArrayList<String>();
		list.add("erster");
		list.add("zweiter");
		list.add("");
		list.add(null);
		return list;
	}

}
