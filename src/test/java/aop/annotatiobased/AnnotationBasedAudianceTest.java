/**
 * 
 */
package aop.annotatiobased;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author amit
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnotationBasedAopJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class AnnotationBasedAudianceTest {

	/**
	 * Since, we have used interface in pointcut expression, we must use interface here to inject bean, we can not 
	 * declare it's type to be AnnotationBasedRockBand. It's failing with exception don't know why. 
	 * I will come up with explaination and reason coming demos
	 */
	@Autowired
	private Performance bean;
	
	@Test
	public void test() {
		assertNotNull(bean);
		bean.perform(); // this will invoke two before advice and then method and then after advice.
	}

}
