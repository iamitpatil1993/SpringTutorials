package beanlifecycle;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:beanlifecycle/beanLifeCycleDemoXmlConfig.xml"}, loader = GenericXmlContextLoader.class)
public class BeanLifeCycleTest {

	@Autowired
	private BeanLifeCycleEmployeeService beanLifeCycleEmployeeService;
	
	@Autowired
	private BeanLifeCycleMyEmployeeService beanLifeCycleMyEmployeeService;
	
	@Autowired
	private BeanLifeCycleMyService beanLifeCycleMyService;
	
	@Test
	public void test() {
		assertNotNull(beanLifeCycleEmployeeService);
		assertNotNull(beanLifeCycleMyEmployeeService);
		assertNotNull(beanLifeCycleMyService);
	}

}
