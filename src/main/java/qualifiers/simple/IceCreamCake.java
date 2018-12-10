/**
 * 
 */
package qualifiers.simple;

import org.springframework.stereotype.Component;

import qualifiers.simple.customqualifiers.Baked;
import qualifiers.simple.customqualifiers.Cold;
import qualifiers.simple.customqualifiers.Soft;

/**
 * @author amit
 * IceCreamCake is a real dessert type, it is cold and soft.
 *
 */

@Component
@Cold
@Soft
@Baked
public class IceCreamCake implements Dessert {

	// Nothing to do here
}
