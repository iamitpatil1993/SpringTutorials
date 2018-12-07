package beanidentifier;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:beanidentifier/beanIdentifierDemoConfig1.xml",
		"classpath:beanidentifier/beanIdentifierDemoConfig.xml" }, loader = GenericXmlContextLoader.class)
public class BeanIdentifierDemoTest {

	/**
	 * Test with order one Expected, Foo bean should get injected since, it's config
	 * file lister after bar and hence it's id will override Bar id
	 */
	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:beanidentifier/beanIdentifierDemoConfig1.xml",
				"classpath:beanidentifier/beanIdentifierDemoConfig.xml");
		applicationContext.setAllowBeanDefinitionOverriding(false);
		Object bean = applicationContext.getBean("barBean");
		assertNotNull(bean);
		assertTrue(bean instanceof Foo);
		applicationContext.close();
	}

	/**
	 * Test with switched order Expected, Bar bean should get injected since, it's
	 * config file lister after Foo and hence it's id will override Foo id
	 */
	@Test
	public void test1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:beanidentifier/beanIdentifierDemoConfig.xml", // Order reversed
				"classpath:beanidentifier/beanIdentifierDemoConfig1.xml");
		applicationContext.setAllowBeanDefinitionOverriding(false);
		Object bean = applicationContext.getBean("barBean");
		assertNotNull(bean);
		assertTrue(bean instanceof Bar); // Bar bean will get injected since,
											// classpath:beanidentifier/beanIdentifierDemoConfig1.xml overrides
											// classpath:beanidentifier/beanIdentifierDemoConfig.xml
		applicationContext.close();
	}

}
