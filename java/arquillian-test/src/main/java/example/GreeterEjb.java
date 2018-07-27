package example;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GreeterEjb {

	@Inject
	private Greeter greeter;

	public Greeter getGreeter() {
		return greeter;
	}

}
