/**
 * 
 */
package aop.annotatiobased;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author amit This is our aspect, implemented using AspectJ's annotations
 *         (Annotation based) It will advice, all implementations of
 *         Performance.perform()
 *
 */
@Aspect
@Component // V.V.IMP -> Aspects needs to be declared as beans as well, otherwise it won't
			// advice the target objects. It won't throw any error/exception, but it's like
			// no aspect present of target object.
public class AnnotationBasedAudiance {

	@Pointcut("execution(** aop.annotatiobased.Performance.perform(..))")
	public void performance() {
	};

	@Before("performance()")
	public void switchOffPhones() {
		System.out.println("Switcing off the phones...");
	}

	@Before("performance()")
	public void takeSeat() {
		System.out.println("Taking seats");
	}

	@After("performance()")
	public void applause() {
		System.out.println("CLAP CLAP CLAP!!!");
	}

	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Demanding a refund");
	}
}
