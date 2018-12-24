/**
 * 
 */
package aop.todos.orderedaspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This is one of multiple advise which will advise transfer() method of TransactionService interface.
 * Since, this is authentication aspect, it should always be applied on target bean first.
 * So, this aspect has highest precedence.
 */

@Aspect
@Component
@Order(0) // Highest priority
public class AuthenticationAspect {
	
	/**
	 * This advise will always be applied first among all other advised.
	 * If this advise has after/afterReturning/afterThrowing advised then they will execute last.
	 */
	@Before("execution(** aop.todos.orderedaspect.TransferService.transfer())")
	public void authenticate() {
		System.out.println("Authenticating before performing transaction i.e transfer");
	}
}
