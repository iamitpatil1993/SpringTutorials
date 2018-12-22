/**
 * 
 */
package aop.xmlbased.withparameters;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

import aop.annotatiobased.withparameters.AopCompactDisc;

/**
 * @author amit
 *
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:aop/xmlbased/XmlBasedAopConfig.xml"}, loader = GenericXmlContextLoader.class)
public class XmlBasedTrackCounterTest {

	@Autowired
	private AopCompactDisc disc;
	
	@Autowired
	private XmlBasedTrackCounter trackCounter;
	
	@Test
	public void trackCounterTest() {
		assertNotNull(disc);
		disc.playTrack(5);
		disc.playTrack(5);
		disc.playTrack(5);
		disc.playTrack(5);
		disc.playTrack(10);
		disc.playTrack(10);
		disc.playTrack(1123);
		
		assertEquals(Integer.valueOf(4), trackCounter.getTrackCountByTrackId(5));
		assertEquals(Integer.valueOf(2), trackCounter.getTrackCountByTrackId(10));
		assertEquals(Integer.valueOf(1), trackCounter.getTrackCountByTrackId(1123));
		
	}

}
