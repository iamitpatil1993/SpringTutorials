package autocomponentscanning;

import org.springframework.stereotype.Component;

/**
 * 
 * @author amit
 * This bean and package inclosing it, is created to demonstrate the use of basePackages and paseBackageClasses attributes
 * of @ComponentScan annotation. 
 * This is demo to play around use of these two attributes in auto component scanning/discovery.
 */

@Component
public class AutoComponentScanningDemoBean {

	public void greet() {
		System.out.println("This bean injected using basePackages and/or paseBackageClasses attributes of @ComponentScan annotation.");
	}
}
