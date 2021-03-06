package autocomponentscanning.usingbasepackageclasses;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import config.ProjectConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProjectConfiguration.class}, loader = AnnotationConfigContextLoader.class)
public class AutoScanningComponentDemoBean1Test {

	@Autowired
	private AutoScanningComponentDemoBean1 bean;
	
	@Test
	public void testGreet() {
		assertNotNull(bean);
		bean.greet();
	}

}
