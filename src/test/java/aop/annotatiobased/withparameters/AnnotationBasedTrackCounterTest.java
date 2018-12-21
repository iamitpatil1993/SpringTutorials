/**
 * 
 */
package aop.annotatiobased.withparameters;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author amit
 *
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AnnotationBasedParameterizedAspectConfig.class, loader = AnnotationConfigContextLoader.class)
public class AnnotationBasedTrackCounterTest {

	@Autowired
	private AopCompactDisc disc;
	
	/**
	 * Since, aspect is a component and it is singleton by default, spring will inject same aspect instant here at which we have maintained the state of 
	 * track played count.
	 */
	@Autowired
	private AnnotationBasedTrackCounter trackCounter;
	
	@Test
	public void test() {
		assertNotNull(disc);
	}
	
	@Test
	public void counterTest() {
		// when
		disc.playTrack(3);
		disc.playTrack(3);
		disc.playTrack(3);
		disc.playTrack(5);
		disc.playTrack(5);
		disc.playTrack(5);
		disc.playTrack(344);
		
		// then
		assertEquals(Integer.valueOf(3), trackCounter.getTrackCountByTrackId(3));
		assertEquals(Integer.valueOf(3), trackCounter.getTrackCountByTrackId(5));
		assertEquals(Integer.valueOf(1), trackCounter.getTrackCountByTrackId(344));
	}

}
