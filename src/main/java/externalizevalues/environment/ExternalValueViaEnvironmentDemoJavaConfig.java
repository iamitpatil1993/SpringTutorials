/**
 * 
 */
package externalizevalues.environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author amit
 *
 */

@Configuration
@ComponentScan
@PropertySource(value = { "classpath:dataSource.properties", "classpath:app.properties" }) // Proeprties loaded in same
																							// order in which they
																							// declared here, property
																							// with same name will be
																							// overriden by files listed
																							// last.
public class ExternalValueViaEnvironmentDemoJavaConfig {

	/**
	 * We need to inject bean in order to use propertyPlace holders, in this commit
	 * it is useless and will be useful in propery placeholder examples. test cases
	 * in this commit will also succeed without the bean declaration.
	 * 
	 * @return
	 */
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
