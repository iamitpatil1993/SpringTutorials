/**
 * 
 */
package aop.todos.orderedaspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This is one of multiple advise which will advise transfer() method of TransactionService interface.
 * This is transaction aspect, it should always be applied on target bean after authentication aspect.
 * So, this aspect has second highest precedence.
 */

@Aspect
@Component
@Order(1) // Second highest oder
public class TransactionAspect {
	
	/**
	 * Executed after authentication and before Logging and Audit Logging aspects
	 */
	@Before("execution(* aop.todos.orderedaspect.TransferService.transfer())")
	public void startAndAttachTransactionToRequest() {
		System.out.println("Enabling transaction ...");
	}
	
	/**
	 * Executes after Logging and Audit Logging aspects's @AfterReturning (Reverse order of before calling advised method)
	 */
	@AfterReturning("execution(* aop.todos.orderedaspect.TransferService.transfer())")
	public void commitTransaction() {
		System.out.println("commiting transaction ...");
	}
	
	/**
	 * Executes after Logging and Audit Logging aspects's @AfterThrowing (Reverse order of before calling advised method)
	 */
	@AfterThrowing("execution(* aop.todos.orderedaspect.TransferService.transfer())")
	public void rollbackTransaction() {
		System.out.println("rollbacking transaction ...");
	}
}
