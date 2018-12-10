/**
 * 
 */
package qualifiers.simple;

import org.springframework.stereotype.Component;

import qualifiers.simple.customqualifiers.Baked;
import qualifiers.simple.customqualifiers.Soft;

/**
 * @author amit
 * This is one of the bean which will implement Dessert and will be one of the candidate for ambiguity created
 * at Dessert injection point.
 */

@Component
@Soft
@Baked // These qualifier should be something like characteristics of bean. These should not be implementation specific.
public class Cake implements Dessert {
	/// Nothing to do here
}
