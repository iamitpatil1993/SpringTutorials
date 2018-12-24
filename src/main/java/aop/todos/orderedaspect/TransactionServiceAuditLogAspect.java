/**
 * 
 */
package aop.todos.orderedaspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This aspect should always run at the last.
 */

@Aspect
@Component
// Default order is Ordered.LOWEST_PRECEDENCE, so this will get called last in before advises and first in after advises
public class TransactionServiceAuditLogAspect {
	
	/**
	 * Executes after Logging aspect (which is around aspect.) 
	 * What spring does is, it calls around aspect (Logging), and before calling proceedingJoinPoint.proceed() it calls this method.
	 * So, it pauses around advise execution, calls this and then continues around advise and calls proceedingJoinPoint.proceed()
	 */
	@Before("execution(* aop.todos.orderedaspect.TransferService.transfer())")
	public void before() {
		System.out.println("Audit Logging before transaction ...");
	}
	
	
	/**
	 * Executes before after part of Logging aspect (which is around aspect.) i,e code after proceedingJoinPoint.proceed() 
	 * What spring does is, it calls around aspect (Logging), and executing code after proceedingJoinPoint.proceed() it calls this method.
	 * So, it pauses around advise execution, calls this and then continues around advise and calls after part of around advise
	 */
	@AfterReturning("execution(* aop.todos.orderedaspect.TransferService.transfer())")
	public void successfulyOperationLogging() {
		System.out.println("Audit Logging successful transaction ...");
	}
	
	/**
	 *Same here only context will be of exeception
	 */
	@AfterThrowing("execution(* aop.todos.orderedaspect.TransferService.transfer())")
	public void failedOperationLogging() {
		System.out.println("Audit Logging failed transaction ...");
	}

}
