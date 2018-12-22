/**
 * 
 */
package aop.xmlbased;

import aop.annotatiobased.Performance;

/**
 * @author amit
 * This is a bean that implements Performance interface
 *
 */

public class XmlBasedRockBand implements Performance {

	@Override
	public void perform() {
		System.out.println("Performing rock band from XmlBasedRockBand...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
