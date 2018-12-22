/**
 * 
 */
package aop.annotatiobased.introduction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import aop.annotatiobased.AnnotationBasedAopJavaConfig;
import aop.annotatiobased.Performance;

/**
 * @author amit
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AnnotationBasedAopJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class AnnotationBasedEncoreableIntroducerTest {

	// This injection shows that, wherever we inject Encoreable, it will inject proxy and delegate calls
	@Autowired
	private Encoreable injectedEncoreable;

	/**
	 * This test shows that Performance beans can be casted to Encoreable, because they are indirectly implementing the interface.
	 * this is correct way, because we care accessing performance bean via one of it's indirectly implemented interface. 
	 * We should always access and call beans and their functionalities via Interfaces and not implemnting classes.
	 */
	@Test
	public void encoreableTest() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationBasedAopJavaConfig.class);
		Encoreable encoreable = (Encoreable) applicationContext.getBean(Performance.class); // IMPORTANT LINE
		encoreable.performEncore();
		applicationContext.close();
	}

	/**
	 * This test shows that, Encoreable can be injected as a normal beans.
	 */
	@Test
	public void encoureableUsingInjectedTest() {
		assertNotNull(injectedEncoreable);
		// It shows that Encoreable instance of performance i.e it's implementation introduced in Performance beans
		assertTrue(injectedEncoreable instanceof Performance); 
		
		// It shows that Encoreable is not instance of AnnotationBasedDefaultEncoreable i.e it's implementation introduced in Performance beans
		// Since AnnotationBasedDefaultEncoreable is not declared as bean, there is no way it is injected in Encoreable, so implementation is from Performance beans.
		assertFalse(injectedEncoreable instanceof AnnotationBasedDefaultEncoreable); //
		injectedEncoreable.performEncore();
		
		// This line again shows that, we can use same proxy for multiple implementations, one which are default and other 
		// are injected into it via Introduction
		Performance performance = (Performance) injectedEncoreable;
		performance.perform();
	}
}
