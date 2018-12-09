package conditionalbeans.environmentbased;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EnvironmentBasedConditionBeanDemoJavaConfig2.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(value = {"dev"}) // if we comment this line test will fail
public class EnvironmentBasedBeanCreationCondition2Test {

	@Autowired
	private EnviromentBasedConditionalBeanDemoBean bean;
	
	@Test
	public void test() {
		assertNotNull(bean);
	}
}
