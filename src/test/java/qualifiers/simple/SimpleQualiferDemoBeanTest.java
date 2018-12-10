package qualifiers.simple;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SimpleQualifierDemoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class SimpleQualiferDemoBeanTest {

	@Autowired
	private SimpleQualiferDemoBean bean;
	
	@Test
	public void test() {
		assertNotNull(bean);
		assertNotNull(bean.getDessert());
		assertTrue(bean.getDessert() instanceof IceCream);
	}

}
