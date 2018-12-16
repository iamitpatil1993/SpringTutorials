/**
 * 
 */
package spel.annotationbased;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author amit
 *
 */

@Configuration
@ComponentScan
@PropertySource(value = {"classpath:app.properties"})
public class SpringExpressionLanguageDemoJavaConfig {

	// Nothing to do here
}
