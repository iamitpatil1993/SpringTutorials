/**
 * 
 */
package aop.todos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This aspect, will try to advice static final method of Circle bean, which is supposed to failed. 
 */

@Aspect
@Component
public class CircleLoggerAspect {

	@Before(value = "execution(Double aop.todos.Circle.area())")
	public void logBeforeCalculatingArea() {
		System.out.println("Before calculating area of circle...");
	}
}
