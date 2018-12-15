/**
 * 
 */
package externalizevalues;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Test
	public void test() {
		assertNotNull(bean);
		assertEquals("Spring Tutorials", bean.getExternalProperties().getProperty("app.name"));
	}

}
