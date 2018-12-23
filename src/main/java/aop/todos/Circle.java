/**
 * 
 */
package aop.todos;

import org.springframework.stereotype.Component;

/**
 * @author amit
 * We will use this bean to demonstrate
 * 1. static final method of bean can not be advised by any Spring Aspect
 *
 */

@Component
public class Circle {

	private static Float radius = 20f;

	/**
	 * Any bean method which is either of 
	 * 1. static
	 * 2. final
	 * 3. static final
	 * won't be advised by aspect. Spring won't throw any exception, but advise will get silently ignored, and won't get called.
	 * Only instance will get advised by aspects.
	 * @return
	 */
	//public static Double area() { -- advise will be ignored by static modifier.
	//public final Double area() { -- advise will be ignored by static modifier.
	//public static final Double area() { -- advise will be ignored by static modifier.
	public static Double area() {	
		System.out.println("calculating area of circle ...");
		return Math.PI * (radius * radius);
	}
}
