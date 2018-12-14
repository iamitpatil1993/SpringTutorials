/**
 * 
 */
package externalizevalues.propertyplaceholder.annotationbased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author amit 
 * Java config to 
 * 	1. enable component scanning to discover ExternalValueViaProepertyPlaceholderDemoBean bean. 
 *  2. Add PropertySource 
 *  3. Configure PropertyPlaceholderConfigurer or PropertySourcePlaceholderConfigurer bean in order to use property
 *         place holders in code.
 */

@Configuration
@ComponentScan
@PropertySource(value = { "classpath:app.properties", "classpath:dataSource.properties" }) // becauuse of this order
																							// app.name will be 'core
																							// technologies' and not
																							// 'Spring Tutorials
public class ExternalValueViaPropertyPlaceholderDemoJavaConfig {

	/**
	 * We need to delare this or PropertyPlaceholderConfigurer bean in order to use
	 * property place holders in beans or javaconfig classes.
	 */
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
