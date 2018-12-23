/**
 * 
 */
package aop.todos;

import org.springframework.stereotype.Component;

/**
 * @author amit 
 * This bean used to demonstrate that, Spring AOP, aspects aren’t applied to the method called within the same class.
 *
 */

@Component
public class Rectangle {

	private Double length = 5d;
	private Double height = 6d;
	private Double area; // l * h

	public Double calcualteArea() {
		area = length * height;
		return area;
	}

	// we will call this method to get area from outside of class.
	public Double getArea() {
		return calcualteArea(); // advised method called from within class
	}

}
