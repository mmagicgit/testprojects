package beans;

import interceptors.TransactionInterceptor;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.MrClientState;

@Stateless
@Interceptors(TransactionInterceptor.class)
public class App {

	@PersistenceContext
	private EntityManager entityManager;

	@Inject
	private SubApp subApp;
	
	public void execute() {
		System.out.println(entityManager.find(MrClientState.class, 1L));
		subApp.execute();
	}

}
