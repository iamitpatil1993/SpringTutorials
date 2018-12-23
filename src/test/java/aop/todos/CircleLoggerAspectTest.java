/**
 * 
 */
package aop.todos;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author amit
 *
 */
public class CircleLoggerAspectTest {

	@Test
	public void logBeforeCalculatingAreaTest() {
		ApplicationContext context = new AnnotationConfigApplicationContext(TodoBasedDemoJavaConfig.class);
		Circle circle = context.getBean(Circle.class);
		circle.area();
	}

}
