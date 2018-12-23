package aop.todos;

import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TriangleLoggerAspectTest {

	/**
	 * This test case will succeed i.e spring will throw BeanCreationException.
	 * This is because, we are trying to weave aspect on triangle class which is final class.
	 * While weaving aspect spring has two choices 
	 * 1. Default JDK proxy - For interface based 
	 * 2. CGLib - For sub class based 
	 * In this case, spring has to use CGLib to create proxy, but it fails while creating sub-class of triangle since it is final class.
	 * So, unlike static/final methods which silently ignore and does not apply advise, in this case spring THROWS RuntimeException while creating
	 * proxy.
	 */
	@Test(expected = BeanCreationException.class)
	public void test() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TodoBasedDemoJavaConfig.class);
		Triangle triangle = applicationContext.getBean(Triangle.class);
		triangle.area();
	}

}
