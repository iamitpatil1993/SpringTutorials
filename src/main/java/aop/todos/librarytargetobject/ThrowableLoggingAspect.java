/**
 * 
 */
package aop.todos.librarytargetobject;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This is an aspect, which we will try to advise java.util.Throwable.getMessage() method.
 */

@Aspect
@Component
public class ThrowableLoggingAspect {

	@Before("execution(String java.lang.Throwable.getMessage())")
	public void logBeforeGetMessage() {
		System.out.println("Before Throwable.getMessage() advise...");
	}
}
