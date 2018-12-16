/**
 * 
 */
package externalizevalues.profilespecificproperties;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	@Autowired
	private Environment env;
	
	@Test
	public void test() {
		assertNotNull(bean);
		System.out.println("Active profile is :: " + Arrays.asList(env.getActiveProfiles()));
	}

}
