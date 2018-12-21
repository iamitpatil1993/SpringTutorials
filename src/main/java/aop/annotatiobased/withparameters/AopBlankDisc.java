/**
 * 
 */
package aop.annotatiobased.withparameters;

import org.springframework.stereotype.Component;

/**
 * @author amit
 *
 */

@Component
public class AopBlankDisc implements AopCompactDisc {

	@Override
	public void playTrack(Integer trackId) {
		System.out.println("Plaing track with trackId :: " + trackId);
	}

}
