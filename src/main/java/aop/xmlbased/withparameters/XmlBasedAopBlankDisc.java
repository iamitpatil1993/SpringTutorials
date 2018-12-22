/**
 * 
 */
package aop.xmlbased.withparameters;

import aop.annotatiobased.withparameters.AopCompactDisc;

/**
 * @author amit
 *
 */
public class XmlBasedAopBlankDisc implements AopCompactDisc {

	@Override
	public void playTrack(Integer trackId) {
		System.out.println("Playing track from XmlBasedAopBlankDisc, track Id :: " + trackId);
	}

}
