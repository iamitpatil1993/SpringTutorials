/**
 * 
 */
package externalizevalues.propertyplaceholder.xmlbased;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author amit 
 * This bean is to demonstrate use of property place holders to
 *         read/inject value(not a object ref.) from external value sources.
 *         This beans is targeting how to do it in xml based way.
 */

public class ExternalValueViaPropertyPlaceholderDemoBean implements InitializingBean {

	private String valueFromPropertyFile;
	private Integer numericValueFromPropertyFile;
	private String valueFromSystemEnvironmentVariables;
	private String valueFromJvmSystemProperties;

	public ExternalValueViaPropertyPlaceholderDemoBean(String valueFromPropertyFile,
			Integer numericValueFromPropertyFile, String valueFromSystemEnvironmentVariables,
			String valueFromJvmSystemProperties) {
		this.valueFromPropertyFile = valueFromPropertyFile;
		this.numericValueFromPropertyFile = numericValueFromPropertyFile;
		this.valueFromSystemEnvironmentVariables = valueFromSystemEnvironmentVariables;
		this.valueFromJvmSystemProperties = valueFromJvmSystemProperties;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if ("Core technologies".equals(valueFromPropertyFile) && 20 == numericValueFromPropertyFile
				&& "amipatil".equals(valueFromSystemEnvironmentVariables)
				&& "foo".equals(valueFromJvmSystemProperties)) {
			System.out.println("Bean initilized successfully");
		} else {
			System.out.println("Bean initlization error, bean :: " + this);
			
		}
	}

}
