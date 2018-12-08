/**
 * 
 */
package profiles;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author amit Class to enable component scanning
 */

@Configuration
@ComponentScan // by default it will start scanning from this package to all below packages so
				// profiles.annotationbased will be
//get scanned and beans in it will get discovered and no need to explicitly specify basePackages element
public class AnnotationBasedProfileJavaConfig {
	// NOthing to do here
}
