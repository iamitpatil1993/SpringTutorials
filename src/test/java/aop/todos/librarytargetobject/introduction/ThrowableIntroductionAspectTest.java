/**
 * 
 */
package aop.todos.librarytargetobject.introduction;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aop.annotatiobased.Performance;
import aop.todos.librarytargetobject.LibraryTargetAopDemoJavaConfig;

/**
 * @author amit
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LibraryTargetAopDemoJavaConfig.class)
public class ThrowableIntroductionAspectTest {
	
	@Autowired
	private Performance performance;

	@Test
	public void test() {
		assertNotNull(performance);
		assertTrue(performance instanceof Throwable); // So, this shows that Introduction worked successfully.
		performance.perform();
	}
	
	/*
	 * So, this shows that Introduction worked successfully. 
	 */
	@Test
	public void test1() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LibraryTargetAopDemoJavaConfig.class);
		Throwable throwable = applicationContext.getBean(Throwable.class);
		throwable.getMessage();
		assertTrue(throwable instanceof Performance);
		Performance performance2 = (Performance) throwable;
		performance2.perform();
	}

}
