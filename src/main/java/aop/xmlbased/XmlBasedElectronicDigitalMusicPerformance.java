/**
 * 
 */
package aop.xmlbased;

import aop.annotatiobased.Performance;

/**
 * @author amit 
 * This is another implementation of Performance interface
 *
 */

public class XmlBasedElectronicDigitalMusicPerformance implements Performance {

	@Override
	public void perform() {
		System.out.println("performing Xml based EDM ....");
	}

}
