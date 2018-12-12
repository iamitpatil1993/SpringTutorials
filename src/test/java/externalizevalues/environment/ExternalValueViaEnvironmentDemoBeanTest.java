/**
 * 
 */
package externalizevalues.environment;

import static org.junit.Assert.assertEquals;
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
@ContextConfiguration(classes = ExternalValueViaEnvironmentDemoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class ExternalValueViaEnvironmentDemoBeanTest {

	@Autowired
	private ExternalValueViaEnvironmentDemoBean bean;

	@Test
	public void test() {
		assertNotNull(bean);
		assertEquals("Spring Tutorials", bean.getPropertyFromPropertyFile());
		assertEquals(Integer.valueOf(20), bean.getNumericPropertyFromPropertyFile());
		assertEquals("amipatil", bean.getPropertyFromSystemEnvironmentVariable());
		assertEquals("foo", bean.getPropertyFromSystemJvmVariable());
	}

}
