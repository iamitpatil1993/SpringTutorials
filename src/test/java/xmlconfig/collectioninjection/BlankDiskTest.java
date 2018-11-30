package xmlconfig.collectioninjection;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

import soundsystem.CompactDisk;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:xmlconfig/xmlConfigDemoConfiguration.xml"}, loader = GenericXmlContextLoader.class)
public class BlankDiskTest {

	// Note, there are many beans implementing CompactDisk interface in our code, and non of them have marked as primary or
	// used Qualifier, still container not throwing exception, this is because, we have used only one xml config file for
	// container creation and there is only one bean declared in that xml file which implements CompactDisk.
	// All other implementing classes are not considered in container creation time sice they are not declared in xmlConfigDemoConfiguration.xml
	@Autowired
	private CompactDisk compactDisk;
	
	@Test
	public void test() {
		assertNotNull(compactDisk);
		assertTrue(compactDisk instanceof BlankDisk);
	}

}
