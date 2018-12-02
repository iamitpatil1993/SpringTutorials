package autowiring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import config.ProjectConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProjectConfiguration.class}, loader = AnnotationConfigContextLoader.class)
public class ComponentScanFilterDemoBeanTest {

	// Since, we have added required = false, sprig will try to find and inject bean here, but we have filtered the bean from
	// scanning, so spring will not able to locate the bean and inject here. Since, required = false, it will not complain about
	// bean definition not found and wo't throw NoSuchBeanDefinitionException exception, rather simply injects null
	@Autowired(required = false)
	private ComponentScanFilterDemoBean bean;
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		assertFalse(applicationContext.containsBean("componentScanFilterDemoBean"));
		applicationContext.close();
	}
	
	@Test
	public void test1() {
		assertNull(bean);
	}
}
