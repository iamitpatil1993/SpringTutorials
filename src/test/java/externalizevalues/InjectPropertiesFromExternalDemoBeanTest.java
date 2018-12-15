/**
 * 
 */
package externalizevalues;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

/**
 * @author amit
 *
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
		"classpath:externalizevalues/injectPropertiesFromExternalDemoConfig.xml" }, loader = GenericXmlContextLoader.class)
public class InjectPropertiesFromExternalDemoBeanTest {

	@Autowired
	private InjectPropertiesFromExternalDemoBean bean;

	@Autowired
	private Environment env;

	@Test
	public void test() {
		assertNotNull(bean);
		assertEquals("Spring Tutorials", bean.getExternalProperties().getProperty("app.name"));
	}

	/**
	 * Checks, whether manually added property Source successfully get added to
	 * environment.
	 */
	@Test
	public void manualExternalPropertySourceAdditionTest() {
		assertEquals("Spring Tutorials", env.getProperty("app.name"));
	}

}
