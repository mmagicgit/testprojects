package start;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class EntityAction {

	public void execute() {
		EntityManager entityManager = Start.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		action(entityManager);
		transaction.commit();
	}

	protected abstract void action(EntityManager entityManager); 
	
}
