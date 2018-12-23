/**
 * 
 */
package aop.todos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author amit
 *
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TodoBasedDemoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class RectangleAreaLoggerAspectTest {

	@Autowired
	private Rectangle rectangle;
	
	/**
	 * calling bean method from outside bean will get advised. So, it should log "Before calculating area of Rectangle" to console
	 */
	@Test
	public void calculateAreaTest() {
		rectangle.calcualteArea();
	}

	/**
	 * This getArea() internally calls calcualteArea, but calcualteArea does not get advised.
	 * For reason refer: https://www.baeldung.com/spring-aop-vs-aspectj
	 */
	@Test
	public void getAreaTest() {
		rectangle.getArea();
	}
}
