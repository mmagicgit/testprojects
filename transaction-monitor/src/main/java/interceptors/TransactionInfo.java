package interceptors;

import javax.transaction.Transaction;

public class TransactionInfo {

	public final String clazz;
	public final String method;
	public final Transaction transaction;

	public TransactionInfo(String clazz, String method, Transaction transaction) {
		this.clazz = clazz;
		this.method = method;
		this.transaction = transaction;
	}

}
