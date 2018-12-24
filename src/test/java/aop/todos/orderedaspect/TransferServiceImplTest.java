/**
 * 
 */
package aop.todos.orderedaspect;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author amit
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = OrderedAspectDemoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class TransferServiceImplTest {

	@Autowired
	private TransferService transferService;
	
	@Test
	public void test() {
		assertNotNull(transferService);
		transferService.transfer();
	}
}
