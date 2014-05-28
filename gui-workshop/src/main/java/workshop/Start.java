package workshop;


public class Start {

	public static void main(String[] args) {
		if(args == null || args.length != 1) {
			System.out.println("Wrong Parameters");
			return;
		}
		Long millis = new Long(args[0]);
		String dateTimeAsString = new MillisToStringConverter().millisToDateTimeString(millis);
		System.out.println(dateTimeAsString);
	}

}
