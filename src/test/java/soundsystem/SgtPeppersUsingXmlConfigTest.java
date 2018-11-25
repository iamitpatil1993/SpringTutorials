package soundsystem;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "cdPlayerConfiguration.xml" }, loader = GenericXmlContextLoader.class)
public class SgtPeppersUsingXmlConfigTest {

	@Autowired
	private CompactDisk compactDisk;

	@Test
	public void testPlay() {
		assertNotNull(compactDisk);
	}

}
