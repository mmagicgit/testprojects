package listeners;

import interceptors.TransactionInfo;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

public class TransactionStatusListener {

	public void inProgress(@Observes(during=TransactionPhase.IN_PROGRESS) TransactionInfo transaction) {
		System.out.println(transaction.clazz + "." + transaction.method);
		System.out.println("In progress:       " + transaction.transaction);
		System.out.println();
	}

	public void onSucess(@Observes(during=TransactionPhase.AFTER_SUCCESS) TransactionInfo transaction) {
		System.out.println(transaction.clazz + "." + transaction.method);
		System.out.println("On Sucess:         " + transaction.transaction);
		System.out.println();
	}

	public void onFailure(@Observes(during=TransactionPhase.AFTER_FAILURE) TransactionInfo transaction) {
		System.out.println(transaction.clazz + "." + transaction.method);
		System.out.println("On Failure:        " + transaction.transaction);
		System.out.println();
	}

	public void beforeCompletion(@Observes(during=TransactionPhase.BEFORE_COMPLETION) TransactionInfo transaction) {
		System.out.println(transaction.clazz + "." + transaction.method);
		System.out.println("Before Completion: " + transaction.transaction);
		System.out.println();
	}
	
	public void afterCompletion(@Observes(during=TransactionPhase.AFTER_COMPLETION) TransactionInfo transaction) {
		System.out.println(transaction.clazz + "." + transaction.method);
		System.out.println("After Completion:  " + transaction.transaction);
		System.out.println();
	}

}
