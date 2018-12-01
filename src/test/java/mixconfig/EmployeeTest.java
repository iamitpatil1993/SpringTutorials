package mixconfig;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
// this commented line also work, we can list all config manually or we can create tree of config and speciy only single top level config here to container
//@ContextConfiguration(classes = {AddressConfig.class, EmployeeManagmentConfig.class, ManagerConfig.class}, loader = AnnotationConfigContextLoader.class)
@ContextConfiguration(classes = {EmployeeManagmentConfig.class}, loader = AnnotationConfigContextLoader.class)
public class EmployeeTest {

	@Autowired
	private Employee employee;
	
	@Test
	public void test() {
		assertNotNull(employee);
	}

}
