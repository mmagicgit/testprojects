package interceptors;

import javax.annotation.Resource;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

public class TransactionInterceptor {

	@Resource(mappedName = "java:/TransactionManager")
	private TransactionManager transactionManager;

	@Inject
	private Event<TransactionInfo> event;
	
    @AroundInvoke
    public Object aroundInvoke(InvocationContext invocation) throws Exception {
        try {
        	String clazz = invocation.getMethod().getDeclaringClass().getName();
            String method = invocation.getMethod().getName();
        	Transaction transaction = transactionManager.getTransaction();
        	TransactionInfo transactionInfo = new TransactionInfo(clazz, method, transaction);
        	event.fire(transactionInfo);
            return invocation.proceed();
        } finally {
        }

    }

	
}
