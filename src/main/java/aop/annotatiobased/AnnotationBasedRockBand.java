/**
 * 
 */
package aop.annotatiobased;

import org.springframework.stereotype.Component;

/**
 * @author amit
 * This is simple bean implementing Performance, this bean's perform method will be adviced.
 *
 */

@Component
public class AnnotationBasedRockBand implements Performance {

	@Override
	public void perform() {
		System.out.println("Performing rock band...");
	}

}
