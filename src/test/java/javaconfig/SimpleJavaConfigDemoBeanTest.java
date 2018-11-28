package javaconfig;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JavaConfiguration.class }, loader = AnnotationConfigContextLoader.class)
public class SimpleJavaConfigDemoBeanTest {

	@Autowired
	private SimpleJavaConfigDemoBean bean;

	@Autowired
	private InjectionJavaConfigDemoBean injectionJavaConfigDemoBean;

	@Test
	public void test() {
		assertNotNull(bean);
	}

	@Test
	public void test1() {
		assertNotNull(injectionJavaConfigDemoBean);
		assertNotNull(injectionJavaConfigDemoBean.getBean());
	}

	@Test
	public void beanIdNameTest() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				JavaConfiguration.class);
		assertNotNull(applicationContext.getBean("javaConfigDemoBean"));
		assertNotNull(applicationContext.getBean("javaConfigDemoBean2"));
		applicationContext.close();
	}

}
