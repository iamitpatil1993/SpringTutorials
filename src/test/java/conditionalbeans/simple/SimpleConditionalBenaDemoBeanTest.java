package conditionalbeans.simple;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleConditionBeanDemoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class SimpleConditionalBenaDemoBeanTest {

	@Autowired(required = false) // marked required false so than it should not throw exception, rather inject
									// null value if no beanDefinition found for this bean in beanFactory
	private SimpleConditionalBenaDemoBean bean;

	@Test
	public void test() {
		// bean injected will be null, because spring container will ignore bean registration, so when we will be using
		// beanFactory to inject or access bean it won't be available in bean factory so it will inject null (due to required false)
		assertNull(bean);
	}
}
