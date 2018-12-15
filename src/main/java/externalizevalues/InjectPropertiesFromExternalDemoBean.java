/**
 * 
 */
package externalizevalues;

import java.util.Properties;

/**
 * @author amit 
 * This bean demonstrate, how to inject Properties from external
 *         properties file into Properties property of bean
 */

public class InjectPropertiesFromExternalDemoBean {

	private Properties externalProperties;

	public InjectPropertiesFromExternalDemoBean(Properties externalPropertis) {
		this.externalProperties = externalPropertis;
	}

	public Properties getExternalProperties() {
		return externalProperties;
	}

	public void setExternalProperties(Properties externalProperties) {
		this.externalProperties = externalProperties;
	}


}
