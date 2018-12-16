/**
 * 
 */
package externalizevalues.profilespecificproperties;

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
@ContextConfiguration(classes = ProfileSpecificPropertiesDemoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class ProfileSpecificPropertiesDemoBeanTest {

	@Autowired
	private ProfileSpecificPropertiesDemoBean bean;

	@Test
	public void test() {
		assertNotNull(bean);
	}

}
