package example;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GreeterTest {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClass(Greeter.class).addClass(GreeterEjb.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	private Greeter greeter;
	
	@EJB
	private GreeterEjb greeterEjb;

	@Test
	public void should_create_greeting() {
		Assert.assertEquals("Hello, Earthling!", greeter.createGreeting("Earthling"));
		greeter.greet(System.out, "Earthling");
	}
	
	@Test
	public void cdiInjectedGreeter() throws Exception {
		assertNotNull(greeter);
	}
	
	@Test
	public void ejbInjectedGreeter() throws Exception {
		assertNotNull(greeterEjb);
		assertNotNull(greeterEjb.getGreeter());
	}
}
