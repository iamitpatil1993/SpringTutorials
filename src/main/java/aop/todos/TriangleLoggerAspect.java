/**
 * 
 */
package aop.todos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author amit
 *This aspect tries to advise area() method of triangle bean but can not, because triangle bean 
 * is declared as a final class.
 *
 */

@Aspect
@Component
public class TriangleLoggerAspect {

	@Before("execution(* aop.todos.Triangle.area())")
	public void triangleAreaLogger() {
		System.out.println("Before calculating area of triangle ....");
	}
}
