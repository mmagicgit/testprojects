package java8;

@FunctionalInterface
public interface MyFunctionalInterface {

	boolean doIt();
	
	default void check() {
		System.out.println("check");
	}
	
}
