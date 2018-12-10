/**
 * 
 */
package primarybean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author amit 
 * This is a bean which has injection point where ambiguity arises.
 *
 */

@Component
public class PrimaryBeanDemoBean {

	@Autowired
	private CacheManager cacheManager;

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

}
