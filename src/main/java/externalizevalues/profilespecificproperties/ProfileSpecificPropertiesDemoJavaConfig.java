/**
 * 
 */
package externalizevalues.profilespecificproperties;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author amit
 *
 */

@Configuration
@ComponentScan
//property-placeholder in this string will take value of 'spring.profiles.active' env or system property and will chose file based on generated file name.
// we just need to pass value for this property at runtime and we it will choose file accordingly. In same way we can use this property-placeholder to choose folder as well in similar way
@PropertySource(value = "classpath:externalizevalues/profilespecificproperties/db-${spring.profiles.active}.properties")  
public class ProfileSpecificPropertiesDemoJavaConfig {
	
	// Nothing to do here

}
