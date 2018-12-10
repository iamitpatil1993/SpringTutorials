/**
 * 
 */
package qualifiers.simple;

import org.springframework.stereotype.Component;

/**
 * @author amit
 * This is one of the bean which will implement Dessert and will be one of the candidate for ambgity created
 * at Dessert injection point.
 */

@Component
public class IceCream implements Dessert {

	// Nothing to do here
}
