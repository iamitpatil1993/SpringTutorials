/**
 * 
 */
package aop.annotatiobased.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author amit 
 * This is aspect, used to demonstrate around advice in spring AOP.
 *         This aspect will advice Performance.perform() method using around
 *         advice.
 *
 */

@Aspect
@Component
public class AnnotationBasedAroundAudiance {

	@Pointcut("execution(void aop.annotatiobased.Performance.perform())") // pointcut expression for exact match to
	// Performance.perform() (Just for try)
	public void performance() {
		// This should be empty. Having code here won't matter, but it won't be of any
		// use.
	}

	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		switchOffPhones();
		try {
			proceedingJoinPoint.proceed();
			applause();
		} catch (Throwable e) {
			System.out.println("We want refund.... from around advice");
			throw e; 	// It's very important to re-throw this exception, if we have other advices (may
						// be not defined by you but by some other developer and u don't have any idea
						// about any other advices written on same target) on same target and those
						// advice has @Afterreturnung (means successful) and/or @AfterThrowing advices.
						// 1. If this exception not thrown, other advices will think that, it was
						// Successful operation and hence will call @AfterReturning advice (which
						// should not get called if exception from adviced method)
						// 2. if this exception is not thrown, other advices will think, it was
						// Successful operation so, @AfterThrowing advice in other aspects on same
						// target won't get called (Which should also get called.)
		}
	}

	public void switchOffPhones() {
		System.out.println("Turning off the phones from Around advice..");
	}

	public void applause() {
		System.out.println("Clap!  Clap! Clap! from around advice");
	}
}
