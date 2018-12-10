/**
 * 
 */
package qualifiers.simple;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This is one of the bean which will implement Dessert and will be one of the candidate for ambgity created
 * at Dessert injection point.
 */

@Component
@Qualifier("cold")
public class IceCream implements Dessert {

	// Nothing to do here
}
