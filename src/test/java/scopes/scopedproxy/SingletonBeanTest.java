/**
 * 
 */
package scopes.scopedproxy;

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
@ContextConfiguration(classes = ScopedProxyDemoBeanJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class SingletonBeanTest {

	@Autowired
	private SingletonBean singletonBean;

	//@Test
	public void sayHelloTest() {
		singletonBean.sayHello();
	}
	
	//@Test
	public void sayHello1Test() {
		singletonBean.sayHello1();
	}
	
	@Test
	public void sayHello2Test() {
		singletonBean.sayHello2();
	}
}
