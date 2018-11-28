package soundsystem;

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
public class CDPlayerImplTest {

	// Note this is interface and not impl (CDPlayerImpl) class.
	@Autowired
	private CDPlayer cdPlayer; 
	
	@Test
	public void testPlay() {
		assertNotNull(cdPlayer);
		cdPlayer.play();
	}
}
