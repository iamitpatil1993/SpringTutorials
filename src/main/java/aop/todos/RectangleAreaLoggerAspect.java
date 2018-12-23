/**
 * 
 */
package aop.todos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This aspect used to demonstrate, in Spring AOP, aspects aren’t applied to the method called within the same class.
 * This aspect will simply advise calculateArea method of Rectangle bean.
 *
 */

@Aspect
@Component
public class RectangleAreaLoggerAspect {

	@Before("execution(** aop.todos.Rectangle.calcualteArea())")
	public void beforeCalculatingAreaOfRectangle() {
		System.out.println("Before calculating area of Rectangle");
	}
}
