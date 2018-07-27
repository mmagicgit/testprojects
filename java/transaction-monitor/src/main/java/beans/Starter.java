package beans;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Starter {

	@Inject
	private App app;
	
	@Schedule(second = "*/20", minute="*",hour="*", persistent=false)
	public void invoke() {
		app.execute();
	}
	
}
