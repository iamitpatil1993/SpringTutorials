/**
 * 
 */
package aop.todos.orderedaspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This is one of multiple advise which will advise transfer() method of TransactionService interface.
 * This is transaction aspect, it should always be applied on target bean after transaction aspect.
 * So, this aspect has third highest precedence.
 * 
 * NOTE: This aspect has around advise
 */

@Aspect
@Component
@Order(2)
public class TransactionServiceLoggingAspect {

	@Around("execution(* aop.todos.orderedaspect.TransferService.transfer())")
	public void logAroundTransaction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		try {
		// Before - part of around advise
		System.out.println("TransactionService.transfer() called ...");
		
		// before calling this, spring checks any aspect with before advise and lower priority than this exists,
		// if yes it first calls that aspect's before advise and then calls below method
		proceedingJoinPoint.proceed();
		
		// before executing any code after  proceedingJoinPoint.proceed(), spring checks any aspect with afterReturning advise and lower priority than this exists,
		// if yes it first calls that aspect's afterReturning advise and then executes below code
		
		// after - part of around advise
		System.out.println("TransactionService.transfer() executed successfully ...");
		} catch (Throwable e) {
			// before executing any code in this block, spring checks any aspect with afterThrowinging advise and lower priority than this exists,
			// if yes it first calls that aspect's afterThrowinging advise and then executes below code
			// after-throwing - part of around advise
			System.out.println("Something went wrong while processing transaction... Please try again later");
			throw e;
		}
	}
}
