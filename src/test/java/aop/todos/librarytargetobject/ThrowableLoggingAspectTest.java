package aop.todos.librarytargetobject;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = LibraryTargetAopDemoJavaConfig.class) // Not specifying loader, default will be
																		// DelegatingSmartContext loader which will
																		// delegate to AnnotationConfigContextLoader
public class ThrowableLoggingAspectTest {

	@Autowired
	private Throwable throwable;

	@Test
	public void test() {
		assertNotNull(throwable);
		throwable.getMessage(); // Yes, this method get advised and spring called advise :)
	}

	@Test
	public void test1() {
		assertNotNull(throwable);
		new Throwable().getMessage(); // Yes, this method did not get advised and spring did not called advise :( So,
										// we should always inject the spring or get them from applicationContext and
										// should never instantiante them and use them
	}

}
