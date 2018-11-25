package soundsystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class) // or @RunWith(SpringRunner.class)
// Since we are using AnnotationConfigApplicationContext, we need to use AnnotationConfigContextLoader as a loader for loading appplication context
@ContextConfiguration(classes = { CDPlayerConfiguration.class }, loader = AnnotationConfigContextLoader.class)
public class SgtPeppersTest {

	// Using @Autowired, to check our component discovered by application context. And is should be injected here.
	// Note, we are using interface, application context will look for bean implmenting this interface.
	@Autowired
	private CompactDisk compactDisk;

	@Test
	public void testPlay() {
		assertNotNull(compactDisk);
	}
}
