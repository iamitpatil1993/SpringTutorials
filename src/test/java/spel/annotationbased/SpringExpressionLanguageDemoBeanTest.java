/**
 * 
 */
package spel.annotationbased;

import static org.junit.Assert.assertNotNull;

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
@ContextConfiguration(classes = SpringExpressionLanguageDemoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class SpringExpressionLanguageDemoBeanTest {
	
	@Autowired
	private SpringExpressionLanguageDemoBean bean;

	@Test
	public void test() {
		assertNotNull(bean);
		System.out.println(bean);
	}

}
