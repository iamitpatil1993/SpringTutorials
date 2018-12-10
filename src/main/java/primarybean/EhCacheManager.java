/**
 * 
 */
package primarybean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author amit
 *
 */

@Component
@Primary // If we remove this, it will create ambiguity and PrimaryBeanDemoBeanTest will start failing
public class EhCacheManager implements CacheManager {

	// Nothing to do here for now
}
