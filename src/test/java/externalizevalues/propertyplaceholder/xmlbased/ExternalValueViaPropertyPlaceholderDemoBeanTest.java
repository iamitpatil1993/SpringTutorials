/**
 * 
 */
package externalizevalues.propertyplaceholder.xmlbased;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author amit
 *
 */

public class ExternalValueViaPropertyPlaceholderDemoBeanTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:externalizevalues/propertyplaceholder/xmlbased/externalValuesViaPropertyPlaceholderXmlConfig.xml",
				"classpath:externalizevalues/propertyplaceholder/xmlbased/externalValuesViaPropertyPlaceholderXmlConfig2.xml");
		assertNotNull(applicationContext.getBean("externalValueViaPropertyPlaceholderDemoBean1")); // bean get created
																									// and injection
																									// works correctly,
																									// regardless of in
																									// which xml file it
																									// is declared.
																									// <property-placeholder>
																									// get applited at
																									// container level
																									// and to all files
		assertNotNull(applicationContext.getBean("externalValueViaPropertyPlaceholderDemoBean"));
		applicationContext.close();
	}

}
