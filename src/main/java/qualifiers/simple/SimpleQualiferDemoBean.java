/**
 * 
 */
package qualifiers.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import qualifiers.simple.customqualifiers.Baked;
import qualifiers.simple.customqualifiers.Cold;
import qualifiers.simple.customqualifiers.Creamy;
import qualifiers.simple.customqualifiers.Soft;

/**
 * @author amit 
 * This is a bean, which has injection point, injecting dessert. It
 *         will create ambiguity.
 *
 */

@Component
public class SimpleQualiferDemoBean {

	/**
	 * Multiple qualifiers to narrow down the choice, instead of using direct implementation specific qualifier.
	 */
	@Autowired
	@Cold
	@Soft
	@Baked
	private Dessert icecreamCake;

	@Autowired
	@Soft
	@Baked
	private Dessert cake;
	
	@Autowired
	@Cold
	@Creamy
	private Dessert iceCream;

	public Dessert getIcecreamCake() {
		return icecreamCake;
	}

	public void setIcecreamCake(Dessert icecreamCake) {
		this.icecreamCake = icecreamCake;
	}

	public Dessert getCake() {
		return cake;
	}

	public void setCake(Dessert cake) {
		this.cake = cake;
	}

	public Dessert getIceCream() {
		return iceCream;
	}

	public void setIceCream(Dessert iceCream) {
		this.iceCream = iceCream;
	}

}
