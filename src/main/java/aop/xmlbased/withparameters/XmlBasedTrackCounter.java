package aop.xmlbased.withparameters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amit
 * This is aspect, used to count number of times track played by trackId.
 * This aspect demonstrates, how to pass target method parameters to advice.
 * 
 */

public class XmlBasedTrackCounter {

	private Map<Integer, Integer> trackPlayedCount = new HashMap<>();
	
	public void updateTrackCounter(Integer trackId) {
		increamentCounterByTrackId(trackId);
		System.out.println("track counter increamented from XmlBasedTrackCounter for trackId :: " + trackId + " updated count :: " + getTrackCountByTrackId(trackId));
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
