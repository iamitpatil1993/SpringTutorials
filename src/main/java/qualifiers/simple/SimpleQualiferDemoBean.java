/**
 * 
 */
package qualifiers.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author amit 
 * This is a bean, which has injection point, injecting dessert. It
 *         will create ambiguity.
 *
 */

@Component
public class SimpleQualiferDemoBean {

	@Autowired
	@Qualifier("cold") // IceCream bean's qualifier is 'cold'. If we remove this line
					   // SimpleQualiferDemoBeanTest will break
	private Dessert dessert;

	public Dessert getDessert() {
		return dessert;
	}

	public void setDessert(Dessert dessert) {
	}

}
