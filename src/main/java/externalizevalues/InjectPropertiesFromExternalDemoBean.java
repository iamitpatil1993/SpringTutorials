/**
 * 
 */
package externalizevalues;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

/**
 * @author amit 
 * This bean demonstrate, how to inject Properties from external
 *         properties file into Properties property of bean
 */

public class InjectPropertiesFromExternalDemoBean implements InitializingBean, ApplicationContextAware {

	private Properties externalProperties;
	private ApplicationContext applicationContext;

	public InjectPropertiesFromExternalDemoBean(Properties externalPropertis) {
		this.externalProperties = externalPropertis;
	}

	public Properties getExternalProperties() {
		return externalProperties;
	}

	public void setExternalProperties(Properties externalProperties) {
		this.externalProperties = externalProperties;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * Here, we are manually adding property source to environment object. 
	 */
	@Override
	public void afterPropertiesSet() throws Exception {

		// 1. ConfigurableEnvironment is used to manipulate Environment object i.e add/update/remove properties also manipulate profiles
		ConfigurableEnvironment configurableEnvironment = (ConfigurableEnvironment) applicationContext.getEnvironment();
		
		// 2. Create appropriate implenetation of PropertySource interface (based on source type properties file or map or system properties or env properties etc.)
		PropertySource propertiesSource = new PropertiesPropertySource("app.properties", externalProperties);
		MutablePropertySources mutablePropertySources = configurableEnvironment.getPropertySources();
		
		// 3. actually add propertySource to propertySources 
		mutablePropertySources.addLast(propertiesSource); // Watch we can add propertySource to existing property
															// sources at first/last or after/before existing, so order
															// always matters
	}

}
