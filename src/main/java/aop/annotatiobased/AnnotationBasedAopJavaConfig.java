/**
 * 
 */
package aop.annotatiobased;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author amit
 *
 */

@Configuration
@ComponentScan
@EnableAspectJAutoProxy // This annotation needs to enable AspectJ annotations to actually work and
						// create aspects and bean proxies
public class AnnotationBasedAopJavaConfig {

	// Nothing to do here for now

}
