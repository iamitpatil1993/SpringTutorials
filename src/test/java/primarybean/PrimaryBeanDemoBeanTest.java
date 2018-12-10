/**
 * 
 */
package primarybean;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
@ContextConfiguration(classes = PrimaryBeanDemoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class PrimaryBeanDemoBeanTest {

	@Autowired
	private PrimaryBeanDemoBean bean;
	
	@Test
	public void test() {
		assertNotNull(bean);
		assertNotNull(bean.getCacheManager());
		assertTrue(bean.getCacheManager() instanceof EhCacheManager);
	}
}
