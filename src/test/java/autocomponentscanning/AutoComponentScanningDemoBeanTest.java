package autocomponentscanning;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import soundsystem.CDPlayerConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CDPlayerConfiguration.class}, loader = AnnotationConfigContextLoader.class)
public class AutoComponentScanningDemoBeanTest {

	@Autowired
	private AutoComponentScanningDemoBean bean;
	
	@Test
	public void testGreet() {
		assertNotNull(bean);
		bean.greet();
	}
}
