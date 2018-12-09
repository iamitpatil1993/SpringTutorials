package conditionalbeans.environmentbased;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EnvironmentBasedConditionBeanDemoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class EnviromentBasedConditionalBeanDemoBeanTest {

	@Autowired(required = false)
	EnviromentBasedConditionalBeanDemoBean bean;
	
	@Test
	public void test() {
		// based on env set or not this will fail or succeed.
		assertNull(bean);
	}

}
