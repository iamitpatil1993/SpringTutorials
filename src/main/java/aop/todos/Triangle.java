/**
 * 
 */
package aop.todos;

import org.springframework.stereotype.Component;

/**
 * @author amit
 * This bean demonstates, final classes can not be advised.
 *
 */

/*
*spring has to use CGLib to create proxy, but it fails while creating sub-class of triangle since it is final class.
* So, unlike static/final methods which silently ignore and does not apply advise, in this case spring THROWS RuntimeException while creating
* proxy.
*/
@Component
public final class Triangle {
	
	public Double area() {
		System.out.println("calculating area of traingle...");
		return null;
	}

}
