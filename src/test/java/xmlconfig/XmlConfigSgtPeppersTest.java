package xmlconfig;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:xmlconfig/xmlConfigDemoConfiguration.xml" , loader = GenericXmlContextLoader.class)
public class XmlConfigSgtPeppersTest {

	@Autowired
	private XmlConfigCompactDisk compactDisc;
	
	@Test
	public void testPlay() {
		assertNotNull(compactDisc);
		compactDisc.play();
	}
}
