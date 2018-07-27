package beans;

import interceptors.TransactionInterceptor;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.MrClientState;

@Stateless
@Interceptors(TransactionInterceptor.class)
public class SubApp {

	@PersistenceContext
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void execute() {
		System.out.println(entityManager.find(MrClientState.class, 2L));
	}

}
