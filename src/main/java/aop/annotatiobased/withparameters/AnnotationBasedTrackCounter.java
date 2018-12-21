package aop.annotatiobased.withparameters;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @author amit
 *
 */

@Aspect
@Component
public class AnnotationBasedTrackCounter {

	private Map<Integer, Integer> trackPlayedCount = new HashMap<>();
	
	@Pointcut("execution(** aop.annotatiobased.withparameters.AopCompactDisc.playTrack(Integer)) && args(trackId)")
	public void trackPlayed(Integer trackId) {}
	
	@Before("trackPlayed(trackId)")
	public void updateTrackCounter(Integer trackId) {
		increamentCounterByTrackId(trackId);
		System.out.println("track counter increamented for trackId :: " + trackId + " updated count :: " + getTrackCountByTrackId(trackId));
	}
	
	private void increamentCounterByTrackId(Integer trackId) {
		if (trackPlayedCount.containsKey(trackId)) {
			trackPlayedCount.put(trackId, trackPlayedCount.get(trackId) + 1);
		} else {
			trackPlayedCount.put(trackId, 1);
		}
	}
	
	public Integer getTrackCountByTrackId(Integer trackId) {
		return trackPlayedCount.containsKey(trackId) ? trackPlayedCount.get(trackId) : 0;
	}
}
