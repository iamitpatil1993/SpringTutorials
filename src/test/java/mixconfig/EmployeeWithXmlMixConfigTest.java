package mixconfig;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mixconfig/employeeManagementConfig.xml"}, loader = GenericXmlContextLoader.class)
public class EmployeeWithXmlMixConfigTest {
	
	@Autowired
	private Employee employee;

	@Test
	public void test() {
		assertNotNull(employee);
	}

}
